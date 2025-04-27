package practice.DP.Knapsack.zero_one;

/**
 * You are given n  objects, a knapsack of capacity c, array v, and array w. The ith object has value v[i] and weight w[i].
 * Determine the maximum total value that you can get by selecting objects in such a manner that their sum of weights is not greater than the capacity c.
 * <p>
 * Input format:
 * First line: Two integers n and c  denoting the number of objects and capacity of the knapsack ( 1 <= n <= 10^3 and  1 <= C <= 2*10^6 ) .
 * Second line:  n  integers  (0 <= Vi <= 50)
 * Third line:  n integers  ( 10 <=Wi <= 2*10^6)
 * <p>
 * Output format:
 * Print a single integer denoting the maximum value that you can get by selecting the objects.
 * <p>
 * Sample Input
 * 4 20
 * 10 2 1 3
 * 10 5 10 10
 * <p>
 * Sample Output
 * 13
 */

public class Knapsack_01_bottomUp {

    public static void main(String[] args) {

        int[] weight = new int[]{10, 5, 10, 10};
        int[] value = new int[]{10, 2, 1, 3};
        System.out.println(knapsack(value, weight, 4, 20));
    }

    static int knapsack(int[] value, int[] weight, int n, int w) {

        int[][] dp = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }
}