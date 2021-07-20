package practice.DSA.Dequeue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without
 * changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 * Example 1:
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 *
 *  Example 2:
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 *
 *  Constraints:
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * s and words[i] consist of only lowercase English letters.
 */
public class NumberOfMatchingSubsequences {

    public static void main(String[] args) {
        System.out.println(getMatchingSubSeq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(getMatchingSubSeq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }

    public static int getMatchingSubSeq(String S, String[] words) {

        int count = 0;
        Map<Character, Deque<String>> map = new HashMap<>();

        for(char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<>());
        }

        for(String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        for(char c : S.toCharArray()) {

            Deque<String> queue = map.get(c);
            int size = queue.size();

            for(int i = 0; i < size; i++) {

                String str = queue.removeFirst();

                if(str.length() == 1) {
                    count++;
                }
                else {
                    map.get(str.charAt(1)).addLast(str.substring(1));
                }
            }
        }
        return count;
    }
}
