package practice.DSA.Graph.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes
 * to receive the signal, return -1.
 *
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 *
 * Example 2:
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 *
 * Example 3:
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 *
 *
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
    * Time Complexity: O(N^2 + E)
    * Space Complexity: O(N + E)
    * */
    static int getMinimumTime(int[][] times, int n, int k) {

        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, List<int[]>> graph = new HashMap<>();
        boolean[] seen = new boolean[n + 1];

        for(int[] edge : times) {
            if(!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        for(int i = 1 ; i <= n ; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        dist.put(k, 0);

        while(true) {

            int candidateNode = -1;
            int candidateDistance = Integer.MAX_VALUE;

            for(int i = 1 ; i <= n ; i++) {
                if(!seen[i] && dist.get(i) < candidateDistance) {
                    candidateNode = i;
                    candidateDistance = dist.get(i);
                }
            }

            if(candidateNode < 0)
                break;

            seen[candidateNode] = true;

            if(graph.containsKey(candidateNode)) {
                for(int[] info : graph.get(candidateNode)) {
                    dist.put(info[0], Math.min(dist.get(info[0]) , dist.get(candidateNode) + info[1]));
                }
            }
        }
        int ans = 0;
        for(int i : dist.values()) {
            if(i == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, i);
        }
        return ans;
    }
}