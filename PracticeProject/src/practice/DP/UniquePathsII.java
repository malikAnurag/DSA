package practice.DP;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * Example 1:
 * TODO: robot1.png
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 *
 * Example 2:
 * TODO: robot2.png
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 */
public class UniquePathsII {

    public static void main(String[] args) {
        System.out.println("Unique Paths : " + getUniquePaths(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println("Unique Paths : " + getUniquePaths(new int[][]{{0, 1}, {0, 0}}));
    }

    public static int getUniquePaths(int[][] grid) {

        if(grid == null || grid[0][0] == 1)
            return 0;

        int width = grid[0].length;
        int[] dp = new int[width];

        dp[0] = 1;

        for(int[] row : grid) {
            for(int j = 0; j < width; j++) {
                if(row[j] == 1) {
                    dp[j] = 0;
                } else if(j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }
}
