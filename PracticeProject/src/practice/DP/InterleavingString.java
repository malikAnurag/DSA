package practice.DP;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 *  Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 *  Example 3:
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 */
public class InterleavingString {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        if((s1.length() + s2.length()) != s3.length())
            return false;

        int l1 = s1.length();
        int l2 = s2.length();

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];

        dp[0][0] = true;

        for(int i = 1; i < dp.length; i++) {
            if(s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for(int j = 1; j < dp[0].length; j++) {
            if(s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {

                if(s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }

                if(s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[l1][l2];
    }
}
