package practice.DSA.Array2D.Advanced.RangeSum;


//  Sum(OA) is the cumulative region sum to the top left corner of the rectangle.
//  Note that the region Sum(OA) is covered twice by both Sum(OB) and Sum(OC).
//  We could use the principle of inclusion-exclusion to calculate Sum(ABCD) as following:
//
//  Sum(ABCD) = Sum(OD) − Sum(OB) − Sum(OC) + Sum(OA)

public class RangeSumQuery2D {

    int[][] dp;

    public RangeSumQuery2D(int[][] matrix) {

        int rows = matrix.length, cols = matrix[0].length;

        dp = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] - dp[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
