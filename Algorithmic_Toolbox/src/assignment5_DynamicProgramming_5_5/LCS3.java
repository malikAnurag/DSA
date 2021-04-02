package assignment5_DynamicProgramming_5_5;

import java.util.*;

/*
 * Longest subsequence of three sequences.
 * While traversing, if the last characters were equal, then add 1 to the last diagonal element.
 * Else, take the max of upper and left block!!
 * */

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int A = a.length;
        int B = b.length;
        int C = c.length;

        int[][][] lcs = new int[A + 1][B + 1][C + 1];
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k <= C; k++) {
                    if (i == 0 || j == 0 || k == 0)
                        lcs[i][j][k] = 0;
                    else if (a[i - 1] == b[j - 1] && a[i - 1] == c[k - 1])
                        lcs[i][j][k] = 1 + lcs[i - 1][j - 1][k - 1];
                    else
                        lcs[i][j][k] = Math.max(Math.max(lcs[i - 1][j][k], lcs[i][j - 1][k]), lcs[i][j][k - 1]);
                }
            }
        }

        return lcs[A][B][C];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

