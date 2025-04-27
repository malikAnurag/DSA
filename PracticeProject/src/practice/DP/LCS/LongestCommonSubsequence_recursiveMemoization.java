package practice.DP.LCS;

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing
 * the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * <p>
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * <p>
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */
public class LongestCommonSubsequence_recursiveMemoization {

    static int[][] dp;

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "ace";
        int n1 = s1.length(), n2 = s2.length();

        dp = new int[n1 + 1][n2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(longestCommonSubsequence(s1, s2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text1.length(), text2, text2.length());
    }

    public static int lcs(String s1, int n1, String s2, int n2) {

        if (dp[n1][n2] != -1) { // if this sub-problem has been evaluated earlier
            return dp[n1][n2];
        }

        if (n1 == 0 || n2 == 0) {
            return dp[n1][n2] = 0;
        }

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return dp[n1][n2] = 1 + lcs(s1, n1 - 1, s2, n2 - 1);
        } else {
            return dp[n1][n2] = Math.max(lcs(s1, n1 - 1, s2, n2), lcs(s1, n1, s2, n2 - 1));
        }
    }
}
