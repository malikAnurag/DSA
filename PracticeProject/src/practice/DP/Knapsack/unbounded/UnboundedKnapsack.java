package practice.DP.Knapsack.unbounded;

/**
 * Given a knapsack weight, say capacity and a set of n items with certain value val[i] and weight wt[i],
 * The task is to fill the knapsack in such a way that we can get the maximum profit.
 * This is different from the classical Knapsack problem, here we are allowed to use an unlimited number of instances of an item.
 * <p>
 * Examples:
 * Input: capacity = 100, val[]  = [1, 30], wt[] = [1, 50]
 * Output: 100
 * Explanation: There are many ways to fill knapsack.
 * 1) 2 instances of 50 unit weight item.
 * 2) 100 instances of 1 unit weight item.
 * 3) 1 instance of 50 unit weight item and 50 instances of 1 unit weight items.
 * We get maximum value with option 2.
 * <p>
 * Input: capacity = 8, val[] = [10, 40, 50, 70], wt[]  = [1, 3, 4, 5]
 * Output : 110
 * Explanation: We get maximum value with one unit of weight 5 and one unit of weight 3.
 */
public class UnboundedKnapsack {

    public static void main(String[] args) {
        System.out.println(getMaxValue(new int[]{1, 50}, new int[]{1, 30}, 100));
        System.out.println(getMaxValue(new int[]{1, 3, 4, 5}, new int[]{10, 40, 50, 70}, 8));
    }

    private static int getMaxValue(int[] wt, int[] val, int W) {

        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) { // no of items
            for (int j = 1; j <= W; j++) {// weight
                if (wt[i - 1] <= j) {
                    // just replace i - 1 with i in the following at ONE place
                    // it will mean that we don't want to skip the current item in our next iterations and DON'T mark it as processed
                    // so that the same can be reconsidered in the later iterations again
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

}
