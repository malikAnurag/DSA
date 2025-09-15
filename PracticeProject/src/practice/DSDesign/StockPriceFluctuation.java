package practice.DSDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.
 * <p>
 * Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect.
 * Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.
 * <p>
 * Design an algorithm that:
 * Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
 * Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
 * Finds the maximum price the stock has been based on the current records.
 * Finds the minimum price the stock has been based on the current records.
 * Implement the StockPrice class:
 * <p>
 * StockPrice() Initializes the object with no price records.
 * void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
 * int current() Returns the latest price of the stock.
 * int maximum() Returns the maximum price of the stock.
 * int minimum() Returns the minimum price of the stock.
 * <p>
 * <p>
 * Example 1:
 * Input
 * ["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
 * [[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
 * Output
 * [null, null, null, 5, 10, null, 5, null, 2]
 * <p>
 * Explanation
 * StockPrice stockPrice = new StockPrice();
 * stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
 * stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
 * stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
 * stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
 * stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
 * // Timestamps are [1,2] with corresponding prices [3,5].
 * stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
 * stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
 * stockPrice.minimum();     // return 2, the minimum price is 2 at timestamp 4.
 */
public class StockPriceFluctuation {

    int latestTime;
    Map<Integer, Integer> timeToPrice;
    TreeMap<Integer, Integer> priceCount;

    public StockPriceFluctuation() {
        latestTime = 0;
        timeToPrice = new HashMap<>();
        priceCount = new TreeMap<>();
    }

    public void update(int timestamp, int price) {

        latestTime = Math.max(latestTime, timestamp);

        if (timeToPrice.containsKey(timestamp)) {

            int oldPrice = timeToPrice.get(timestamp);

            priceCount.put(oldPrice, priceCount.get(oldPrice) - 1);

            if (priceCount.get(oldPrice) == 0) {
                priceCount.remove(oldPrice);
            }
        }
        timeToPrice.put(timestamp, price);
        priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timeToPrice.get(latestTime);
    }

    public int maximum() {
        return priceCount.lastKey();
    }

    public int minimum() {
        return priceCount.firstKey();
    }
}
