package practice.DSA.Array.advanced.SlidingWindow;

/**
 * Given an array of n integers, find the sub-array of length k with maximum sum.
 *
 * For example,
 * Input Array: {6, 4, 3, 5, 1, 9, 2}    k:3
 * Output: 15
 *
 * Input Array: {10, 20, 10, 40, 50, 10, 60}    k:3
 * Output: 120
 */
public class MaximumSumSubarrayOfSizeK {

    public static void main(String[] args) {
        System.out.println(getMaxSum(new int[]{6, 4, 3, 5, 1, 9, 2}, 3));
        System.out.println(getMaxSum(new int[]{10, 20, 10, 40, 50, 10, 60}, 3));
    }

    /* Sliding window technique */
    public static int getMaxSum(int[] nums, int k) {

        int windowSum = 0;
        int maxSum = 0;

        for(int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        for(int end = k; end < nums.length; end++) {
            windowSum += nums[end] - nums[end - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
