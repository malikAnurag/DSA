package practice.ConcurrentSystems.rateLimiter.lockFree;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class LockFreeRateLimiter {

    private final ConcurrentHashMap<String, LockFreeTokenBucket> buckets;
    private final RateLimitConfig config;
    private final ScheduledExecutorService cleanupScheduler;
    private final AtomicBoolean running;

    public LockFreeRateLimiter(RateLimitConfig config) {

        this.config = config;
        this.buckets = new ConcurrentHashMap<>();
        this.running = new AtomicBoolean(true);

        // Start cleanup scheduler
        // Daemon thread: won't prevent JVM shutdown if main threads are done
        this.cleanupScheduler = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "rate-limiter-cleanup");
            t.setDaemon(true);  // Important: daemon threads don't block shutdown
            return t;
        });

        // Schedule periodic cleanup to remove stale buckets (memory management)
        cleanupScheduler.scheduleAtFixedRate(
                this::cleanupStaleBuckets,
                config.getCleanupInterval().toMillis(),
                config.getCleanupInterval().toMillis(),
                TimeUnit.MILLISECONDS
        );
    }

    /**
     * Convenience constructor with default config.
     */
    public LockFreeRateLimiter(double tokensPerSecond, long capacity) {
        this(new RateLimitConfig(tokensPerSecond, capacity));
    }

    /**
     * Attempts to acquire a permit for the given client.
     * Returns true if allowed, false if rate limited.
     */
    public boolean tryAcquire(String clientId) {

        if (!running.get()) {
            throw new IllegalStateException("RateLimiter is shut down");
        }

        // computeIfAbsent is atomic - prevents double bucket creation
        LockFreeTokenBucket bucket = buckets.computeIfAbsent(clientId, k -> new LockFreeTokenBucket(config.getCapacity(), config.getTokensPerSecond()));

        return bucket.tryAcquire();
    }

    /**
     * Attempts to acquire multiple permits for the given client.
     */
    public boolean tryAcquire(String clientId, int permits) {

        if (!running.get()) {
            throw new IllegalStateException("RateLimiter is shut down");
        }

        if (permits <= 0) {
            throw new IllegalArgumentException("permits must be positive");
        }

        LockFreeTokenBucket bucket = buckets.computeIfAbsent(clientId, k -> new LockFreeTokenBucket(config.getCapacity(), config.getTokensPerSecond()));

        return bucket.tryAcquire(permits);
    }

    /**
     * Returns information about a client's current rate limit state.
     */
    public RateLimitInfo getClientInfo(String clientId) {

        LockFreeTokenBucket bucket = buckets.get(clientId);

        if (bucket == null) {
            // No bucket = full capacity available
            return new RateLimitInfo(config.getCapacity(), config.getCapacity(), config.getTokensPerSecond());
        }
        return new RateLimitInfo(bucket.getAvailableTokens(), bucket.getCapacity(), bucket.getTokensPerSecond());
    }

    /**
     * Removes buckets that haven't been accessed recently.
     * Called periodically by the cleanup scheduler.
     * <p>
     * Why cleanup? Without it, buckets for one-time clients would accumulate
     * forever, causing memory leaks in long-running services.
     */
    private void cleanupStaleBuckets() {

        long now = System.nanoTime();
        long timeoutNanos = config.getInactivityTimeout().toNanos();

        // Thread-safe maps allow safe iteration during concurrent modification.
        // removeIf is atomic per-entry: either the entry is removed or it's not.
        buckets.entrySet().removeIf(entry -> {
            LockFreeTokenBucket bucket = entry.getValue();
            long lastAccess = bucket.getLastAccessTimeNanos();
            // Remove bucket if it hasn't been accessed within the timeout period
            return (now - lastAccess) > timeoutNanos;
        });
    }

    /**
     * Returns the number of active client buckets.
     * For monitoring purposes.
     */
    public int getActiveBucketCount() {
        return buckets.size();
    }

    /**
     * Shuts down the rate limiter.
     * Stops cleanup scheduler and clears buckets.
     */
    public void shutdown() {

        if (running.compareAndSet(true, false)) {
            cleanupScheduler.shutdown();
            try {
                if (!cleanupScheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                    cleanupScheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                cleanupScheduler.shutdownNow();
                Thread.currentThread().interrupt();
            }
            buckets.clear();
        }
    }
}