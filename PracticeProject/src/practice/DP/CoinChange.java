package practice.DP;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Example 4:
 * Input: coins = [1], amount = 1
 * Output: 1
 *
 * Example 5:
 * Input: coins = [1], amount = 2
 * Output: 2
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(getNumberOfCoins(new int[] {1, 2, 5}, 11));
        System.out.println(getNumberOfCoins(new int[] {2}, 3));
        System.out.println(getNumberOfCoins(new int[] {1}, 0));
        System.out.println(getNumberOfCoins(new int[] {1}, 1));
        System.out.println(getNumberOfCoins(new int[] {1}, 2));
    }

    static int getNumberOfCoins(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int coin : coins) {
            for(int i = coin ; i <= amount ; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}