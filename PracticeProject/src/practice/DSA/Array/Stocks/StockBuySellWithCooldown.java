package practice.DSA.Array.Stocks;

import java.util.HashMap;
import java.util.Map;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class StockBuySellWithCooldown {

    static Map<Integer, Integer> buyMap = new HashMap<>();
    static Map<Integer, Integer> sellMap = new HashMap<>();


    public static void main(String[] args) {

        System.out.println("Max Profit : " + buy(new int[]{1, 2, 3, 0, 2}, 0));
    }

    public static int buy(int[] prices, int i) {

        if(i >= prices.length) {
            return 0;
        }

        if(buyMap.containsKey(i))
            return buyMap.get(i);

        buyMap.put(i, Math.max(-prices[i] + sell(prices, i + 1), buy(prices, i+1)));
        return buyMap.get(i);
    }

    public static int sell(int[] prices, int i) {

        if(i >= prices.length) {
            return 0;
        }
        if(sellMap.containsKey(i))
            return sellMap.get(i);

        sellMap.put(i, Math.max(prices[i] + buy(prices, i + 2), sell(prices, i + 1)));
        return sellMap.get(i);
    }


}
