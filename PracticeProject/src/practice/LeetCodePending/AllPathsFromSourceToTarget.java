package practice.LeetCodePending;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the
 * edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Note:
 *
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourceToTarget {

   static List<List<Integer>> llist = new ArrayList<>();

    public static void main(String[] args) {

        int[][] adj = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(adj).toString());
    }


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int[][] adj = graph;
        backtrack(0, graph, new ArrayList<>());
        return llist;
    }

    private static void backtrack(int curNode, int[][] adj, List<Integer> path){
        if(curNode == adj.length-1){
            // path found
            List<Integer> newpath = new ArrayList<>(path);
            newpath.add(curNode);
            llist.add(newpath);
            return;
        }

        path.add(curNode);
        for(int tonode: adj[curNode]){
            backtrack(tonode, adj, path);
        }
        path.remove(path.size()-1);
    }
}