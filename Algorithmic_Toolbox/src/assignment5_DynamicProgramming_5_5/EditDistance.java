package assignment5_DynamicProgramming_5_5;

import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        return getEditDistance(s, t, s.length(), t.length());
    }

    public static int getEditDistance(String str1, String str2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i - 1][j], // represents delete operation
                                        dp[i][j - 1], //  represents insert operation
                                        dp[i - 1][j - 1]); // represents replace operation
            }
        }
        return dp[n][m];
    }

    public static int min(int x, int y, int z) {
        if (x <= y && x <= z) return x;
        else if (y <= x && y <= z) return y;
        else return z;
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        System.out.println(EditDistance(s, t));
    }
}
