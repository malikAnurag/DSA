package practice.DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean"
 * touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 *
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *
 *
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class PacificAtlanticWaterFlow {

    static int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> res = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int row = matrix.length, col = matrix[0].length;

        boolean[][] atlantic = new boolean[row][col];
        boolean[][] pacific = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            dfs(matrix, row - 1, i, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < row; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, col - 1, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean) {

        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length)
            return;

        if (matrix[i][j] < prev || ocean[i][j])
            return;

        ocean[i][j] = true;
        for (int[] d : dir) {
            dfs(matrix, i + d[0], j + d[1], matrix[i][j], ocean);
        }
    }
}
