package practice.ConcurrentSystems.rateLimiter.lockFree;

public class RateLimitInfo {

    private final double remainingTokens;
    private final long capacity;
    private final double tokensPerSecond;

    public RateLimitInfo(double remainingTokens, long capacity, double tokensPerSecond) {
        this.remainingTokens = remainingTokens;
        this.capacity = capacity;
        this.tokensPerSecond = tokensPerSecond;
    }

    public double getRemainingTokens() {
        return remainingTokens;
    }

    public long getCapacity() {
        return capacity;
    }

    public double getTokensPerSecond() {
        return tokensPerSecond;
    }

    public double getResetTimeSeconds() {
        if (remainingTokens >= capacity) {
            return 0;
        }
        return (capacity - remainingTokens) / tokensPerSecond;
    }
}