package practice.DSA.Trie;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * You may assume that all inputs consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {

        TrieNode p = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (p.children[index] == null) {
                p.children[index] = new TrieNode(c);
            }
            p = p.children[index];
        }
        p.isWord = true;
    }

    public boolean search(String word) {

        TrieNode p = searchNode(word);

        if (p == null)
            return false;

        else if (p.isWord)
            return true;

        return false;
    }

    public boolean startsWith(String prefix) {

        TrieNode p = searchNode(prefix);

        if (p != null) {
            return true;
        } else
            return false;
    }

    public TrieNode searchNode(String word) {

        TrieNode p = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (p.children[index] != null) {
                p = p.children[index];
            } else {
                return null;
            }
        }
        if (p == root)
            return null;

        return p;
    }
}
