package practice.DSA.Graph.Algorithms.Dijkstra;

import java.util.*;

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
public class CheapestFlightsKStops_Dijsktra {

    public static void main(String[] args) {
        System.out.println(getCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(getCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }

    /*
    * E -> no. of flights , N -> no. of cities

      Time complexity: O(N + E⋅K⋅log(E⋅K))

      * Let's assume any node A is popped out of the queue in an iteration.
      * If the steps taken to visit A are more than stops[node], we do not iterate over the neighbors of A.
      * However, we will iterate over neighbors of A if the steps are less than stops[A], which can be true K times.
      * A can be popped the first time with K steps, followed by K-1 steps, and so on until 1 step.
      * The same argument would be valid for any other node like A.
      * As a result, each edge can only be processed K times, resulting in O(E⋅K) elements being processed.
      * It will take the priority queue O(E⋅K⋅log(E⋅K)) time to push or pop O(E⋅K) elements.
      * We've added O(N) time by using the stops array.

       * Space complexity: O(N + E⋅K)
       * We are using the adj array, which requires O(E) memory.
       * The stop array would require O(N) memory. As previously stated, the priority queue can only have O(E⋅K) elements.
    * */

    static int getCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[]{i[1], i[2]});

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {dist_from_src_node, node, number_of_stops_from_src_node}
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {

            int[] temp = pq.poll();
            int dist = temp[0];
            int node = temp[1];
            int steps = temp[2];
            // We have already encountered a path with a lower cost and fewer stops,
            // or the number of stops exceeds the limit.
            if (steps > stops[node] || steps > k + 1)
                continue;

            stops[node] = steps;

            if (node == dst)
                return dist;

            if (!adj.containsKey(node))
                continue;

            for (int[] a : adj.get(node)) {
                pq.offer(new int[]{dist + a[1], a[0], steps + 1});
            }
        }
        return -1;
    }
}