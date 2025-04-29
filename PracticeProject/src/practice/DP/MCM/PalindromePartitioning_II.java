package practice.DP.MCM;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example 1:
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * <p>
 * Example 2:
 * Input: s = "a"
 * Output: 0
 * <p>
 * Example 3:
 * Input: s = "ab"
 * Output: 1
 * <p>
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase English letters only.
 */
public class PalindromePartitioning_II {

    static int[][] dp = new int[2001][2001];
    static Boolean[][] palindrome = new Boolean[2001][2001];

    public static void main(String[] args) {

    }

    public static int minCut(String s) {

        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return solve(s, 0, s.length() - 1);
    }

    private static int solve(String s, int i, int j) {

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i >= j)
            return dp[i][j] = 0;
        else if (isPalindrome(s, i, j))
            return dp[i][j] = 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {

            int left, right;

            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = solve(s, i, k);
                dp[i][k] = left;
            }

            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = solve(s, k + 1, j);
                dp[k + 1][j] = right;
            }

            int temp = 1 + left + right;
            min = Math.min(temp, min);
        }
        return dp[i][j] = min;
    }

    private static boolean isPalindrome(String s, int i, int j) {

        if (i >= j) return true;

        if (palindrome[i][j] != null)
            return palindrome[i][j];

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return palindrome[i][j] = false;
            i++;
            j--;
        }
        return palindrome[i][j] = true;
    }
}
