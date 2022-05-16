package practice.DSA.Array2D.Advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different:
 * for example, if x1 != x1'.
 *
 * Example 1:
 *  TODO : submatrix.png
 *
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.

 * Example 2:
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.

 * Example 3:
 * Input: matrix = [[904]], target = 0
 * Output: 0
 */
public class SubmatricesThatSumToTarget$ {

    public static void main(String[] args) {
        System.out.println(numSubmatrixSumTarget(new int[][]{{0,1,0},{1,1,1},{0,1,0}}, 0));
        System.out.println(numSubmatrixSumTarget(new int[][]{{1,-1},{-1,1}}, 0));
        System.out.println(numSubmatrixSumTarget(new int[][]{{904}}, 0));
    }

    public static int numSubmatrixSumTarget(int[][] A, int target) {

        int res = 0, rows = A.length, cols = A[0].length;

        for(int i = 0; i < rows; i++) {

            for(int j = 1; j < cols; j++) {
                A[i][j] += A[i][j - 1];
            }
        }

        Map<Integer, Integer> counter = new HashMap<>();

        for(int i = 0; i < cols; i++) {

            for(int j = i; j < cols; j++) {

                counter.clear();
                counter.put(0, 1);

                int cur = 0;

                for(int k = 0; k < rows; k++) {
                    cur += A[k][j] - (i > 0 ? A[k][i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}