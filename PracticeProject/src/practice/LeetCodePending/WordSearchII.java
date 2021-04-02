package practice.LeetCodePending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
 * those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 */
public class WordSearchII {

    public static void main(String[] args) {

        char[][] board = {  {'o','a','a','n'},
                            {'e','t','a','e'},
                            {'i','h','k','r'},
                            {'i','f','l','v'} };

        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        List<String> result = findWords(board, words);

        result.stream().forEach(System.out::println);

    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (exists(board, word)) {
                ans.add(word);
            }
        }
        Collections.sort(ans);
        return ans;
    }


    private static boolean exists(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean res = dfs(board, word, index + 1, i + 1, j)
                || dfs(board, word, index + 1, i - 1, j)
                || dfs(board, word, index + 1, i, j + 1)
                || dfs(board, word, index + 1, i, j - 1);
        board[i][j] = temp;
        return res;
    }
}
