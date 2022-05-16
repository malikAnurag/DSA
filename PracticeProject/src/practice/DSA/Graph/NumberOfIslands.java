package practice.DSA.Graph;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid1 = new char[][]{ {'1','1','1','1','0'},
                                       {'1','1','0','1','0'},
                                       {'1','1','0','0','0'},
                                       {'0','0','0','0','0'} };


        char[][] grid2 = new char[][]{ {'1','1','0','0','0'},
                                       {'1','1','0','0','0'},
                                       {'0','0','1','0','0'},
                                       {'0','0','0','1','1'} };

        System.out.println("Number of islands in grid-1: "+ getNumberOfIslands(grid1));
        System.out.println("Number of islands in grid-2: "+ getNumberOfIslands(grid2));
    }

    public static int getNumberOfIslands(char[][] grid) {

        int count = 0 ;

        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    checkSurroundings(grid, i , j);
                }
            }
        }
        return count;
    }

    public static void checkSurroundings(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        checkSurroundings(grid, i-1, j);
        checkSurroundings(grid, i+1, j);
        checkSurroundings(grid, i, j-1);
        checkSurroundings(grid, i , j+1);
    }
}
