package practice.DSA.String;

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

public class LongestSubtringWithoutRepeatingChars_N {

    public static void main(String[] args) {
        System.out.println(getLongestSubstring("abcabcbb")); // abc
        System.out.println(getLongestSubstring("bbbbb")); // b
        System.out.println(getLongestSubstring("pwwkew")); // kew
        System.out.println(getLongestSubstring(""));
        System.out.println(getLongestSubstring(" "));
    }

    public static int getLongestSubstring(String s) {

        // last index of all characters is initialized as -1
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);

        // Initialize start of current window
        int i = 0 ;
        int res = 0;

        // Move end of current window
        for(int j = 0 ; j < s.length() ; j++) {

            // Find the last index of str[j]
            // Update i (starting index of current window)
            // as maximum of current value of i and last
            // index plus 1
            i = Math.max(i, lastIndex[s.charAt(j)] + 1);

            // Update result if we get a larger window
            res = Math.max(res, j - i + 1);

            // Update last index of j.
            lastIndex[s.charAt(j)] = j ;
        }
        return res;
    }
}
