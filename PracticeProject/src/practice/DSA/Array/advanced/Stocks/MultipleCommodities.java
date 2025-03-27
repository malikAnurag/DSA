package practice.DSA.Array.advanced.Stocks;


// You are given the prices of a commodity for N days; You can purchase single quantity of commodity on any day and
// sell it on any other day.
// If you sell is in less than 5 days, the tax rate is 25% otherwise it is 15%
// Your aim is to maximize profit keeping in mind that tax rate varies based on when you sell it.
// e.g. [4, 3, 6, 3, 1, 8, 0, 4, 6]

/**
You are a commodity stock trader and you are given daily stock prices for C commodities for D days.
You can purchase single quantity of any one of the commodity on any day but you can sell any quantity of any
commodity on any given day.
Each commodity may be taxed at a short term rate S or long term rate L depending upon the commodity and number of days
N that you held it. Your aim is to maximize profit.

You are given -
Array of price array (C * D) - [][]
Array of tax rates (C * {N, S, L}) - [][3]
*/
class MultipleCommodities {

    // Function to calculate maximum profit
    public static int maximizeProfit(int[][] prices, int[][] taxRates) {
        int C = prices.length;  // Number of commodities
        int D = prices[0].length;  // Number of days

        // DP table to store the maximum profit for each commodity and day
        int[][] dp = new int[C][D];

        // Iterate through each commodity
        for (int c = 0; c < C; c++) {
            // Extract prices and tax rates for this commodity
            int[] commodityPrices = prices[c];
            int N = taxRates[c][0];  // Number of days for long-term tax
            int S = taxRates[c][1];  // Short-term tax rate
            int L = taxRates[c][2];  // Long-term tax rate

            // Iterate through each day to calculate maximum profit
            for (int d = 1; d < D; d++) {
                // Try to buy on any previous day and sell on day d
                for (int i = 0; i < d; i++) {
                    int holdingPeriod = d - i;
                    int tax = (holdingPeriod > N) ? L : S;  // Apply tax based on holding period

                    // Calculate the potential profit
                    int profit = commodityPrices[d] - commodityPrices[i] - tax;

                    // Update dp[c][d] with the maximum profit achievable
                    dp[c][d] = Math.max(dp[c][d], dp[c][i] + profit);
                }
            }
        }

        // Find the maximum profit across all commodities and days
        int maxProfit = 0;
        for (int c = 0; c < C; c++) {
            for (int d = 0; d < D; d++) {
                maxProfit = Math.max(maxProfit, dp[c][d]);
            }
        }
        return maxProfit;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Example prices for 2 commodities over 5 days
        int[][] prices = {
                {100, 120, 110, 130, 140},  // Commodity 0 prices over 5 days
                {90, 110, 100, 115, 125},   // Commodity 1 prices over 5 days
        };

        // Tax rates for each commodity: [N, S, L]
        int[][] taxRates = {
                {3, 10, 5},  // Commodity 0: N = 3, S = 10%, L = 5%
                {2, 8, 4},   // Commodity 1: N = 2, S = 8%, L = 4%
        };

        // Call the maximizeProfit function to get the result
        int result = maximizeProfit(prices, taxRates);

        // Output the result
        System.out.println("Maximum Profit: " + result);
    }
}