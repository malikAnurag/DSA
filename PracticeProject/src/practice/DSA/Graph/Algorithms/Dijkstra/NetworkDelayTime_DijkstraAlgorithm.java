package practice.DSA.Graph.Algorithms.Dijkstra;

import java.util.*;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes
 * to receive the signal, return -1.
 * <p>
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * <p>
 * Example 2:
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * <p>
 * Example 3:
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 */
public class NetworkDelayTime_DijkstraAlgorithm {

    public static void main(String[] args) {
        System.out.println(getMinimumTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(getMinimumTime(new int[][]{{1, 2, 1}}, 2, 1));
        System.out.println(getMinimumTime(new int[][]{{1, 2, 1}}, 2, 2));
    }

    /*
    N ->  number of nodes
    E ->  number of total edges

     * Time complexity: O(N + E log N)
       - Dijkstra's Algorithm takes O(E log N)
       - Finding the minimum time required in signalReceivedAt takes O(N)
       - The maximum number of vertices that could be added to the priority queue is E
       - Thus, push and pop operations on the priority queue take O(logE) time
       - The value of E can be at most N⋅(N−1)
       - Therefore, O(logE) is equivalent to O(logN^2) which in turn equivalent to O(2⋅logN)
       - Hence, the time complexity for priority queue operations equals O(logN)
       - Although the number of vertices in the priority queue could be equal to E, we will only visit each vertex only once
       - If we encounter a vertex for the second time, then currNodeTime will be greater than signalReceivedAt[currNode],
       and we can continue to the next vertex in the priority queue.
       - Hence, in total E edges will be traversed and for each edge, there could be one priority queue insertion operation

      Hence, the time complexity is equal to O(N + E log N)


     * Space Complexity: O(N + E)
       - Building the adjacency list will take O(E) space
       - Dijkstra's algorithm takes O(E) space for priority queue because each vertex could be added to the
         priority queue N−1 time which makes it N * (N−1) and O(N^2) is equivalent to O(E)
       - signalReceivedAt takes O(N) space.
     */
    static int getMinimumTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        Queue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]}); //src -> [target, wt]
        }

        int[] signalReceivedAt = new int[n + 1]; // n + 1 because nodes are given from 1 to n
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        signalReceivedAt[k] = 0;
        q.add(new int[]{k, 0}); // node, dist

        while (!q.isEmpty()) {

            int[] currNodeArr = q.poll();
            int currNode = currNodeArr[0];
            int currNodeTime = currNodeArr[1];

            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }

            if (!graph.containsKey(currNode)) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {
                int nextNode = neighbor[0];
                int wt = neighbor[1];
                if (signalReceivedAt[nextNode] > currNodeTime + wt) {
                    signalReceivedAt[nextNode] = currNodeTime + wt;
                    q.add(new int[]{nextNode, currNodeTime + wt});
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, signalReceivedAt[i]);
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}