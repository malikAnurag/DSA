package practice.DSA.Array2D;

/**
 * Print concentric rectangular pattern in a 2d matrix.
 */
public class PrettyPrint {

    public static void main(String[] args) {

        int[][] arr = prettyPrintArray(3);

        for(int i = 0 ; i< arr.length ; i++) {
            for(int j = 0 ; j < arr.length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] prettyPrintArray(int A) {

        A = 2 * A - 1;

        int[][] result = new int[A][A];

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                result[i][j] = 1 + Math.max(Math.abs(i - A / 2), Math.abs(j - A / 2));
            }
        }
        return result;
    }
}
