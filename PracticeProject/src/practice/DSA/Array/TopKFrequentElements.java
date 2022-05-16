package practice.DSA.Array;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> hm = new HashMap();

        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> al = new ArrayList();

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            al.add(entry);
        }

        al.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int[] result = new int[k];
        int counter = 0;

        for (Map.Entry<Integer, Integer> entry : al) {
            result[counter++] = entry.getKey();
            k--;
            if (k == 0)
                break;
        }
        return result;
    }
}
