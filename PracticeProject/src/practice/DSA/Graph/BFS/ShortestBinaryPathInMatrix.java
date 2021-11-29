package practice.DSA.Graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 * Example 1:
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 *
 * Example 2:
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 *
 * Example 3:
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 * Constraints:
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */
public class ShortestBinaryPathInMatrix {

    static int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public static void main(String[] args) {
        System.out.println(getShortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println(getShortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println(getShortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
    }

    static int getShortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;

        if(grid[0][0] != 0 || grid[m -1][m - 1] != 0)
            return -1;

        grid[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while(!q.isEmpty()) {

            int[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            int dist = grid[x][y];

            if(x == m - 1 && y == m - 1)
                return dist;

            for(int[] neighbor : getNeighbors(x, y, grid)) {
                int nx = neighbor[0];
                int ny = neighbor[1];

                grid[nx][ny] = dist + 1;
                q.add(new int[]{nx, ny});
            }
        }
        return -1;
    }

    static List<int[]> getNeighbors(int x, int y, int[][] grid) {

        List<int[]> al = new ArrayList<>();

        for(int[] dir : directions) {

            int newX = x + dir[0];
            int newY = y + dir[1];

            if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length || grid[newX][newY] != 0) {
                continue;
            }

            al.add(new int[]{newX, newY});
        }
        return al;
    }
}
