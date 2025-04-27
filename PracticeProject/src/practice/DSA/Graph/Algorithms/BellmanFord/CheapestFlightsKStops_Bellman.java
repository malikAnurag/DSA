package practice.DSA.Graph.Algorithms.BellmanFord;

import java.util.Arrays;

/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a
 * flight from city fromi to city toi with cost pricei.
 * <p>
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 * <p>
 * Example 1:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation: The graph is shown.
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * <p>
 * Example 2:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation: The graph is shown.
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 * <p>
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
public class CheapestFlightsKStops_Bellman {

    public static void main(String[] args) {
        System.out.println(getCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(getCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }

    /*
     * The algorithm performs a series of iterations, where each iteration "relaxes" the edges and updates the shortest
     * known distances to the nodes.
     * The traditional Bellman-Ford algorithm would run for exactly n - 1 iterations (where n is the number of nodes),
     * since that’s the maximum number of edges that could form a path between any two nodes in a graph with n nodes
     *
     * In this case, you're specifically interested in finding the shortest path from a source city to a destination
     * city with at most k stops.
     *
     * A path with k stops has k + 1 flights (or edges). For example, if there are no stops, you have exactly 1 flight
     * from the source to the destination, which is 0 stops.
     *
     * To handle this, we need to account for all possible routes that have up to k stops, meaning the total number of
     * edges in the path can range from 0 (direct flight) to k edges (which means k + 1 total edges, or k stops).

    * E -> no. of flights , N -> no. of cities

      Time complexity: O((N+E)⋅K)

        - We are iterating over all the edges K + 1 times which takes O(E⋅K)
        - At the start and end of each iteration, we also swap distance arrays, which take O(N⋅K) time for all the iterations
        - This gives us a time complexity of O(E⋅K + N⋅K) = O((N+E)⋅K)

      Space complexity: O(N)

      We are using dist and temp arrays, which each require O(N) space.
    * */


    static int getCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Distance from source to all other nodes.
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Run only K + 1 times since we want the shortest distance in K hops
        for (int i = 0; i <= k; i++) {
            // Create a copy of dist vector.
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {// from, to, price
                if (dist[flight[0]] != Integer.MAX_VALUE) {
                    temp[flight[1]] = Math.min(temp[flight[1]], dist[flight[0]] + flight[2]);
                }
            }
            // Copy the temp array into dist.
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}