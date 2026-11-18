package practice.ConcurrentSystems.rateLimiter.lockFree;

import java.util.concurrent.atomic.AtomicLong;

public class LockFreeTokenBucket {

    // Precision multiplier to store fractional tokens as long
    private static final long PRECISION = 1_000_000L;

    private final AtomicLong tokens;
    private final AtomicLong lastRefillTimeNanos;
    private final AtomicLong lastAccessTimeNanos;
    private final long capacityScaled;
    private final double tokensPerSecond;

    public LockFreeTokenBucket(long capacity, double tokensPerSecond) {
        this.capacityScaled = capacity * PRECISION;
        this.tokens = new AtomicLong(capacityScaled);  // Start full
        this.tokensPerSecond = tokensPerSecond;
        long now = System.nanoTime();
        this.lastRefillTimeNanos = new AtomicLong(now);
        this.lastAccessTimeNanos = new AtomicLong(now);
    }

    /**
     * Attempts to acquire one token.
     * Uses CAS loop for lock-free operation.
     */
    public boolean tryAcquire() {
        return tryAcquire(1);
    }

    /**
     * Attempts to acquire multiple tokens.
     * Atomically refills and consumes in a single operation using CAS.
     */
    public boolean tryAcquire(int permits) {

        long permitsScaled = permits * PRECISION;

        // CAS retry loop: keeps trying until we either succeed or determine
        // there aren't enough tokens. Under low contention, succeeds first try.
        while (true) {
            long now = System.nanoTime();  // Monotonic clock (never goes backward)
            long currentTokens = tokens.get();       // Step 1: Read current state
            long lastRefill = lastRefillTimeNanos.get();

            // Step 2: Calculate what the token count SHOULD be after refill
            double elapsedSeconds = (now - lastRefill) / 1_000_000_000.0;
            long tokensToAdd = (long) (elapsedSeconds * tokensPerSecond * PRECISION);
            long newTokens = Math.min(capacityScaled, currentTokens + tokensToAdd);

            // Step 3: Check if enough tokens (may exit early without CAS)
            if (newTokens < permitsScaled) {
                // Update last access even on rejection (for cleanup tracking)
                lastAccessTimeNanos.set(now);
                return false;
            }

            // Step 4: Calculate post-consumption value
            long afterConsume = newTokens - permitsScaled;

            // Step 5: CAS - atomically update IF no one else changed it
            // This is the critical atomic operation that prevents races
            if (tokens.compareAndSet(currentTokens, afterConsume)) {
                // Success! Update timestamps (best effort, slight drift is acceptable)
                lastRefillTimeNanos.set(now);
                lastAccessTimeNanos.set(now);
                return true;
            }
            // CAS failed - another thread modified tokens between our read and CAS.
            // Loop back and retry with fresh values.
        }
    }

    /**
     * Returns current available tokens after refilling.
     * For monitoring and debugging.
     */
    public double getAvailableTokens() {
        long now = System.nanoTime();
        long currentTokens = tokens.get();
        long lastRefill = lastRefillTimeNanos.get();

        double elapsedSeconds = (now - lastRefill) / 1_000_000_000.0;
        long tokensToAdd = (long) (elapsedSeconds * tokensPerSecond * PRECISION);
        long available = Math.min(capacityScaled, currentTokens + tokensToAdd);

        return available / (double) PRECISION;
    }

    /**
     * Returns last access time in nanoseconds.
     * Used by cleanup to identify stale buckets.
     */
    public long getLastAccessTimeNanos() {
        return lastAccessTimeNanos.get();
    }

    /**
     * Returns capacity for informational purposes.
     */
    public long getCapacity() {
        return capacityScaled / PRECISION;
    }

    /**
     * Returns refill rate for informational purposes.
     */
    public double getTokensPerSecond() {
        return tokensPerSecond;
    }
}
