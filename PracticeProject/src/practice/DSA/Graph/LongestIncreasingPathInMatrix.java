package practice.DSA.Graph;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or
 * move outside the boundary (i.e., wrap-around is not allowed).
 *
 * Example 1:
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 *
 * Example 2:
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 * Example 3:
 * Input: matrix = [[1]]
 * Output: 1
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 */
public class LongestIncreasingPathInMatrix {

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println(getLongestIncreasingPath(new int[][] {{9,9,4}, {6,6,8}, {2,1,1}}));
        System.out.println(getLongestIncreasingPath(new int[][] {{3,4,5}, {3,2,6}, {2,2,1}}));
        System.out.println(getLongestIncreasingPath(new int[][] {{1}}));
    }

    static int getLongestIncreasingPath(int[][] matrix) {

        if(matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int longestPath = 0;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j, cache));
            }
        }
        return longestPath;
    }

    static int dfs(int[][] matrix, int i, int j, int[][] cache) {

        if(cache[i][j] > 0)
            return cache[i][j];

        int max = 0;

        for(int[] d : dir) {

            int x = d[0] + i;
            int y = d[1] + j;

            if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, x, y, cache));
            }
        }
        cache[i][j] = max + 1;
        return max + 1;
    }
}