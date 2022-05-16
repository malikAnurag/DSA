package practice.DSDesign;

import java.util.LinkedList;

/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap.
 * If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */
public class MyHashMap {

    LinkedList<Entry>[] map;
    public static int SIZE = 769; // preferred as a large prime number to avoid collisions in hashmap

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {

        int bucket = key % SIZE;

        if (map[bucket] == null) {
            map[bucket] = new LinkedList<>();
        }
        else {
            for (Entry entry : map[bucket]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
        }
        map[bucket].add(new Entry(key, value));// If not found in the existing entries then add a new entry to that bucket
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {

        int bucket = key % SIZE;
        LinkedList<Entry> entries = map[bucket];

        if (entries == null)
            return -1;

        for (Entry entry : entries) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {

        int bucket = key % SIZE;
        Entry toRemove = null;
        LinkedList<Entry> entries = map[bucket];

        if (entries == null)
            return;

        for (Entry entry : entries) {
            if (entry.key == key) {
                toRemove = entry;
            }
        }

        if (toRemove == null)
            return;

        map[bucket].remove(toRemove);
    }
}

class Entry {

    public int key;
    public int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

