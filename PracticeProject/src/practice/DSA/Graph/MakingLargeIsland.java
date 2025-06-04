package practice.DSA.Graph;


// TODO: https://www.youtube.com/watch?v=ggEq5JrnmH0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 * <p>
 * Return the size of the largest island in grid after applying this operation.
 * <p>
 * An island is a 4-directionally connected group of 1s.
 * <p>
 * Example 1:
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * <p>
 * Example 2:
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * <p>
 * Example 3:
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 * <p>
 * Constraints:
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] is either 0 or 1.
 */
public class MakingLargeIsland {

    public int largestIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    islandSize.put(islandId, explore(i, j, islandId, grid));
                    islandId++;
                }
            }
        }

        if (islandSize.isEmpty()) {
            return 1;
        }

        if (islandSize.size() == 1) {
            islandId--;
            return islandSize.get(islandId) == (rows * cols) ?
                    islandSize.get(islandId) : islandSize.get(islandId) + 1;
        }
        int max = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int currSize = 1;
                Set<Integer> islandIds = new HashSet<>();

                if (grid[i][j] == 0) {

                    if (i + 1 < rows && grid[i + 1][j] > 1) {
                        islandIds.add(grid[i + 1][j]);
                    }

                    if (i - 1 >= 0 && grid[i - 1][j] > 1) {
                        islandIds.add(grid[i - 1][j]);
                    }

                    if (j + 1 < cols && grid[i][j + 1] > 1) {
                        islandIds.add(grid[i][j + 1]);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] > 1) {
                        islandIds.add(grid[i][j - 1]);
                    }
                }

                for (int id : islandIds) {
                    currSize += islandSize.get(id);
                }
                max = Math.max(max, currSize);
            }
        }
        return max;
    }

    public int explore(int x, int y, int id, int[][] grid) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
            return 0;

        grid[x][y] = id;

        return 1 + explore(x + 1, y, id, grid) +
                explore(x - 1, y, id, grid) +
                explore(x, y + 1, id, grid) +
                explore(x, y - 1, id, grid);
    }
}
