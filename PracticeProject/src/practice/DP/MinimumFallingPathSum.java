package practice.DP;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 *
 * Example 1:
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 *
 * Example 2:
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 */
public class MinimumFallingPathSum {

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));
    }

    public static int minFallingPathSum(int[][] matrix) {

        int R = matrix.length, C = matrix[0].length;

        int[][] dp = new int[R][C];

        for(int j = 0 ; j < C ; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1 ; i < R ; i++) {

            for(int j = 0 ; j < C ; j++) {

                if(j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }

                else if(j == C - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j+1], dp[i-1][j-1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j = 0 ; j < C ; j++) {
            min = Math.min(min,dp[R-1][j]);
        }
        return min;
    }
}
