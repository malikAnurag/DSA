package practice.DSA.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 *
 *  Example 2:
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
public class _01_Matrix {

    private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // Soluton: use BFS starting from each 0 cell and mark new length for each 1 cell
    // Note: Need a way to differentiate original 1 and distance 1
    public static int[][] updateMatrix(int[][] matrix) {

        Queue<Point> queue = new LinkedList<>();

        // Fill 1 with -1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = -1;
                } else {
                    queue.offer(new Point(i, j));
                }
            }
        }

        // BFS starting from each 0 cell
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                for (int[] dir : dirs) {
                    int ii = curPoint.x + dir[0];
                    int jj = curPoint.y + dir[1];

                    if (ii >= 0 && jj >= 0 && ii < matrix.length && jj < matrix[0].length) {
                        if (matrix[ii][jj] == -1) {
                            matrix[ii][jj] = length;
                            queue.offer(new Point(ii, jj));
                        }
                    }
                }
            }
        }
        return matrix;
    }
}
