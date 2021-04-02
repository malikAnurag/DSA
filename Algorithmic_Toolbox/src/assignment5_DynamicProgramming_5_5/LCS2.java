package assignment5_DynamicProgramming_5_5;

import java.util.*;

/**
 * Find Longest subsequence of two sequences.
 * */


public class LCS2 {

   /* While traversing, if the last characters were equal, then add 1 to the last diagonal element.
        Else, take the max of upper and left block!!
    */
    private static int lcs2(int[] a, int[] b) {

        int[][] lcs = new int[a.length + 1][b.length + 1];

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (a[i - 1] == b[j - 1])
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                else
                    lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }

        return lcs[a.length][b.length];
    }

    public static int max(int x, int y) {
        return x >= y ? x : y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

