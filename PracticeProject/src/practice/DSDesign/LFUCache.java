package practice.DSDesign;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache {

    Map<Integer, Pair1<Integer, Integer>> cache; // key -> <freq, val>
    Map<Integer, Set<Integer>> frequencies; // freq -> [keys]
    int size;
    int minf;

    public LFUCache(int capacity) {
        cache = new HashMap<Integer, Pair1<Integer, Integer>>();
        frequencies = new HashMap<Integer, Set<Integer>>();
        size = capacity;
        minf = 0;
    }

    private void insert(int key, int freq, int val) {
        cache.put(key, new Pair1<>(freq, val));
        frequencies.putIfAbsent(freq, new LinkedHashSet<>());
        frequencies.get(freq).add(key);
    }

    public int get(int key) {

        if (cache.containsKey(key)) {
            Pair1<Integer, Integer> frequencyAndValue = cache.get(key);
            int freq = frequencyAndValue.getKey();
            int val = frequencyAndValue.getValue();

            Set<Integer> keys = frequencies.get(freq);
            keys.remove(key);

            if (keys.isEmpty()) {
                frequencies.remove(freq);
                if (freq == minf) {
                    minf++;
                }
            }
            insert(key, freq + 1, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (size <= 0)
            return;

        if (cache.containsKey(key)) {
            Pair1<Integer, Integer> freqAndVal = cache.get(key);
            int freq = freqAndVal.getKey();
            cache.put(key, new Pair1<>(freq, value));
            get(key);
            return;
        }

        if (cache.size() == size) {
            Set<Integer> keys = frequencies.get(minf);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);

            if (keys.isEmpty()) {
                frequencies.remove(minf);
            }
        }
        minf = 1;
        insert(key, 1, value);
    }
}

class Pair1<K, V> {
    private final K key;
    private final V value;

    public Pair1(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

