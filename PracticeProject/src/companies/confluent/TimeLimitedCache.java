package companies.confluent;

import java.util.*;

/**
 * Write a class that allows getting and setting key-value pairs, however a time until expiration is associated with each key.
 * <p>
 * The class has three public methods:
 * * set(key, value, duration): accepts an integer key, an integer value, and a duration in milliseconds. Once the duration has elapsed, the key should be inaccessible.
 * The method should return true if the same un-expired key already exists and false otherwise. Both the value and duration should be overwritten if the key already exists.
 * <p>
 * get(key): if an un-expired key exists, it should return the associated value. Otherwise it should return -1.
 * <p>
 * count(): returns the count of un-expired keys.
 * <p>
 * <p>
 * Example 1:
 * Input:
 * actions = ["TimeLimitedCache", "set", "get", "count", "get"]
 * values = [[], [1, 42, 100], [1], [], [1]]
 * timeDelays = [0, 0, 50, 50, 150]
 * Output: [null, false, 42, 1, -1]
 * Explanation:
 * At t=0, the cache is constructed.
 * At t=0, a key-value pair (1: 42) is added with a time limit of 100ms. The value doesn't exist so false is returned.
 * At t=50, key=1 is requested and the value of 42 is returned.
 * At t=50, count() is called and there is one active key in the cache.
 * At t=100, key=1 expires.
 * At t=150, get(1) is called but -1 is returned because the cache is empty.
 * <p>
 * Example 2:
 * Input:
 * actions = ["TimeLimitedCache", "set", "set", "get", "get", "get", "count"]
 * values = [[], [1, 42, 50], [1, 50, 100], [1], [1], [1], []]
 * timeDelays = [0, 0, 40, 50, 120, 200, 250]
 * Output: [null, false, true, 50, 50, -1, 0]
 * Explanation:
 * At t=0, the cache is constructed.
 * At t=0, a key-value pair (1: 42) is added with a time limit of 50ms. The value doesn't exist so false is returned.
 * At t=40, a key-value pair (1: 50) is added with a time limit of 100ms. A non-expired value already existed so true is returned and the old value was overwritten.
 * At t=50, get(1) is called which returned 50.
 * At t=120, get(1) is called which returned 50.
 * At t=140, key=1 expires.
 * At t=200, get(1) is called but the cache is empty so -1 is returned.
 * At t=250, count() returns 0 because the cache is empty.
 */


class CacheEntry { // Represents the current state of a key → value + expiration
    int value;
    long expireAt; // epoch millis
    int gen;       // tells the version of key's entry
}

class Exp implements Comparable<Exp> { // Represents an expiration event to help evict keys efficiently
    final long expireAt;
    final int key;
    final int gen;

    Exp(long expireAt, int key, int gen) {
        this.expireAt = expireAt;
        this.key = key;
        this.gen = gen;
    }

    @Override
    public int compareTo(Exp other) {
        return Long.compare(this.expireAt, other.expireAt);
    }
}

public class TimeLimitedCache {

    private final Map<Integer, CacheEntry> map = new HashMap<>();
    private final PriorityQueue<Exp> minHeap = new PriorityQueue<>();
    private int nextGen = 1;

    /**
     * Removes expired keys from the map using the min-heap.
     */
    private void evictExpired() {

        long now = System.currentTimeMillis();

        while (!minHeap.isEmpty() && minHeap.peek().expireAt <= now) {
            Exp top = minHeap.poll();
            CacheEntry cur = map.get(top.key);
            // Only remove if this heap record matches the current generation for the key.
            if (cur != null && cur.gen == top.gen && cur.expireAt <= now) {
                map.remove(top.key);
            }
        }
    }

    /**
     * Adds or updates a key with a time-to-live in milliseconds.
     */
    public boolean set(int key, int value, int durationMs) {

        evictExpired();

        long now = System.currentTimeMillis();
        long expireAt = now + durationMs;

        CacheEntry existing = map.get(key);
        boolean existedAndUnexpired = existing != null && existing.expireAt > now;

        CacheEntry e = new CacheEntry();
        e.value = value;
        e.expireAt = expireAt;
        e.gen = nextGen++;
        map.put(key, e);

        minHeap.offer(new Exp(expireAt, key, e.gen));
        return existedAndUnexpired;
    }

    /**
     * Returns the value if unexpired; otherwise -1.
     */
    public int get(int key) {

        evictExpired();

        CacheEntry e = map.get(key);

        if (e == null || e.expireAt <= System.currentTimeMillis()) {
            // Double-check in case it just expired
            map.remove(key);
            return -1;
        }
        return e.value;
    }

    /**
     * Returns the number of unexpired keys.
     */
    public int count() {
        evictExpired();
        return map.size();
    }

    public static void main(String[] args) throws InterruptedException {
        TimeLimitedCache c = new TimeLimitedCache();
        System.out.println(c.set(1, 42, 100)); // false
        Thread.sleep(50);
        System.out.println(c.get(1));          // 42
        System.out.println(c.count());         // 1
        Thread.sleep(60);
        System.out.println(c.get(1));          // -1

        System.out.println("==========");
        System.out.println(c.set(1, 42, 50));
        Thread.sleep(40);
        System.out.println(c.set(1, 50, 100));
        Thread.sleep(10);
        System.out.println(c.get(1));
        Thread.sleep(70);
        System.out.println(c.get(1));
        Thread.sleep(80);
        System.out.println(c.get(1));
        Thread.sleep(50);
        System.out.println(c.count());
    }
}

