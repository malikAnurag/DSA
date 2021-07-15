package practice.DSA.BinarySearch.advanced;

/**
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * <p>
 * Example 2:
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 * <p>
 * Constraints:
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
 * 1 <= k <= n2
 * TODO : https://www.youtube.com/watch?v=F22d27HJsxg
 */
public class KthSmallestElementInMatrix$ {

    public static void main(String[] args) {

    }

    public static int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];

        while(lo < hi) {

            int mid = lo + (hi - lo) / 2;

            int count = lessEqual(matrix, mid);

            if(count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static int lessEqual(int[][] matrix, int target) {

        int count = 0, n = matrix.length, i = n - 1, j = 0;

        while(i >= 0 && j < n) {

            if(matrix[i][j] > target) {
                i--;
            } else {
                count = count + i + 1;
                j++;
            }
        }
        return count;

    }
}
