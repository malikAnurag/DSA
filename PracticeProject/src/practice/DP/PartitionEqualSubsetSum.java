package practice.DP;
/**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into
 * two subsets such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * Constraints:
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {1, 5, 11, 5}));
        System.out.println(canPartition(new int[] {1, 2, 3, 5}));
    }

    static boolean canPartition(int[] nums) {

        int sum = 0;
        int size = nums.length;

        for (int i : nums)
            sum += i;

        if (sum % 2 != 0)
            return false;

        boolean[][] dp = new boolean[size + 1][sum / 2 + 1];

        for (int i = 0; i <= size; i++)
            dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= nums[i - 1])
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[size][sum / 2];
    }
}