package practice.DSA.Array.Advanced.Subarrays;

import java.util.TreeSet;

/**
 * Find the maximum subarray sum that is no larger than k.
 */
public class SubarraySumLessThanK {

    public static void main(String[] args) {
        System.out.println(getLargestSubarraySum(new int[] {1, 2, 3, 4, 5}, 11));
//        System.out.println(getLargestSubarraySum(new int[] {2, 4, 6, 8, 10}, 7));
    }

    public static int getLargestSubarraySum(int[] arr, int k) {

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        int prefixSum = 0, result = Integer.MIN_VALUE;

        for (int j : arr) {

            prefixSum += j;

            Integer target = ts.ceiling(prefixSum - k);

            if (target != null) {
                result = Math.max(result, prefixSum - target);
            }
            System.out.println("prefix sum : " + prefixSum + ", target: " + target + ", result: " + result);
            ts.add(prefixSum);
        }
        return result;
    }
}

/*
1 2 3 4 5, k = 11
* [0, 1, 3, 6, 10, ]
*
prefix sum : 1, target: 0, result: 1
prefix sum : 3, target: 0, result: 3
prefix sum : 6, target: 0, result: 6
prefix sum : 10, target: 0, result: 10
prefix sum : 15, target: 6, result: 10
10
* */
