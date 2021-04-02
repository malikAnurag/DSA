package practice.DP;

import java.util.Arrays;

/**
 * Given a m * n matrix of ones and zeros, return how many square sub-matrices have all ones.
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 */
public class SquareSubmatrices {

    public static void main(String[] args) {


        int[][] matrix1 =    { {0,1,1,1},
                               {1,1,1,1},
                               {0,1,1,1} } ;

        int[][] matrix2 =    {  {1,0,1},
                                {1,1,0},
                                {1,1,0} } ;

        System.out.println("Number of square sub-matrices in matrix-1 having all ones : " + countSquareSubMatrices(matrix1));
        System.out.println("Number of square sub-matrices in matrix-2 having all ones : " + countSquareSubMatrices(matrix2));
    }


    public static int countSquareSubMatrices(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;
        int count = 0;
        int[][] result = new int[R + 1][C + 1];

        for (int[] arr : result)
            Arrays.fill(arr, 0);

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (matrix[i - 1][j - 1] != 0) {
                    result[i][j] = 1 + Math.min(result[i - 1][j], Math.min(result[i - 1][j - 1], result[i][j - 1]));
                    count += result[i][j];
                }
            }
        }

        for(int i = 0 ; i <= R ; i++) {
            for(int j = 0 ; j <= C ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return count;
    }


}
