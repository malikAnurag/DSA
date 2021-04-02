package practice.LeetCodePending;

/**
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S
 * that occur 2 or more times.  (The occurrences may overlap.)
 *
 * Return any duplicated substring that has the longest possible length.  (If S does not have a
 * duplicated substring, the answer is "".)
 *
 * Example 1:
 *
 * Input: "banana"
 * Output: "ana"
 *
 * Example 2:
 * Input: "abcd"
 * Output: ""
 */

public class LongestDuplicateSubstring {

    public static void main(String[] args) {

        Solution sol = new Solution();
        System.out.println("Longest Duplicate Substring: " + sol.longestDupSubstring("banana"));
        System.out.println("Longest Duplicate Substring: " + sol.longestDupSubstring("abcd"));
    }
}

class Solution {
    String S;

    public String longestDupSubstring(String S) {
        this.S = S;
        int maxLo = 0, maxLength = 0;
        TrieNode root = new TrieNode(0, 0);
        for (int i = 1; i + maxLength < S.length(); i++) {
            int len = addNew(root, i);
            if (len > maxLength) {
                maxLength = len;
                maxLo = i;
            }
        }
        return S.substring(maxLo, maxLo + maxLength);
    }

    private boolean isLeaf(TrieNode node) {
        return node.next == null;
    }

    private int getIndex(int i, int depth) {
        return S.charAt(i + depth) - 'a';
    }

    private int addNew(TrieNode node, int i) {
        int depth = node.depth;
        if (i + depth == S.length()) return depth;
        if (isLeaf(node)) {
            node.next = new TrieNode[26];
            node.next[getIndex(node.i, node.depth)] = new TrieNode(node.i, depth + 1);
        }
        int c = getIndex(i, node.depth);
        TrieNode x = node.next[c];
        if (x == null) {
            node.next[c] = new TrieNode(i, depth + 1);
            return depth;
        }
        return addNew(x, i);
    }

    private static class TrieNode {
        private TrieNode[] next;
        private int i;
        private int depth;

        public TrieNode(int i, int depth) {
            this.i = i;
            this.depth = depth;
        }
    }
}