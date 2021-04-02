package practice;

/**
 * n x n Matrix
 *
 * [1, 1, 1]
 * [1, 2, 3]
 * [1, 3, 6]
 *
 * Upwards and right movement allowed!!
 * Print the number of paths
 */

public class GreyOrange2 {

    public static void main(String[] args) {

//        int[][] grid = new int[][]

    }

    public static int countPaths(int[][] grid) {

        int n = grid.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.print(dp[i][j]);
            }
        }
        return dp[n][n];
    }

}
