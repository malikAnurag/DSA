package practice.DSA.PriorityQueue;

import java.util.PriorityQueue;

public class OrderBacklog {

    public int getNumberOfBacklogOrders(int[][] orders) {

        PriorityQueue<int[]> buyOrders = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellOrders = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        for (int[] order : orders) {

            int orderPrice = order[0];
            int amount = order[1];
            int type = order[2];

            //buy orders
            if (type == 0) {
                while (amount > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0] <= orderPrice) {
                    int[] sell = sellOrders.poll();
                    int matchAmount = Math.min(amount, sell[1]);
                    amount -= matchAmount;
                    sell[1] -= matchAmount;

                    if (sell[1] > 0)
                        sellOrders.add(sell);
                }
                if (amount > 0) {
                    buyOrders.add(new int[]{orderPrice, amount});
                }
            }
            // sell orders
            else if (type == 1) {
                while (amount > 0 && !buyOrders.isEmpty() && buyOrders.peek()[0] >= orderPrice) {
                    int[] buy = buyOrders.poll();
                    int matchAmount = Math.min(amount, buy[1]);
                    amount -= matchAmount;
                    buy[1] -= matchAmount;

                    if (buy[1] > 0)
                        buyOrders.add(buy);
                }
                if (amount > 0) {
                    sellOrders.add(new int[]{orderPrice, amount});
                }
            }
        }

        long total = 0;
        int MOD = 1_000_000_007;
        ;

        for (int[] order : buyOrders) total = (total + order[1]) % MOD;
        for (int[] order : sellOrders) total = (total + order[1]) % MOD;

        return (int) total;
    }
}
