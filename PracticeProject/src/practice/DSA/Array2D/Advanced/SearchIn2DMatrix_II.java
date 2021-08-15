package practice.DSA.Array2D.Advanced;
/**
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example 1:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 *  Example 2:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 */
/*

Time complexity : O(n+m)

The key to the time complexity analysis is noticing that, on every iteration (during which we do not return true) either row or col is is
decremented/incremented exactly once. Because row can only be decremented m times and col can only be incremented n times before causing
the while loop to terminate, the loop cannot run for more than n+m iterations.
Because all other work is constant, the overall time complexity is linear in the sum of the dimensions of the matrix.

Space complexity : O(1)
Because this approach only manipulates a few pointers, its memory footprint is constant.
* */
public class SearchIn2DMatrix_II {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int i = matrix.length - 1, j = 0;

        while(i >= 0 && j < matrix[0].length) {

            if(matrix[i][j] == target) {
                return true;
            }

            if(matrix[i][j] > target) {
                i--;
            } else if(matrix[i][j] < target) {
                j++;
            }
        }
        return false;
    }
}
