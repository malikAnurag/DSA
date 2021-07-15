package practice.DSA.Array.advanced.Subarrays;

import java.util.TreeSet;

/**
 * Find the maximum subarray sum that is no larger than k.
 */
public class SubarraySumLessThanK {

    public static void main(String[] args) {
        System.out.println(getLargestSubarraySum(new int[] {1, 2, 3, 4, 5}, 11));
        System.out.println(getLargestSubarraySum(new int[] {2, 4, 6, 8, 10}, 7));
    }

    public static int getLargestSubarraySum(int[] arr, int k) {

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        int prefixSum = 0, result = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length ; i++) {

            prefixSum += arr[i];

            Integer target = ts.ceiling(prefixSum - k);

            if(target != null) {
                result = Math.max(result, prefixSum - target);
            }
            ts.add(prefixSum);
        }
        return result;
    }
}
