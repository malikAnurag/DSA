package practice.DP;
/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 *
 * Example 1:
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
 *
 *  Example 2:
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 *
 * Constraints:
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(getMinCost(new int[]{10, 15, 20}));
        System.out.println(getMinCost(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int getMinCost(int[] cost) {

        int curr;
        int twoStepsBefore = cost[0];
        int oneStepBefore = cost[1];

        for(int i = 2; i < cost.length; i++) {
            curr = cost[i] + Math.min(twoStepsBefore, oneStepBefore);
            twoStepsBefore = oneStepBefore;
            oneStepBefore = curr;
        }
        return Math.min(oneStepBefore, twoStepsBefore);
    }
}
