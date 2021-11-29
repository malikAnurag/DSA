package practice.DSA.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 * Example 1:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2:
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 *
 * Example 3:
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */

// Time and Space Complexity : O(N)
public class RottingOranges {

    static int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) {
        System.out.println(getMinimumTime(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(getMinimumTime(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(getMinimumTime(new int[][]{{0, 2}}));
    }

    static int getMinimumTime(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int freshOranges = 0;
        int timeElapsed = -1;

        Queue<Pair1> q = new LinkedList<>();

        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair1(i, j));
                }
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        q.add(new Pair1(-1, -1));

        while(!q.isEmpty()) {

            Pair1 pair = q.poll();
            int x = pair.x;
            int y = pair.y;

            if(x == -1) {

                timeElapsed++;

                if(!q.isEmpty()) {
                    q.add(new Pair1(-1, -1));
                }
            }
            else {

                for(int[] dir : directions) {

                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX < 0 || newX >= r || newY < 0 || newY >= c)
                        continue;

                    if(grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshOranges--;
                        q.add(new Pair1(newX, newY));
                    }
                }
            }
        }
        return freshOranges == 0 ? timeElapsed : -1;
    }
}
class Pair1 {

    int x;
    int y;

    Pair1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}