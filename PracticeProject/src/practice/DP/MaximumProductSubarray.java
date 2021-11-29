package practice.DP;
/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.

 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {

        int mini        = nums[0];
        int maxi        = nums[0];
        int globalMax   = nums[0];

        for(int i = 1 ; i < nums.length ; i++) {

            int x = mini * nums[i];
            int y = maxi * nums[i];

            mini = Math.min(nums[i], Math.min(x, y));
            maxi = Math.max(nums[i], Math.max(x, y));

            globalMax = Math.max(globalMax, Math.max(mini, maxi));
        }
        return globalMax;
    }
}
