package practice.DSA.Graph.DFS;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 * <p>
 * You are given an m x n char matrix board representing the game board where:
 * <p>
 * 'M' represents an unrevealed mine,
 * 'E' represents an unrevealed empty square,
 * 'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
 * digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
 * 'X' represents a revealed mine.
 * You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').
 * <p>
 * Return the board after revealing this position according to the following rules:
 * <p>
 * If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
 * If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
 * Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
 * Output: [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 50
 * board[i][j] is either 'M', 'E', 'B', or a digit from '1' to '8'.
 * click.length == 2
 * 0 <= clickr < m
 * 0 <= clickc < n
 * board[clickr][clickc] is either 'M' or 'E'.
 */
public class Minesweeper {

    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;

        if (board[x][y] == 'M') {
            board[x][y] = 'X';  // Clicked a mine
            return;
        }

        if (board[x][y] != 'E')
            return;  // Already revealed

        int mines = countAdjacentMines(board, x, y);

        if (mines > 0) {
            board[x][y] = (char) ('0' + mines);  // Set digit and stop
        } else {
            board[x][y] = 'B';
            for (int[] d : dir) {
                dfs(board, x + d[0], y + d[1]);
            }
        }
    }

    private int countAdjacentMines(char[][] board, int x, int y) {
        int count = 0;
        for (int[] d : dir) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'M') {
                count++;
            }
        }
        return count;
    }
}