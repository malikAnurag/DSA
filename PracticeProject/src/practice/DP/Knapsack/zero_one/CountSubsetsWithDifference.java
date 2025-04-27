package practice.DP.Knapsack.zero_one;

/**
 * Given an array arr[] and a difference diff, find the number of subsets that array can be divided so that the difference between the two subset is equal to the given diff.
 * <p>
 * Example1:
 * Input:
 * Arr[] : {1,1,2,3}
 * diff: 1
 * Output: 3 [{1,2}, {1,3}], [{1,3}, {1,2}] , [{1,1,2}, {3}]
 */
public class CountSubsetsWithDifference {

    public static void main(String[] args) {
        System.out.println(getCount(new int[]{1, 1, 2, 3}, 1));
    }


    private static int getCount(int[] arr, int diff) {

        /*
         * S1 = Sum of first subset, S2 = sum of second subset
         *
         * S1 + S2 = totalSum [can be calculated]
         * S1 - S2 = diff [given]
         * (addition of two equations)
         * 2S1 = totalSum + diff => S1 = (totalSum + diff)/2 [subset sum problem]
         * */

        int totalSum = 0;

        for (int i : arr) {
            totalSum += i;
        }

        return getSubSetSumCount(arr, (totalSum + diff) / 2);
    }

    private static int getSubSetSumCount(int[] arr, int sum) {

        int n = arr.length;

        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
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
