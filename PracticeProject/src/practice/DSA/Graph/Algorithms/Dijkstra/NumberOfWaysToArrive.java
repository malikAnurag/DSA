package practice.DSA.Graph.Algorithms.Dijkstra;

import java.util.*;

/**
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections.
 * The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
 * <p>
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that
 * takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
 * Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
 * <p>
 * Example 1:
 * Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * Output: 4
 * Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
 * The four ways to get there in 7 minutes are:
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 * <p>
 * Example 2:
 * Input: n = 2, roads = [[1,0,10]]
 * Output: 1
 * Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 * <p>
 * Constraints:
 * 1 <= n <= 200
 * n - 1 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 3
 * 0 <= ui, vi <= n - 1
 * 1 <= timei <= 109
 * ui != vi
 * There is at most one road connecting any two intersections.
 * You can reach any intersection from any other intersection.
 */
public class NumberOfWaysToArrive {

    public int countPaths(int n, int[][] roads) {

        final int MOD = 1_000_000_007;

        if(roads == null || roads.length == 0 || roads.length == 1) {
            return 1;
        }

        Map<Integer, List<int[]>> graph = new HashMap<>();

        // N - Vertices ; E - Edges
        for(int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        int[] pathCount = new int[n];
        Queue<long[]> pq = new PriorityQueue<long[]>((a,b) -> Long.compare(a[1], b[1]));

        shortestTime[0] = 0;
        pathCount[0] = 1;
        pq.add(new long[]{0, 0});// node, time

        while(!pq.isEmpty()) {
            long[] curr = pq.poll();

            int currNode = (int)curr[0];
            long currTime = curr[1];

            if(currTime > shortestTime[currNode])
                continue;


            for(int[] neighbor : graph.get(currNode)) {
                int nextNode = neighbor[0];
                int time = neighbor[1];

                if(shortestTime[nextNode] > currTime + time) {
                    shortestTime[nextNode] = currTime + time;
                    pathCount[nextNode] = pathCount[currNode];
                    pq.add(new long[]{nextNode, shortestTime[nextNode]});
                } else if(shortestTime[nextNode] == currTime + time) {
                    pathCount[nextNode] = (pathCount[nextNode] + pathCount[currNode]) % MOD;
                }
            }
        }
        return pathCount[n - 1];
    }
}
