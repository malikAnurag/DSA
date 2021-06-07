package practice.DSA.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products
 * after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 * Example 1:
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 *
 *  Example 2:
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 *
 *  Example 3:
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 *
 *  Example 4:
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 *
 * TODO : Can also be solved using Priority Queues and Binary Search
 */
public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        TrieNode root = buildTrie(products);

        List<List<String>> result = new ArrayList();

        for(int i = 1; i <= searchWord.length(); i++) {
            result.add(findTopThree(root, searchWord.substring(0, i)));
        }
        return result;
    }

    static List<String> findTopThree(TrieNode root, String searchTerm) {

        TrieNode node = root;
        List<String> result = new ArrayList();

        for(char c : searchTerm.toCharArray()) {

            if(node.children[c - 'a'] == null) {
                return result;
            } else {
                node = node.children[c - 'a'];
            }
        }

        if(node.isWord) {
            result.add(searchTerm);
        }

        for(TrieNode child : node.children) {

            if(child != null) {
                List<String> res = dfs(child, searchTerm, new ArrayList());
                result.addAll(res);
                if(result.size() >= 3) {
                    return result.subList(0, 3);
                }
            }
        }
        return result;
    }

    static List<String> dfs(TrieNode root, String searchTerm, List<String> result) {

        if(root.isWord) {
            result.add(searchTerm + root.c);

            if(result.size() >= 3) {
                return result;
            }
        }

        for(TrieNode child : root.children) {
            if(child != null) {
                dfs(child, searchTerm + root.c, result);
            }
        }
        return result;
    }


    static TrieNode buildTrie(String[] products) {

        TrieNode root = new TrieNode(' ');

        for(String str : products) {
            insert(root, str);
        }
        return root;
    }

    static void insert(TrieNode root, String product) {

        TrieNode node = root;

        for(int i = 0; i < product.length(); i++) {

            char c = product.charAt(i);

            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
}
