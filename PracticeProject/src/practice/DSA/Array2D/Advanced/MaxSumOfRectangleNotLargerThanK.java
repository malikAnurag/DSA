package practice.DSA.Array2D.Advanced;

import java.util.TreeSet;
/**
 * Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 *
 * Example 1:
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
 *
 *  Example 2:
 * Input: matrix = [[2,2,-1]], k = 3
 * Output: 3
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 *
 * TODO : Refer to MaxSumOfRectangle.java
 *
 * Follow up: What if the number of rows is much larger than the number of columns?
 */
public class MaxSumOfRectangleNotLargerThanK {

    public static void main(String[] args) {
        System.out.println(findMaxSumRectangle(new int[][]{{1,0,1}, {0,-2,3}}, 2));
        System.out.println(findMaxSumRectangle(new int[][]{{2,2,-1}}, 3));
    }


    public static int findMaxSumRectangle(int[][] matrix, int k) {

        int L = 0, R = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        while(L < cols) {
            int[] arr = new int[rows];

            while(R < cols) {

                if(L == R) {
                    for(int i = 0; i < rows; i++) {
                        arr[i] = matrix[i][L];
                    }
                } else {
                    for(int i = 0; i < rows; i++) {
                        arr[i] += matrix[i][R];
                    }
                }
                maxSum = Math.max(maxSum, find(arr, k));
                R++;
            }
            L++;
            R = L;
        }
        return maxSum;
    }

    public static int find(int[] arr, int k) {

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        int prefixSum = 0, result = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            Integer target = ts.ceiling(prefixSum - k);

            if(target != null) {
                result = Math.max(result, prefixSum - target);
            }
            ts.add(prefixSum);
        }
        return result;
    }
}
