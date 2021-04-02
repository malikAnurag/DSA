package practice.DP;

import java.util.Arrays;

/**
 * Find minimum number of coins that make a given value
 *
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm}
 * valued coins, what is the minimum number of coins to make the change?
 *
 * Examples:
 *
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 *
 * Input: coins[] = {9, 6, 5, 1}, V = 11
 * Output: Minimum 2 coins required
 * We can use one coin of 6 cents and 1 coin of 5 cents
 */
// TODO: Refer minimumCoins.png

public class MinimumCoins {

    public static void main(String[] args) {

        int[] coins = {1, 5, 6, 9};
        int W = 11;
        System.out.println(getMinCoins(coins, W));
    }

    public static int getMinCoins(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int coin : coins) {
            for(int i = coin ; i<= amount ; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
