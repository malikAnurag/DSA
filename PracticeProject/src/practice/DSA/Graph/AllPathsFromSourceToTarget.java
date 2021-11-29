package practice.DSA.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 * Example 1:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 * Example 2:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 * Example 3:
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 *
 * Example 4:
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 *
 * Example 5:
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 *
 * Constraints:
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        System.out.println(getAllPaths(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println(getAllPaths(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
        System.out.println(getAllPaths(new int[][]{{1, 2, 3}, {2}, {3}, {}}));
    }

    static List<List<Integer>> getAllPaths(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();

        if(graph == null || graph.length == 0)
            return paths;

        dfs(0, new ArrayList<>(), paths, graph);
        return paths;
    }

    static void dfs(int node, List<Integer> path, List<List<Integer>> paths, int[][] graph) {

        path.add(node);

        if(node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for(int currNode : graph[node]) {
            dfs(currNode, path, paths, graph);
            path.remove(path.size() - 1);
        }
    }
}