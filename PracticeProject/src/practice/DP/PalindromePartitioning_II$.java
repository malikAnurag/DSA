package practice.DP;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 0
 *
 * Example 3:
 * Input: s = "ab"
 * Output: 1
 *
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 */
//TODO : https://www.youtube.com/watch?v=HUeUmrQy9cs
public class PalindromePartitioning_II$ {

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("ab"));
    }

    public static int minCut(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        boolean[][] dp = buildMatrix(s, n);
        int[] totalCuts = new int[n];

        for(int j = 0; j < n; j++) {

            int cut = j;

            for(int i = 0; i <= j; i++) {
                if(dp[i][j]) {
                    cut = Math.min(cut, i == 0 ? 0 : totalCuts[i - 1] + 1);
                }
            }
            totalCuts[j] = cut;
        }
        return totalCuts[n - 1];
    }

    static boolean[][] buildMatrix(String s, int n) {

        boolean[][] dp = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }
}
