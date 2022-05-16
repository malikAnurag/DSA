package practice.DSA.Array.Advanced.Stocks;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class StockBuySellWithCooldown {

    public static void main(String[] args) {
        System.out.println("Max Profit : " + calculateMaxProfitWithCooldown(new int[]{1, 2, 3, 0, 2}));
    }

    /*
      sold[i] = hold[i−1] + price[i]
      held[i] = max(held[i−1], reset[i−1] − price[i])
      reset[i] = max(reset[i−1], sold[i−1])

      Here is how we interpret each formula:

      sold[i]: the previous state of sold can only be held. Therefore, the maximal profits of this state
      is the maximal profits of the previous state plus the revenue by selling the stock at the current price.

      held[i]: the previous state of held could also be held, i.e. one does no transaction.
      Or its previous state could be reset, from which state, one can acquire a stock at the current price point.

      reset[i]: the previous state of reset could either be reset or sold.
      Both transitions do not involve any transaction with the stock.
    */

    public static int calculateMaxProfitWithCooldown(int[] prices) {

        int held = Integer.MIN_VALUE, sold = Integer.MIN_VALUE, reset = 0;

        for(int price : prices) {

            int preSold = sold;

            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }
        return Math.max(sold, reset);
    }
}