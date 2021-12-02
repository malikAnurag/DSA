package practice.DSA.Graph.Algorithms;

/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a
 * flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 *
 * Example 1:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation: The graph is shown.
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 *
 * Example 2:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation: The graph is shown.
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 *
 * Constraints:
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * There will not be any multiple flights between two cities.
 * 0 <= src, dst, k < n
 * src != dst
 */
public class CheapestFlightsKStopsBellManFordAlgorithm {

    public static void main(String[] args) {
        System.out.println(getCheapestPrice(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        System.out.println(getCheapestPrice(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
    }


    static int getCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if(src == dst)
            return 0;

        int[] curr = new int[n];
        int[] prev = new int[n];

        for(int i = 0 ; i < n ; i++) {
            curr[i] = Integer.MAX_VALUE;
            prev[i] = Integer.MAX_VALUE;
        }

        prev[src] = 0;

        for(int i = 1; i < k + 2; i++) {

            curr[src] = 0;

            for(int[] flight : flights) {

                int prevFlight = flight[0];
                int currFlight = flight[1];
                int cost = flight[2];

                if(prev[prevFlight] < Integer.MAX_VALUE) {
                    curr[currFlight] = Math.min(curr[currFlight], prev[prevFlight] + cost);
                }
            }
            prev = curr.clone();
        }
        return curr[dst] != Integer.MAX_VALUE ? curr[dst] : -1;
    }
}