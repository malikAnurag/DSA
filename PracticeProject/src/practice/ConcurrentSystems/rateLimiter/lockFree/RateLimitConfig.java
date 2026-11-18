package practice.ConcurrentSystems.rateLimiter.lockFree;

import java.time.Duration;

public final class RateLimitConfig {

    private final double tokensPerSecond;
    private final long capacity;
    private final Duration cleanupInterval;
    private final Duration inactivityTimeout;

    public RateLimitConfig(double tokensPerSecond, long capacity) {
        this(tokensPerSecond, capacity, Duration.ofMinutes(1), Duration.ofMinutes(5));
    }

    public RateLimitConfig(double tokensPerSecond, long capacity, Duration cleanupInterval, Duration inactivityTimeout) {

        if (tokensPerSecond <= 0) {
            throw new IllegalArgumentException("tokensPerSecond must be positive");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.tokensPerSecond = tokensPerSecond;
        this.capacity = capacity;
        this.cleanupInterval = cleanupInterval;
        this.inactivityTimeout = inactivityTimeout;
    }

    public double getTokensPerSecond() {
        return tokensPerSecond;
    }

    public long getCapacity() {
        return capacity;
    }

    public Duration getCleanupInterval() {
        return cleanupInterval;
    }

    public Duration getInactivityTimeout() {
        return inactivityTimeout;
    }
}
