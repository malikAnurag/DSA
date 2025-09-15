package practice.DSA.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    char c;
    String word;
    boolean isWord;
    TrieNode[] children;
    Map<String, Integer> sentences;

    public TrieNode() {
        children = new TrieNode[27]; // 26 letters + space
        sentences = new HashMap<>();
    }

    public TrieNode(char c) {
        this.c = c;
        this.children = new TrieNode[26];
    }
}
