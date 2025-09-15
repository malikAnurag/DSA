package practice.DSA.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Example 1:
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * <p>
 * Example 2:
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode(' ');

        for (String word : words) {
            buildTrie(root, word);
        }

        List<String> al = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, al);
            }
        }
        return al;
    }

    private void dfs(char[][] board, int x, int y, TrieNode root, List<String> al) {

        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] == '#') {
            return;
        }

        char c = board[x][y];
        int idx = c - 'a';
        root = root.children[idx];

        if (root == null) return;

        if (root.isWord) {
            al.add(root.word);
            root.isWord = false;
        }

        board[x][y] = '#';

        dfs(board, x + 1, y, root, al);
        dfs(board, x - 1, y, root, al);
        dfs(board, x, y + 1, root, al);
        dfs(board, x, y - 1, root, al);

        board[x][y] = c;
    }


    private void buildTrie(TrieNode root, String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode(c);
            }
            node = node.children[idx];
        }
        node.isWord = true;
        node.word = word;
    }
}