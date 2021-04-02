package practice.DSA.Array2D;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 */
public class TwoCityScheduling {

    public static void main(String[] args) {

        int[][] costs = new int[][] {{10,20},{30,200},{400,50},{30,20}};
        System.out.println("Minimum Cost : " + getMinimumCost(costs));
    }

    public static int getMinimumCost(int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });

        int minCost = 0;
        int N = costs.length;

        for(int i = 0 ; i < N/2 ; i++) {
            minCost += costs[i][0];
            minCost += costs[N/2 + i][1];
        }
        return minCost;
    }


}
