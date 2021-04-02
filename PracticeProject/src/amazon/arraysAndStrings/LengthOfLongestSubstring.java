package amazon.arraysAndStrings;

import java.util.Arrays;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 *
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 *
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 *
 *  Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 * Input: s = ""
 * Output: 0
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("abcabcbb"));
        System.out.println(getLengthOfLongestSubstring("bbbbb"));
        System.out.println(getLengthOfLongestSubstring("pwwkew"));
        System.out.println(getLengthOfLongestSubstring(""));
    }

    public static int getLengthOfLongestSubstring(String s) {

        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);

        int i = 0;
        int result = 0;

        for(int j = 0 ; j < s.length() ; j++) {
            i = Math.max(i, lastIndex[s.charAt(j)] + 1); // i = starting index , j = last index of the window
            result = Math.max(result, j - i + 1);
            lastIndex[s.charAt(j)] = j;
        }
        return result;
    }
}
