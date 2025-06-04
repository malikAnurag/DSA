package practice.DSA.Graph.BFS;

import java.util.*;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * <p>
 * Example :
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class AllPathsFromSrcToTarget {

    public static List<List<Integer>> findAllPaths(int[][] graph) {

        List<List<Integer>> ans = new ArrayList<>();

        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        int n = graph.length - 1;

        path.add(0);
        q.add(path);

        while (!q.isEmpty()) {

            List<Integer> curr = q.poll();
            int lastNode = curr.get(curr.size() - 1);

            for (int nextNode : graph[lastNode]) {
                List<Integer> tmp = new ArrayList<>(curr);
                tmp.add(nextNode);

                if (nextNode == n) {
                    ans.add(new ArrayList<>(tmp));
                } else {
                    q.add(tmp);
                }
            }
        }
        return ans;
    }

}
