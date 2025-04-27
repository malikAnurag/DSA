package practice.DP.LCS;

/**
 * Given a string s of length n, the task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome.
 * Note: The order of characters should be maintained.
 * <p>
 * Examples :
 * <p>
 * Input : s = “aebcbda”
 * Output : 2
 * Explanation: Remove characters ‘e’ and ‘d’. Resultant string will be “abcba” which is a palindromic string
 * <p>
 * <p>
 * Input : s = “geeksforgeeks”
 * Output : 8
 */

public class MinimumDeletionsToMakePalindrome {

    public static void main(String[] args) {
        System.out.println(getMinDeletions("aebcbda"));
        System.out.println(getMinDeletions("geeksforgeeks"));
    }

    public static int getMinDeletions(String s1) {

        int n = s1.length();
        String s2 = new StringBuilder(s1).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0 ; i <= n ; i++) {
            for(int j = 0 ; j <= n ; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        // Subtract the LCS of (s and reverse(s)){longest palindromic subsequence} from the length of s
        return s1.length() - dp[n][n];
    }

}
