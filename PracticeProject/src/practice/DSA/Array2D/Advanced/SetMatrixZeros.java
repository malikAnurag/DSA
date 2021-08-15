package practice.DSA.Array2D.Advanced;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 * You must do it in place.
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 * Follow up:
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        System.out.println("\nOriginal: \n");
        for(int[] row : matrix)
            System.out.println(Arrays.toString(row));

        System.out.println("\nChanged: \n");
        setZeroes(matrix);
        for(int[] row : matrix)
            System.out.println(Arrays.toString(row));

        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        System.out.println("\nOriginal: \n");
        for(int[] row : matrix)
            System.out.println(Arrays.toString(row));

        System.out.println("\nChanged: \n");
        setZeroes(matrix);
        for(int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    public static void setZeroes(int[][] matrix) {

        boolean firstRowHasZero = false, firstColumnHasZero = false;

        for(int i = 0 ; i < matrix.length ; i++) {
            if(matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        for(int j = 0 ; j < matrix[0].length ; j++) {
            if(matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int j = 1 ; j < matrix[0].length ; j++) {
            if(matrix[0][j] == 0) {
                int i = 0;
                while(i < matrix.length) {
                    matrix[i][j] = 0;
                    i++;
                }
            }
        }

        for(int i = 1 ; i < matrix.length ; i++) {
            if(matrix[i][0] == 0) {
                int j = 0;
                while(j < matrix[0].length) {
                    matrix[i][j] = 0;
                    j++;
                }
            }
        }
        if(firstRowHasZero) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstColumnHasZero) {
            for(int i = 0 ; i < matrix.length ; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}