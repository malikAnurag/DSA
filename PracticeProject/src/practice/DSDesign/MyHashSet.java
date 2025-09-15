package practice.DSDesign;

import java.util.LinkedList;


/*
 *   N - no of values
 *   K - no of predefined buckets [773]
 *
 *   Time Complexity : O ( N / K ) :
 *                               Even distribution : Avg size of each bucket = N/K
 *                               Worst case : Scan entire bucket, hence time complexity of O(N/K)
 *
 *   M - no of unique values inserted into hashSet
 *
 *   Space : O (K + M)
 *
 * */
public class MyHashSet {

    Bucket[] buckets;
    int range;

    public MyHashSet() {
        range = 773;
        buckets = new Bucket[range];
        for (int i = 0; i < range; i++) {
            buckets[i] = new Bucket();
        }
    }

    private int hash(int val) {
        return val % range;
    }

    public void add(int val) {
        int idx = hash(val);
        buckets[idx].add(val);
    }

    public void remove(int val) {
        int idx = hash(val);
        buckets[idx].remove(val);
    }

    public boolean contains(int val) {
        int idx = hash(val);
        return buckets[idx].contains(val);
    }

}

class Bucket {

    LinkedList<Integer> list;

    public Bucket() {
        list = new LinkedList<>();
    }

    public void add(Integer val) {
        int idx = list.indexOf(val);
        if (idx == -1) {
            list.addFirst(val);
        }
    }

    public boolean contains(Integer val) {
        int idx = list.indexOf(val);
        return idx != -1;
    }

    public void remove(Integer val) {
        list.remove(val);
    }
}