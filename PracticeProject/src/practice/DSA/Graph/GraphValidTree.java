package practice.DSA.Graph;

import java.util.*;

/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an
 * undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Example 1:
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 *
 * Example 2:
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 *
 * Constraints:
 * 1 <= 2000 <= n
 * 0 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no self-loops or repeated edges.
 */
public class GraphValidTree {

    public static void main(String[] args) {
        System.out.println(checkValidTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(checkValidTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }

    /*
        For the graph to be a valid tree, it must have exactly n - 1 edges ; n => number of nodes
        Any less, and it can't possibly be fully connected. Any more, and it has to contain cycles.
        Additionally, if the graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle, and therefore must be a tree!
    */
    static boolean checkValidTree(int n, int[][] edges) {

        if(edges.length != n - 1)
            return false;

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        q.add(0);
        seen.add(0);

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int neighbor : adjacencyList.get(node)) {
                if(seen.contains(neighbor))
                    continue;

                seen.add(neighbor);
                q.offer(neighbor);
            }
        }
        return seen.size() == n;
    }
}