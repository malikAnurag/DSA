package practice.DP.MCM;

/**
 * Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix is (arr[i-1] * arr[i]),
 * the task is to find the most efficient way to multiply these matrices together such that the total number of element multiplications is minimum.
 * When two matrices of size m*n and n*p when multiplied, they generate a matrix of size m*p and the number of multiplications performed is m*n*p.
 * <p>
 * Examples:
 * Input: arr[] = [2, 1, 3, 4]
 * Output: 20
 * Explanation: There are 3 matrices of dimensions 2×1, 1×3, and 3×4,
 * Let the input 3 matrices be M1, M2, and M3. There are two ways to multiply ((M1 x M2) x M3) and (M1 x (M2 x M3)),
 * Please note that the result of M1 x M2 is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix.
 * ((M1 x M2) x M3)  requires (2 x 1 x 3)  +  (2 x 3 x 4) = 30
 * (M1 x (M2 x M3))  requires (1 x 3 x 4) +  (2 x 1 x 4) = 20
 * The minimum of these two is 20.
 * <p>
 * Input: arr[] = [1, 2, 3, 4, 3]
 * Output: 30
 * Explanation: There are 4 matrices of dimensions 1×2, 2×3, 3×4, 4×3.
 * Let the input 4 matrices be M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1M2)M3)M4.
 * The minimum number is 1*2*3 + 1*3*4 + 1*4*3 = 30
 * <p>
 * Input: arr[] = [3, 4]
 * Output: 0
 * Explanation: As there is only one matrix so, there is no cost of multiplication.
 */
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 1, 3, 4}, 1, 3));
        System.out.println(solve(new int[]{1, 2, 3, 4, 3}, 1, 4));
        System.out.println(solve(new int[]{3, 4}, 1, 1));
    }

    private static int solve(int[] arr, int i, int j) {

        if (i >= j)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int t = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(min, t);
        }
        return min;
    }
}
