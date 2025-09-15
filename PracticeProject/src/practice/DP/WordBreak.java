package practice.DP;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak(Arrays.asList("leet", "code"), "leetcode"));
        System.out.println(wordBreak(Arrays.asList("apple", "pen"), "applepenapple"));
        System.out.println(wordBreak(Arrays.asList("cats", "dog", "sand", "and", "cat"), "catsandog"));
    }

    static boolean wordBreak(List<String> dict, String word) {

        int n = word.length();
        boolean[] dp = new boolean[n];

        TrieNode root = new TrieNode(' ');

        for (String str : dict) {

            TrieNode node = root;

            for (char c : str.toCharArray()) {

                int idx = c - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode(c);
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }

        for (int i = 0; i < n; i++) {

            if (i == 0 || dp[i - 1]) {

                TrieNode node = root;

                for (int j = i; j < n; j++) {

                    char x = word.charAt(j);
                    int idx = x - 'a';

                    if (node.children[idx] == null) {
                        break;
                    }
                    node = node.children[idx];

                    if (node.isWord) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[n - 1];
    }
}

class TrieNode {

    char c;
    boolean isWord;
    TrieNode[] children;

    TrieNode(char x) {
        this.c = x;
        this.children = new TrieNode[26];
    }
}