package practice.DSA.Graph.Algorithms.MST;

import java.util.ArrayList;
import java.util.Collections;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 * <p>
 * Example 1:
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * <p>
 * Example 2:
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 * <p>
 * Example 3:
 * Input: points = [[0,0],[1,1],[1,0],[-1,1]]
 * Output: 4
 * <p>
 * Example 4:
 * Input: points = [[-1000000,-1000000],[1000000,1000000]]
 * Output: 4000000
 * <p>
 * Example 5:
 * Input: points = [[0,0]]
 * Output: 0
 */
public class MinCostOfMSTUsingKruskalAlgorithm {

    public static void main(String[] args) {
        System.out.println(getMinCostUsingKruskal(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(getMinCostUsingKruskal(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
        System.out.println(getMinCostUsingKruskal(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
        System.out.println(getMinCostUsingKruskal(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
        System.out.println(getMinCostUsingKruskal(new int[][]{{0, 0}}));
    }

    /*
        Time Complexity: O(N^2 log(N)) :
            - we store N⋅(N−1)/2 ≈ N^2 edges of our complete graph
            - which will take O(N^2) time, and sorting this array will take O(N^2⋅log(N^2)) time
            - Then, we iterate over the allEdges array, and for each element, we perform a union-find operation.
            - The amortized time complexity for union-find by rank and path compression is O(α(N)), where α(N) is Inverse Ackermann Function,
                which is nearly constant, even for large values of N

            - Thus, the overall time complexity is O(N^2 + N^2⋅log(N^2) + N^2⋅α(N)) ≈ O(N^2⋅log(N^2)) ≈ O(N^2⋅log(N))

        Space Complexity: O(N^2) :
            - We use an array allEdges to store all N⋅(N−1)/2 ≈ N^2 edges of our graph.
            - UnionFind object uf uses two arrays each of size N to store the group id and rank of all the nodes.
            - Thus, the overall space complexity is O(N^2 + N) ≈ O(N^2)
    * */
    static int getMinCostUsingKruskal(int[][] points) {

        if (points == null || points.length == 0)
            return 0;

        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList<>();

        // Storing all edges of our complete graph.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);

                int[] currEdge = {weight, i, j};
                allEdges.add(currEdge);
            }
        }

        // Sort all edges in increasing order.
        Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));

        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesUsed = 0;

        for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; ++i) {
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            int weight = allEdges.get(i)[0];

            if (uf.union(node1, node2)) {
                mstCost += weight;
                edgesUsed++;
            }
        }

        return mstCost;
    }
}

class UnionFind {

    int[] root;
    int[] rank;

    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    boolean union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
        return false;
    }
}