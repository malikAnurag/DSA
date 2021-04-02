package practice.DP;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */
public class UniquePaths {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3,2));
        System.out.println(uniquePaths(7,3));
    }

    public static int uniquePaths(int m, int n) {

        int C = m;
        int R = n;

        int[][] dp = new int[R][C];

        for(int i = 0 ; i < R ; i++)
            dp[i][0] = 1;

        for(int j = 0 ; j < C ; j++)
            dp[0][j] = 1;

        for(int i = 1 ; i < R ; i++) {
            for(int j = 1; j < C ; j++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[R-1][C-1];
    }
}
