package practice.DP.LCS;

/**
 * Given two strings s1 and s2, the task is to find the length of the shortest string that has both s1 and s2 as subsequences.
 * <p>
 * Examples:
 * Input: s1 = “geek”, s2 = “eke”
 * Output: 5
 * Explanation: String “geeke” has both string “geek” and “eke” as subsequences.
 * <p>
 * Input: s1 = “AGGTAB”, s2 = “GXTXAYB”
 * Output:  9
 * Explanation: String “AGXGTXAYB” has both string “AGGTAB” and “GXTXAYB” as subsequences.
 */
public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        System.out.println(getSuperSeqLength("geek", "eke"));
        System.out.println(getSuperSeqLength("AGGTAB", "GXTXAYB"));
    }

    private static int getSuperSeqLength(String s1, String s2) {

        /*
         * The idea is to subtract the length of LCS from the total combined length of both the strings
         * */

        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return n1 + n2 - dp[n1][n2];
    }
}
