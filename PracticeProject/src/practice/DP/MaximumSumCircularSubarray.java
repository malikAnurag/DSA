package practice.DP;

/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and
 * the previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not
 * exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 * Example 1:
 * Input: nums = [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 *
 * Example 2:
 * Input: nums = [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 *
 * Example 3:
 * Input: nums = [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 *
 * Example 4:
 * Input: nums = [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 *
 * Example 5:
 * Input: nums = [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 */
public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
    }

    // So there are two cases.
    // Case 1. The first is that the subarray takes only a middle part, and we know how to find the max subarray sum.
    // Case 2. The second is that the subarray takes a part of head array and a part of tail array.
    // We can transfer this case to the first one.
    // The maximum result equals to the total sum minus the minimum subarray sum.

    public static int maxSubarraySumCircular(int[] nums) {

        int currSum = 0, maxSum = nums[0], currMin = 0, minSum = nums[0], total = 0;

        for(int i : nums) {

            currSum = Math.max(i, currSum + i);
            maxSum = Math.max(currSum, maxSum);

            currMin = Math.min(i, currMin + i);
            minSum = Math.min(currMin, minSum);

            total += i;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
