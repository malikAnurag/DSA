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

        int columns = m;
        int rows = n;

        int[][] dp = new int[rows][columns];

        for(int i = 0 ; i < rows ; i++)
            dp[i][0] = 1;

        for(int j = 0 ; j < columns ; j++)
            dp[0][j] = 1;

        for(int i = 1 ; i < rows ; i++) {
            for(int j = 1; j < columns ; j++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[rows-1][columns-1];
    }
}
