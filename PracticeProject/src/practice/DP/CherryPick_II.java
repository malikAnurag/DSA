package practice.DP;

/**
 * You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.
 * You have two robots that can collect cherries for you:
 *
 * Robot #1 is located at the top-left corner (0, 0), and
 * Robot #2 is located at the top-right corner (0, cols - 1).
 * Return the maximum number of cherries collection using both robots by following the rules below:
 *
 * From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
 * When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
 * When both robots stay in the same cell, only one takes the cherries.
 * Both robots cannot move outside of the grid at any moment.
 * Both robots should reach the bottom row in grid.
 *
 *
 * Example 1:
 * Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
 * Output: 24
 * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
 * Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
 * Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
 * Total of cherries: 12 + 12 = 24.
 *
 * Example 2:
 * Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
 * Output: 28
 * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
 * Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
 * Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
 * Total of cherries: 17 + 11 = 28.
 *
 * Constraints:
 * rows == grid.length
 * cols == grid[i].length
 * 2 <= rows, cols <= 70
 * 0 <= grid[i][j] <= 100
 */
public class CherryPick_II {

    public static void main(String[] args) {
        System.out.println(getNumberOfCherries(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}));
        System.out.println(getNumberOfCherries(new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}));
    }

    /* We move them synchronously, robot1 and robot2 will always be on the same row.
    * The DP state is simplified to (row, col1, col2), where (row, col1) represents the location of robot1, and (row, col2) represents the location of robot2.
    * Let dp(row, col1, col2) return the maximum cherries we can pick if robot1 starts at (row, col1) and robot2 starts at (row, col2).
    * */
    static int getNumberOfCherries(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                for(int k = 0 ; k < n ; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return findCherries(0, 0, n - 1, grid, dp);
    }

    static int findCherries(int row, int col1, int col2, int[][] grid, int[][][] cache) {

        if(col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }

        if(cache[row][col1][col2] != -1) {
            return cache[row][col1][col2];
        }

        int result = 0;

        result += grid[row][col1];

        if(col1 != col2) { // to avoid multiple additions if both of them are at the same location
            result += grid[row][col2];
        }

        if(row != grid.length - 1) {

            int max = 0;

            for(int i  = col1 - 1 ; i <= col1 + 1 ; i++) {
                for(int j = col2 - 1 ; j <= col2 + 1 ; j++) {
                    max = Math.max(max, findCherries(row + 1, i, j, grid, cache));
                }
            }
            result += max;
        }

        cache[row][col1][col2] = result;
        return result;
    }
}
