package practice.DSA.Array.advanced.Subarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 * Example 1:
 * Input: nums = [1,-1,5,-2,3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 *
 *  Example 2:
 * Input: nums = [-2,-1,2,1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 */
public class MaximumSizeSubarrayOfSumK {

    public static void main(String[] args) {
        System.out.println(getMaxSize(new int[]{1,-1,5,-2,3}, 3));
        System.out.println(getMaxSize(new int[]{-2,-1,2,1}, 1));
        System.out.println(getMaxSize(new int[]{-1,1}, 1));
    }

    public static int getMaxSize(int[] nums, int k) {

        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(sum == k) {
                maxLen = i + 1;
            }
            else if(hm.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - hm.get(sum - k));
            }

            if(!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return maxLen;
    }
}
