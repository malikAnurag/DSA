package practice.DSA.Graph.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the edges of a directed graph where edges[i] = [ai, bi] indicates there is an edge between nodes ai and bi, and two nodes source and destination of this graph,
 * determine whether or not all paths starting from source eventually, end at destination, that is:
 * <p>
 * At least one path exists from the source node to the destination node
 * If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
 * The number of possible paths from source to destination is a finite number.
 * Return true if and only if all roads from source lead to destination.
 * <p>
 * Example 1:
 * Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * Output: false
 * Explanation: It is possible to reach and get stuck on both node 1 and node 2.
 * <p>
 * Example 2:
 * Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 * Output: false
 * Explanation: We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.
 */
public class AllPathsFromSrcLeadToDest {

    enum Color {GREY, BLACK};

    // Node-coloring variant of the DFS algorithm
    // The idea is to do DFS of a given graph and while doing traversal, assign one of the below three colors to every vertex.
    // According to the algorithm, there are three different colors we can assign a node:
    //
    //WHITE ~ Vertex is not processed yet. Initially, all vertices are WHITE.
    //GRAY ~ Vertex is being processed (DFS for this vertex has started, but not finished which means that all descendants (in DFS tree)
    // of this vertex are not processed yet (or this vertex is in the function call stack).
    //BLACK ~ Vertex and all its descendants are processed.
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

        Color[] color = new Color[n];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        return dfs(graph, source, destination, color);
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, int src, int dest, Color[] color) {

        if(color[src] != null) {
            return color[src] == Color.BLACK;
        }

        if(graph.get(src) == null) {
            return src == dest;
        }

        color[src] = Color.GREY;

        for(int neighbor : graph.get(src)) {
            if(!dfs(graph, neighbor, dest, color))
                return false;
        }
        color[src] = Color.BLACK;
        return true;
    }
}
