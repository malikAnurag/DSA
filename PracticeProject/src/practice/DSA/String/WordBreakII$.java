package practice.DSA.String;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class WordBreakII$ {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(s, wordDict).toString());

        /*
        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s, wordDict).toString());
        *
         */

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return wordHelper(s, wordDict, new HashMap<>());
    }

    private static List<String> wordHelper(String string, List<String> wordDict, Map<String, List<String>> cache) {

        System.out.println("\nString received in wordHelper : " + string);

        if (cache.containsKey(string))//cat
            return cache.get(string);

        List<String> result = new ArrayList<>();

        if (string.length() == 0) {
            result.add("");
            return result;
        }

        //string = catsanddog
        //"cat", "cats", "and", "sand", "dog"

        for (String word : wordDict) {
            //Check if the word starts with the dictionary word
            if (string.startsWith(word)) {
                //Now we need to find all the subsets of in the String from the dict
                //and add them to a List
                List<String> subStr = wordHelper(string.substring(word.length()), wordDict, cache);
                //Now we have all the subsets, we will now start making our results
                for (String subs : subStr) {
                    String space = subs.isEmpty() ? "" : " ";
                    result.add(word + space + subs);
                }
            }
        }
        cache.put(string, result);
        System.out.println(String.format("\nReturning %s for string %s", result, string));
        return result;
    }
}
