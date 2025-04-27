package practice.DP.LCS;

/**
 * Given two strings s1 and s2. The task is to remove/delete and insert the minimum number of characters from s1 to transform it into s2.
 * It could be possible that the same character needs to be removed/deleted from one point of s1 and inserted at another point.
 * <p>
 * Example 1:
 * Input: s1 = “heap”, s2 = “pea”
 * Output: 3
 * Explanation: Minimum Deletion = 2 and Minimum Insertion = 1
 * p and h are deleted from the heap, and then p is inserted at the beginning.
 * One thing to note, though p was required it was removed/deleted first from its position and then it was inserted into some other position.
 * Thus, p contributes one to the deletion count and one to the insertion count.
 * <p>
 * Input: s1 = “geeksforgeeks”, s2 = “geeks”
 * Output: 8
 * Explanation: 8 deletions, i.e. remove all characters of the string “forgeeks”.
 */
public class MinimumInsertionsDeletions {

    public static void main(String[] args) {
        System.out.println(getMinimumInsertionsDeletions("heap", "pea"));
        System.out.println(getMinimumInsertionsDeletions("geeksforgeeks", "geeks"));
    }

    private static int getMinimumInsertionsDeletions(String s1, String s2) {

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
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        /*
        * The idea is to first convert s1 to LCS and then LCS to s2
        * The conversion basically happens via LCS : s1 -> LCS -> s2
        * */

        int lcs = dp[n1][n2];
        int ops = 0;
        ops += s1.length() - lcs;
        ops += s2.length() - lcs;
        return ops;
    }
}
