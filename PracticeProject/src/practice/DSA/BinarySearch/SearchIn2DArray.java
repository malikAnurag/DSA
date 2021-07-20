package practice.DSA.BinarySearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class SearchIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7},
                                     {10, 11, 16, 20},
                                     {23, 30, 34, 60}};

        System.out.println(searchInMatrix(matrix, 3));
    }

    /* Flattening the 2D array into 1D and then applying binary search on it */
    public static boolean searchInMatrix(int[][] matrix, int target) {

        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = (rows * cols) - 1;

        while(start <= end) {

            int mid = (start + end) / 2;
            int newRow = mid / cols;
            int newCol = mid % cols;

            if(matrix[newRow][newCol] == target) {
                return true;
            }
            else if(matrix[newRow][newCol] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}
