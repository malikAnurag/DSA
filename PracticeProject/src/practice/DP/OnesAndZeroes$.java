package practice.DP;

/**
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 *
 * Example 1:
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 *
 *  Example 2:
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 */
public class OnesAndZeroes$ {

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int[] count = count(s);

            for (int zero = m; zero >= count[0]; zero--) {
                for (int one = n; one >= count[1]; one--) {
                    dp[zero][one] = Math.max(dp[zero - count[0]][one - count[1]] + 1, dp[zero][one]);
                }
            }
        }
        return dp[m][n];
    }

    private static int[] count(String s) {
        int[] count = new int[2];

        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
