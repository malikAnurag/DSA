package practice.DP;

import java.util.Scanner;

public class EditDistanceClass {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        int dist = getEditDistance(str1, str2, str1.length(), str2.length());
        System.out.println("Edit Distance: " + dist);
    }

    public static int getEditDistance(String str1, String str2, int n, int m) {

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else
                    dp[i][j] = 1 + min(dp[i][j - 1],
							           dp[i - 1][j],
                            	       dp[i - 1][j - 1]);
            }
        }
        return dp[n][m];
    }

    static int min(int x, int y, int z) {
        if (x <= y && x <= z) return x;
        else if (y <= x && y <= z) return y;
        else return z;
    }
}
