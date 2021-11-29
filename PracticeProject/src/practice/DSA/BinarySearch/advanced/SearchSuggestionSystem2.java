package practice.DSA.BinarySearch.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products
 * after each character of searchWord is typed. Suggested products should have common prefix with the searchWord.
 * If there are more than three products with a common prefix return the three lexicographically minimums products.
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
 * TODO : Can also be solved using Tries and Priority Queues
 */
public class SearchSuggestionSystem2 {

    public static void main(String[] args) {
        System.out.println("\n" + suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        System.out.println("Sorted products: ");
        System.out.println(Arrays.toString(products));
        List<List<String>> result = new ArrayList<>();
        int start, bsStart = 0, n = products.length;
        String prefix = "";

        // [mobile, moneypot, monitor, mouse, mousepad]

        for(char c : searchWord.toCharArray()) {
            prefix += c;

            // Get the starting index of word starting with `prefix`.
            start = lowerBound(products, bsStart, prefix);

            // Add empty vector to result.
            result.add(new ArrayList<>());

            // Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for(int i = start; i < Math.min(start + 3, n); i++) {

                if(products[i].length() < prefix.length() || !products[i].startsWith(prefix)) {
                    break;
                }
                result.get(result.size() - 1).add(products[i]);
            }

            // Reduce the size of elements to binary search on since we know
            bsStart = start;
        }
        return result;
    }

    static int lowerBound(String[] products, int start, String word) {

        int i = start, j = products.length, mid;

        while(i < j) {

            mid = (i + j) / 2;

            if(products[mid].compareTo(word) >= 0) {
                j = mid;
            }
            else {
                i = mid + 1;
            }
        }
        return i;
    }
}
