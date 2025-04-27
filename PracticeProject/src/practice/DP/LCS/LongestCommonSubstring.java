package practice.DP.LCS;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(getLongestCommonSubstring("abcde", "ace"));
        System.out.println(getLongestCommonSubstring("GeeksforGeeks", "GeeksQuiz"));
        System.out.println(getLongestCommonSubstring("abcf", "abcdf"));
    }

    private static int getLongestCommonSubstring(String text1, String text2) {

        int result = 0;
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Base condition of recursive code is changed to the initialization
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
}
