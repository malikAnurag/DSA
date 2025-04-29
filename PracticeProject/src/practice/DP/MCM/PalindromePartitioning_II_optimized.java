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
public class PalindromePartitioning_II_optimized {

    static int[][] dp = new int[2001][2001];
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("ab"));
        System.out.println(minCut("a"));
    }

    public static int minCut(String s) {

        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return solve(s, 0, s.length() - 1, Integer.MAX_VALUE);
    }

    private static int solve(String s, int start, int end, int min) {

        if (dp[start][end] != -1)
            return dp[start][end];

        if (start >= end || isPalindrome(s, start, end))
            return dp[start][end] = 0;

        for (int k = start; k <= end; k++) {
            if (isPalindrome(s, start, k)) {
                int temp = 1 + solve(s, k + 1, end, min);
                min = Math.min(temp, min);
            }
        }
        return dp[start][end] = min;
    }

    private static boolean isPalindrome(String s, int i, int j) {

        if (i >= j)
            return true;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
