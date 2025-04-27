package practice.DSA.Graph.Algorithms.MST;


import java.util.PriorityQueue;

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
public class MinCostOfMSTUsingPrimAlgorithm {

    public static void main(String[] args) {
        System.out.println(getMinCostUsingPrim(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(getMinCostUsingPrim(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
        System.out.println(getMinCostUsingPrim(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
        System.out.println(getMinCostUsingPrim(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
        System.out.println(getMinCostUsingPrim(new int[][]{{0, 0}}));
    }

    /*
    Time complexity: O(N^2⋅log(N))
      - In the worst-case, we push/pop N⋅(N−1)/2 ≈ N^2 edges of our graph in the heap
      - Each push/pop operation takes O(log(N^2)) ≈ log(N) time
      - Thus, the overall time complexity is O(N^2⋅log(N))

     Space complexity : O(N^2)
       - In the worst-case, we push N⋅(N−1)/2 ≈ N^2 edges into the heap
       - We use an array visited of size N to mark which nodes are included in MST
       - Thus, the overall space complexity is O(N^2 + N) ≈ O(N^2)
    * */
    static int getMinCostUsingPrim(int[][] points) {

        int size = points.length;
        boolean[] visited = new boolean[size];
        visited[0] = true;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int count = size - 1;
        int ans = 0;
        int[] coordinate1 = points[0];

        for (int i = 1; i < size; i++) {
            int[] coordinate2 = points[i];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
            pq.add(new Edge(0, i, cost));
        }

        while (!pq.isEmpty() && count > 0) {

            Edge edge = pq.poll();
            int point2 = edge.point2;
            int cost = edge.cost;

            if (!visited[point2]) {
                ans += cost;
                visited[point2] = true;

                for (int i = 0; i < size; i++) {
                    if (!visited[i]) {
                        int c = Math.abs(points[point2][0] - points[i][0]) + Math.abs(points[point2][1] - points[i][1]);
                        pq.add(new Edge(point2, i, c));
                    }
                }
                count--;
            }
        }
        return ans;
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