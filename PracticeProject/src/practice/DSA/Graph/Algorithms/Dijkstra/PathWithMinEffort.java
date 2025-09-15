package practice.DSA.Graph.Algorithms.Dijkstra;

import java.util.*;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents
 * the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1)
 * (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * <p>
 * Example 1:
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * <p>
 * Example 2:
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
 * <p>
 * Example 3:
 * Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 * <p>
 * Constraints:
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 */
public class PathWithMinEffort {

    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /*
    * Time Complexity : O(m⋅nlog(m⋅n)), where m is the number of rows and n is the number of columns in matrix heights.
    *
    * It will take O(m⋅n) time to visit every cell in the matrix.
    * The priority queue will contain at most m⋅n cells, so it will take O(log(m⋅n)) time to re-sort the queue after
    * every adjacent cell is added to the queue. This gives total time complexity as O(m⋅nlog(m⋅n)).
    *
    *
    * Space Complexity: O(m⋅n), where m is the number of rows and n is the number of columns in matrix heights.
    *
    * The maximum queue size is equal to the total number of cells in the matrix height which is given by m⋅n.
    * Also, we use a difference matrix of size m⋅n. This gives as time complexity as O(m⋅n+m⋅n) = O(m⋅n)
    *
    * */
    public int minimumEffortPath(int[][] heights) {

        Queue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);

        q.add(new int[]{0, 0, 0}); // x, y, effort

        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] diff = new int[heights.length][heights[0].length];

        for (int[] arr : diff)
            Arrays.fill(arr, Integer.MAX_VALUE);

        diff[0][0] = 0;

        while (!q.isEmpty()) {

            int[] coord = q.poll();

            int x = coord[0];
            int y = coord[1];

            int eft = coord[2];

            visited[x][y] = true;

            if (x == heights.length - 1 && y == heights[0].length - 1)
                return eft;


            for (int[] n : getNeighbors(heights, x, y)) {

                if (!visited[n[0]][n[1]]) {

                    int nRow = n[0];
                    int nCol = n[1];

                    int effort = Math.abs(heights[x][y] - heights[nRow][nCol]);
                    int maxEffort = Math.max(effort, diff[x][y]);

                    if (maxEffort < diff[nRow][nCol])
                        diff[nRow][nCol] = maxEffort;

                    q.add(new int[]{nRow, nCol, maxEffort});
                }
            }
        }
        return -1;

    }

    private List<int[]> getNeighbors(int[][] heights, int x, int y) {

        List<int[]> al = new ArrayList();

        for (int[] d : dir) {

            int newRow = d[0] + x;
            int newCol = d[1] + y;

            if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length)
                continue;
            al.add(new int[]{newRow, newCol});
        }
        return al;
    }
}
