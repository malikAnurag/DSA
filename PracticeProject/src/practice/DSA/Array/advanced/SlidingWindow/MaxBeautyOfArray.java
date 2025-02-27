package practice.DSA.Array.advanced.SlidingWindow;

import java.util.Arrays;

/**
 * You are given a 0-indexed array nums and a non-negative integer k. In one operation, you can do the following:
 *
 * Choose an index i that hasn't been chosen before from the range [0, nums.length - 1].
 * Replace nums[i] with any integer from the range [nums[i] - k, nums[i] + k].
 *
 * The beauty of the array is the length of the longest subsequence consisting of equal elements.
 * Return the maximum possible beauty of the array nums after applying the operation any number of times.
 * Note that you can apply the operation to each index only once.
 * A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none)
 * without changing the order of the remaining elements.
 *
 * Example 1:
 * Input: nums = [4,6,1,2], k = 2
 * Output: 3
 * Explanation: In this example, we apply the following operations:
 * - Choose index 1, replace it with 4 (from range [4,8]), nums = [4,4,1,2].
 * - Choose index 3, replace it with 4 (from range [0,4]), nums = [4,4,1,4].
 * After the applied operations, the beauty of the array nums is 3 (subsequence consisting of indices 0, 1, and 3).
 * It can be proven that 3 is the maximum possible length we can achieve.
 *
 * Example 2:
 * Input: nums = [1,1,1,1], k = 10
 * Output: 4
 * Explanation: In this example we don't have to apply any operations.
 * The beauty of the array nums is 4 (whole array).
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * 0 <= nums[i], k <= 105
 */
public class MaxBeautyOfArray {

    public static void main(String[] args) {
        System.out.println(getMaxBeauty(new int[]{4, 6, 1, 2}, 2));
        System.out.println(getMaxBeauty(new int[]{1, 1, 1, 1}, 10));
    }

    // Sort the array and keep a sliding window using two pointers
    // If the min + k can overlap with max - k, all the numbers in between can also do the same
    // Shrink the window if that is not possible and maintain a max length of that window
    private static int getMaxBeauty(int[] nums, int k) {

        int right = 0;
        int ans = 0;

        Arrays.sort(nums);

        for(int left = 0 ; left < nums.length ; left++) {
            while(nums[left] - k > nums[right] + k)
                right++;
            ans = Math.max(ans, left - right + 1);
        }
        return ans;
    }
}
