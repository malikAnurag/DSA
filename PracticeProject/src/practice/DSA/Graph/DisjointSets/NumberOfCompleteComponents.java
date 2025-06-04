package practice.DSA.Graph.DisjointSets;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi]
 * denotes that there exists an undirected edge connecting vertices ai and bi.
 * <p>
 * Return the number of complete connected components of the graph.
 * <p>
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex
 * outside of the subgraph.
 * A connected component is said to be complete if there exists an edge between every pair of its vertices.
 * <p>
 * Example:
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
 * Output: 1
 * <p>
 * Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices.
 * On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5.
 * Thus, the number of complete components in this graph is 1.
 */
public class NumberOfCompleteComponents {

    public int countCompleteComponents(int n, int[][] edges) {

        UnionFindWithSize uf = new UnionFindWithSize(n);
        int ans = 0;
        Map<Integer, Integer> rootToEdgesMap = new HashMap<>();

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        for (int[] edge : edges) {
            int root = uf.find(edge[0]);
            rootToEdgesMap.put(root, rootToEdgesMap.getOrDefault(root, 0) + 1);
        }

        for (int vertex = 0; vertex < n; vertex++) {
            if (uf.find(vertex) == vertex) {
                int nodeCount = uf.size[vertex];

                // expected edges in a complete component with n vertices : n * (n - 1)/2
                int expected = (nodeCount * (nodeCount - 1)) / 2;
                int actualEdges = rootToEdgesMap.getOrDefault(vertex, 0);

                if (expected == actualEdges) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

class UnionFindWithSize {

    int[] root;
    int[] size;

    UnionFindWithSize(int count) {
        root = new int[count];
        size = new int[count];

        for (int i = 0; i < count; i++) {
            root[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (size[rootX] > size[rootY]) {
                root[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                root[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }
}