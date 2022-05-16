package practice.DSA.String.advanced.substring;
/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
 * such that every character in t
 * (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * TODO: https://www.youtube.com/watch?v=T9Mkjh_ZF80
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(getMinimumWindowSubstring("ADOBECODEBANC", "ABC"));
    }

    static String getMinimumWindowSubstring(String s, String t) {

        int[] freq = new int[256];

        for(char c : t.toCharArray()) {
            freq[c]++;
        }

        /*
        * 'A' -> 1
        * 'B' -> 1
        * 'C' -> 1
        * */
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();

        while(end < s.length()) {

            char endS = s.charAt(end);

            if(freq[endS] > 0) { // If the frequency is greater than 0, that means this character is present in t, so reduce counter and move end ahead
                counter--;
            }
            freq[endS]--;
            end++;

            while(counter == 0) { // When the counter reaches 0, this means this window contains all the chars present in t

                if(minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                char startS = s.charAt(start);
                freq[startS]++;

                if(freq[startS] > 0) { // If the frequency becomes greater than 0, that means this char is present in t
                    counter++;
                }
                start++; // start decreasing the size of the window by incrementing the start
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
