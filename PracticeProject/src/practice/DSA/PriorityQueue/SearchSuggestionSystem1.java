package practice.DSA.PriorityQueue;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
 * TODO : Can also be solved using Tries and Binary Search
 */
public class SearchSuggestionSystem1 {

    public static void main(String[] args) {
        System.out.println(getSearchSuggestions(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    public static List<List<String>> getSearchSuggestions(String[] products, String searchWord) {

        PriorityQueue<String> pq = new PriorityQueue<>(3, String::compareTo);
        List<List<String>> result = new ArrayList<>();

        for(int i = 1 ; i <= searchWord.length() ; i++) {

            String search = searchWord.substring(0, i);

            for(String product : products) {
                if(product.startsWith(search)) {
                    pq.offer(product);
                }
            }

            List<String> al = new ArrayList<>();
            for(int j = 0 ; j < 3 ; j++) {
                if(pq.peek() != null) {
                    al.add(pq.poll());
                }
            }
            pq.clear();
            result.add(al);
        }
        return result;
    }
}
