package practice.DP.Knapsack.zero_one;

/**
 * Given an array arr[] of length n and an integer target, the task is to find the number of subsets with a sum equal to target.
 * <p>
 * Examples:
 * Input: arr[] = [1, 2, 3, 3], target = 6
 * Output: 3
 * Explanation: All the possible subsets are [1, 2, 3], [1, 2, 3] and [3, 3]
 * <p>
 * Input: arr[] = [1, 1, 1, 1], target = 1
 * Output: 4
 * Explanation: All the possible subsets are [1], [1], [1] and [1]
 */
public class CountOfSubsetsWithSum {

    public static void main(String[] args) {
        System.out.println(countSubsets(new int[]{1, 2, 3, 3}, 6));
        System.out.println(countSubsets(new int[]{1, 1, 1, 1}, 1));
    }

    private static int countSubsets(int[] arr, int sum) {

        int n = arr.length;

        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) { // no of items
            for (int j = 1; j <= sum; j++) { // weight
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
