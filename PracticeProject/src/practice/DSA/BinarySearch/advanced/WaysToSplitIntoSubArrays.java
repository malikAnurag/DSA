package practice.DSA.BinarySearch.advanced;

/**
 * A split of an integer array is good if:
 * <p>
 * The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
 * The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements in mid is less than or equal to the
 * sum of the elements in right.
 * Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large, return it modulo 109 + 7.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1]
 * Output: 1
 * Explanation: The only good way to split nums is [1] [1] [1].
 * <p>
 * Example 2:
 * Input: nums = [1,2,2,2,5,0]
 * Output: 3
 * Explanation: There are three good ways of splitting nums:
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 * <p>
 * Example 3:
 * Input: nums = [3,2,1]
 * Output: 0
 * Explanation: There is no good way to split nums.
 * <p>
 * <p>
 * Constraints:
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 104
 */

public class WaysToSplitIntoSubArrays {

    public int waysToSplit(int[] nums) {

        int n = nums.length;
        int MOD = 1_000_000_007;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long count = 0;

        for (int i = 0; i < n - 2; i++) {

            int leftSum = prefix[i];

            int j = findLowerBound(prefix, i + 1, n - 2, leftSum, i);
            int k = findUpperBound(prefix, i + 1, n - 2, prefix[n - 1], i);

            if (j != -1 && k != -1 && j <= k) {
                count = (count + (k - j + 1)) % MOD;
            }
        }
        return (int) count;
    }

    private int findLowerBound(int[] prefix, int low, int high, int leftSum, int i) {

        int ans = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int midSum = prefix[mid] - prefix[i];

            if (midSum >= leftSum) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int findUpperBound(int[] prefix, int low, int high, int totalSum, int i) {

        int ans = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int midSum = prefix[mid] - prefix[i];
            int rightSum = totalSum - prefix[mid];

            if (midSum <= rightSum) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

}
