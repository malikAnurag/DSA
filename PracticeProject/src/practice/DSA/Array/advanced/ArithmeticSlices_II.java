package practice.DSA.Array.Advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and
 * if the difference between any two consecutive elements is the same.
 *
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The test cases are generated so that the answer fits in 32-bit integer.
 *
 * Example 1:
 * Input: nums = [2,4,6,8,10]
 * Output: 7
 * Explanation: All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 *
 * Example 2:
 * Input: nums = [7,7,7,7,7]
 * Output: 16
 * Explanation: Any subsequence of this array is arithmetic.
 */
public class ArithmeticSlices_II {

    public static void main(String[] args) {

        System.out.println(numberOfArithmeticSlices(new int[] {2,4,6,8,10}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {

        int ans = 0;
        Map<Integer,Integer>[] hm = new Map[nums.length];

        for(int i = 0 ; i < nums.length ; i++) {

            hm[i] = new HashMap();

            for(int j = 0 ; j < i ; j++) {

                long diff = (long) nums[j] - nums[i];

                if(diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) continue;

                // If the map at index j exists, extract the frequency and update the result
                // Also, update the freq against the same diff at i-th index as well
                int dif = (int) diff;
                int n1 = hm[j].getOrDefault(dif, 0);
                int n2 = hm[i].getOrDefault(dif, 0);

                ans += n1;

                hm[i].put(dif, n1+n2+1);
            }
        }
        for(Map<Integer, Integer> h : hm)
            System.out.println(h);
        return ans;
    }
}