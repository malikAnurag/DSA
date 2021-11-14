package practice.DP;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 * Example 1:
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubq("bbbab"));
        System.out.println(longestPalindromicSubq("cbbd"));
    }

    // The solution of this problem is the LCS of s(given string) and reverse(s)!

    /*
    * Theorem 1: LCS of s and reverse(s) is the longest subsequence palindrome of s.
    *
    * Lemma 1: Every subsequence palindrome of s is a common subsequence of s and reverse(s)
    *
    * This follows from definitions of palindrome and common subsequence. If a[0] .. a[n] is a palindrome of s, then reverse(s) will have a[n] .. a[0] as a subsequence.
    * By definition of palindrome, a[0] matches a[n], a[1] matches a[n-1] and so on.
    * So, a[0] .. a[n] is a common subsequence of s and reverse(s).
    *
    * Proof of Theorem1:
    * Now given Lemma 1, we can prove Theorem 1 by contradiction. Assume there is a subsequence palindrome of s (call it x) which is longer than LCS of s and reverse(s) (call that LCS y).
    * So, by assumption, we have len(x) > len(y).
    * However, by Lemma 1 we know that x is a common subsequence of s and reverse(s).
    * So, by definition of LCS len(y) >= len(x).
    * This is a contradiction and proves Theorem 1.
    * */
    static int longestPalindromicSubq(String s) {

        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];

        String reverse = new StringBuilder(s).reverse().toString();

        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= len; j++) {
                if(s.charAt(i - 1) == reverse.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len][len];
    }
}
