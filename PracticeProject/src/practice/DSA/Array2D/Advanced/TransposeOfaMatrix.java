package practice.DSA.Array2D.Advanced;

import java.util.Arrays;

public class TransposeOfaMatrix {

    public static void main(String[] args) {

        int[][] org = new int[][] {{1,1,1,1}, {2,2,2,2}, {3,3,3,3}, {4,4,4,4}};

        System.out.println("Original Array: ");
        for (int[] arr : org) {
            System.out.println(Arrays.toString(arr));
        }

        int[][] transpose = transpose(org);

        System.out.println("\nTransposed array: ");

        for (int[] arr : transpose) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

}
