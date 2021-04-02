package practice.LeetCodePending;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

    public static void main(String[] args) {

        System.out.println("Number of perfect squares required for 12: " + findSquares(12));
        System.out.println("Number of perfect squares required for 13: " + findSquares(13));
    }

    public static int findSquares(int n) {

        if(n < 4)
            return n;

        int[] dp = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0 ; dp[1] = 1; dp[2] = 2; dp[3] = 3;

        for(int i = 4 ; i <= n ; i++) {
            for(int j = 1 ; j * j <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
