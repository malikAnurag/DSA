package practice.DSA.Graph.BFS;

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
public class CheapestFlightsKStops_BFS {

    public static void main(String[] args) {
        System.out.println(getCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(getCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }

    /*
    * Let E be the number of flights and N be the number of cities ; K -> no. of stops

        Time complexity: O(N + E⋅K)

       - Depending on improvements in the shortest distance for each node, we may process each edge multiple times.
       - However, the maximum number of times an edge can be processed is limited by K because that is the number of levels
         we will investigate in this algorithm. In the worst case, this takes O(E⋅K) time.
       - We also need O(E) to initialize the adjacency list and O(N) to initialize the dist array

        Space complexity: O(N + E⋅K)

        - We are processing at most E⋅K edges, so the queue takes up O(E⋅K) space in the worst case
        - We also need O(E) space for the adjacency list and O(N) space for the dist array.
    *
    * */

    static int getCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], t -> new ArrayList<>()).add(new int[]{flight[1], flight[2]}); // src -> dst, price
        }

        dist[src] = 0;
        q.add(new int[]{src, 0}); // city, price
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();
                int node = curr[0];
                int d = curr[1];

                if (!graph.containsKey(node))
                    continue;

                for (int[] neighbor : graph.get(node)) {

                    if (dist[neighbor[0]] > d + neighbor[1]) {
                        dist[neighbor[0]] = d + neighbor[1];
                        q.add(new int[]{neighbor[0], dist[neighbor[0]]});
                    }
                }
            }
            stops++;
        }
        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}