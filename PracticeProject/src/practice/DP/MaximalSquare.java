package practice.DP;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {

    public static void main(String[] args) {

        char[][] matrix = { {'1', '0', '1', '0', '0'},
                            {'1', '0', '1', '1', '1'},
                            {'1', '1', '1', '1', '1'},
                            {'1', '0', '0', '1', '0'} };

        System.out.println("\nMaximum Area: " + findMaxArea(matrix));
    }

    public static int findMaxArea(char[][] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int R = arr.length;
        int C = arr[0].length;
        int[][] dp = new int[R][C];

        for (int i = 0; i < R; i++)
            dp[i][0] = arr[i][0] - '0';

        for (int i = 0; i < C; i++)
            dp[0][i] = arr[0][i] - '0';

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (arr[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return maxArea;
    }
}
