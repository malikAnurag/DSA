package practice.DSA.String.advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of words, each word consists of English lowercase letters.
 *
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter
 * anywhere in word1 to make it equal to word2.
 * For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a
 * predecessor of word_2, word_2 is a predecessor
 * of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 *
 * Example 1:
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chain is "a","ba","bda","bdca".
 *
 *  Example 2:
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 */
public class LongestStringChain {

    public static void main(String[] args) {
        System.out.println(getLongestChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(getLongestChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
    }

    public static int getLongestChain(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        Map<String, Integer> hm = new HashMap<>();

        for(String word : words) {

            hm.put(word, 1); // Put current word in map with default value

            for(int i = 0; i < word.length(); i++) {

                StringBuilder sb = new StringBuilder(word);
                String next = sb.deleteCharAt(i).toString();

                if(hm.containsKey(next)) { // Check if value for next is already calculated
                    hm.put(word, Math.max(hm.get(word), hm.get(next) + 1)); // Update the value in map with max possible value
                }
            }
            res = Math.max(res, hm.get(word));
        }
        return res;
    }
}