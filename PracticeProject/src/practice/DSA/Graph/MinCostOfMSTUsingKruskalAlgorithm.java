package practice.DSA.Graph;

import java.util.PriorityQueue;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 * Example 1:
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 *
 * Example 2:
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 * Example 3:
 * Input: points = [[0,0],[1,1],[1,0],[-1,1]]
 * Output: 4
 *
 * Example 4:
 * Input: points = [[-1000000,-1000000],[1000000,1000000]]
 * Output: 4000000
 *
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
        System.out.println(getMinCostUsingKruskal(new int[][] {{0, 0}}));
    }

    static int getMinCostUsingKruskal(int[][] points) {

        if(points == null || points.length == 0)
            return 0;

        int size = points.length;
        UnionFind uf = new UnionFind(size);
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a,b) -> a.cost - b.cost);

        for(int i = 0 ; i < size ; i++) {

            int[] coordinate1 = points[i];

            for(int j = 0 ; j < i + 1 ; j++) {
                int[] coordinate2 = points[j];
                int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
                Edge edge = new Edge(i, j, cost);
                pq.add(edge);
            }
        }
        System.out.println(pq);
        int cost = 0;
        int count = size - 1;

        while(!pq.isEmpty() && count > 0) {

            Edge edge = pq.poll();
            int point1 = edge.point1;
            int point2 = edge.point2;

            if(uf.find(point1) != uf.find(point2)) {
                uf.union(point1, point2);
                cost += edge.cost;
                count--;
            }
            System.out.println();
        }
        return cost;
    }
}

class Edge {

    int point1;
    int point2;
    int cost;

    Edge(int point1, int point2, int cost) {
        this.point1 = point1;
        this.point2 = point2;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "(" + point1 + "," + point2 + "," + cost + ")";
    }
}

class UnionFind {

    int[] root;
    int[] rank;

    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size ; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    int find(int x) {
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            }
            else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}