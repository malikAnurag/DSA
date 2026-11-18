package practice.ConcurrentSystems.rateLimiter.fineGrained;

import java.util.concurrent.locks.ReentrantLock;

class FineGrainedTokenBucket {

    private final ReentrantLock lock = new ReentrantLock();
    private double tokens;
    private final long capacity;
    private final double tokensPerSecond;
    private long lastRefillTime;

    public FineGrainedTokenBucket(long capacity, double tokensPerSecond) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.tokensPerSecond = tokensPerSecond;
        this.lastRefillTime = System.nanoTime();
    }

    public boolean tryAcquire() {
        lock.lock();
        try {
            refill();  // Calculate tokens earned since last access
            if (tokens >= 1) {
                tokens -= 1;  // Consume one token
                return true;  // Request allowed
            }
            return false;  // Insufficient tokens, reject request
        } finally {
            lock.unlock();  // Always release lock, even on exception
        }
    }

    private void refill() {
        long now = System.nanoTime(); // current time
        double elapsed = (now - lastRefillTime) / 1_000_000_000.0; // seconds passed since last update
        double tokensToAdd = elapsed * tokensPerSecond; // new tokens earned during the elapsed time

        tokens = Math.min(capacity, tokens + tokensToAdd); // adds new tokens with max as capacity
        lastRefillTime = now;
    }
}
