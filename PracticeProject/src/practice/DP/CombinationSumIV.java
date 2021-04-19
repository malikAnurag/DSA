package practice.DP;

/**
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 *
 * Example 2:
 *
 * Input: nums = [9], target = 3
 * Output: 0
 */
public class CombinationSumIV {

    public static void main(String[] args) {
        System.out.println(getTotalCombinations(new int[]{1, 2, 3}, 4));
        System.out.println(getTotalCombinations(new int[]{9}, 3));
    }

    public static int getTotalCombinations(int[] arr, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i = 1; i <= target; i++) {
            for(int n : arr) {
                if(i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
