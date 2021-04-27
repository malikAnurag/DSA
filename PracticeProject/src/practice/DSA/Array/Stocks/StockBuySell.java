package practice.DSA.Array.Stocks;

/**
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying
 * and selling in those days.
 */

import java.util.ArrayList;

class Interval {
    int buy, sell;
}

class StockBuySell {

    ArrayList<Interval> stockBuySell(int price[], int n) {

        if (n == 1)
            return null;

        int count = 0;

        ArrayList<Interval> sol = new ArrayList<>();

        int i = 0;
        while (i < n) {

            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i] >= price[i + 1]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;

            // Find Local Maxima. Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i - 1] <= price[i]))
                i++;

            e.sell = i - 1;
            sol.add(e);

            count++;
        }

        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        + "	 "
                        + "Sell on day : " + sol.get(j).sell);

        return sol;
    }

    public static void main(String args[]) {
        StockBuySell stock = new StockBuySell();

        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        ArrayList<Interval> result = stock.stockBuySell(price, n);
        int profit = 0;

        for (Interval i : result) {
            profit += price[i.sell] - price[i.buy];
        }
        System.out.println("Maximum Profit : " + profit);
    }
}