package practice.ConcurrentSystems.rateLimiter.fineGrained;


import java.util.concurrent.ConcurrentHashMap;

public class FineGrainedRateLimiter {

    private final long capacity;
    private final double tokensPerSecond;
    private final ConcurrentHashMap<String, FineGrainedTokenBucket> buckets = new ConcurrentHashMap<>();

    public FineGrainedRateLimiter(double tokensPerSecond, long capacity) {
        this.tokensPerSecond = tokensPerSecond;
        this.capacity = capacity;
    }

    public boolean tryAcquire(String clientId) {

        // Thread-safe map handles concurrent get-or-create atomically
        // No global lock needed for lookup/insertion

        FineGrainedTokenBucket bucket = buckets.computeIfAbsent(clientId, k -> new FineGrainedTokenBucket(capacity, tokensPerSecond));   // Only called once per key

        // Each bucket has its own lock, so different clients don't block each other
        return bucket.tryAcquire();
    }
}


