package practice.DSA.Graph;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
 * those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * Constraints:
 *
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearch {
    public static void main(String[] args) {

        char[][] board = new char[][]{  {'A','B','C','E'},
                                        {'S','F','C','S'},
                                        {'A','D','E','E'}};

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {

        char[] chars = word.toCharArray();
        int wordL = word.length();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    if (search(board, chars, 0, wordL, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean search(char[][] board, char[] chars, int pos, int len, int i, int j) {

        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return false;
        }

        if (board[i][j] == chars[pos]) {

            if (pos == len - 1) {
                return true;
            }

            char hold = board[i][j];
            board[i][j] = '&';
            boolean b = search(board, chars, pos + 1, len, i + 1, j) ||
                    search(board, chars, pos + 1, len, i - 1, j) ||
                    search(board, chars, pos + 1, len, i, j + 1) ||
                    search(board, chars, pos + 1, len, i, j - 1);
            board[i][j] = hold;
            return b;
        }
        return false;
    }
}
