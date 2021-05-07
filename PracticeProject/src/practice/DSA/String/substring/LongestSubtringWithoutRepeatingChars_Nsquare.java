package practice.DSA.String.substring;

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
public class LongestSubtringWithoutRepeatingChars_Nsquare {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // abc
        System.out.println(lengthOfLongestSubstring("bbbbb")); // b
        System.out.println(lengthOfLongestSubstring("pwwkew")); // kew
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty())
            return 0;

        int maxLength = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            sb = new StringBuilder();
            sb.append(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {
                if (!sb.toString().contains(String.valueOf(s.charAt(j)))) {
                    sb.append(s.charAt(j));
                } else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, sb.toString().length());
        }
        maxLength = Math.max(maxLength, sb.toString().length());
        return maxLength;
    }
}