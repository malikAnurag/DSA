package practice.DSA.Array2D.Advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int dir = 1, col1 = 0, col2 = matrix[0].length - 1, row1 = 0, row2 = matrix.length - 1;

        List<Integer> al = new ArrayList();

        while(col1 <= col2 && row1 <= row2) {

            if(dir == 1) {
                for(int i = col1 ; i <= col2 ; i++) {
                    al.add(matrix[row1][i]);
                }
                row1++;
            }
            else if(dir == 2) {
                for(int i = row1 ; i <= row2 ; i++) {
                    al.add(matrix[i][col2]);
                }
                col2--;
            }
            else if(dir == 3) {
                for(int i = col2 ; i >= col1; i--) {
                    al.add(matrix[row2][i]);
                }
                row2--;
            }
            else {
                for(int i = row2 ; i >= row1 ; i--) {
                    al.add(matrix[i][col1]);
                }
                col1++;
            }

            dir = (dir + 1) % 4;
        }
        return al;
    }
}
