package practice.DSA.DSDesign;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * 1. insert(val): Inserts an item val to the set if not already present and returns a boolean.
 * 2. remove(val): Removes an item val from the set if present and returns a boolean.
 * 3. getRandom: Returns a random element from current set of elements. Each element must have the same probability
 * of being returned.
 */


public class InsertDeleteGetRandomDS {

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}


class RandomizedSet {

    Set<Integer> hs;

    public RandomizedSet() {
        hs = new HashSet<Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return hs.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return hs.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

        Random rand = new Random();
        int index = rand.nextInt(hs.size());
        return (int) hs.toArray()[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */