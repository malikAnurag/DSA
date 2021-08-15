package practice.DP;

/**
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 *
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 * A[i] == B[j];
 *
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 *
 * Return the maximum number of connecting lines we can draw in this way.
 */
public class UncrossedLines {

    public static void main(String[] args) {

        int[] A = new int[]{1, 4, 2};
        int[] B = new int[]{1, 2, 4};

        System.out.println("Number of uncrossed lines: " + getUncrossedLines(A, B));
    }


    public static int getUncrossedLines(int[] A, int[] B) {

        int[][] dp = new int[A.length + 1][B.length + 1];

        // Here dp[i][j] means taking i elements from A and j elements from B

        for(int i = 1; i <= A.length; i++) {

            for(int j = 1; j <= B.length; j++) {

                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // we need to leave the current elements(i-1,j-1) and
                    //  check the results of elements till i-1 and j-1 in the table
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        return dp[A.length][B.length];
    }
}
