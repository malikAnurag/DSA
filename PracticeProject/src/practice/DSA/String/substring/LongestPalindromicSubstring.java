package practice.DSA.String.substring;
/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 *  Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *  Example 3:
 * Input: s = "a"
 * Output: "a"
 *
 *  Example 4:
 * Input: s = "ac"
 * Output: "a"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(getLongestSubString("babad"));
        System.out.println(getLongestSubString("cbbd"));
        System.out.println(getLongestSubString("a"));
        System.out.println(getLongestSubString("ac"));
    }

    public static String getLongestSubString(String str) {

        int start = 0, len = str.length(), low, high, maxLen = 1;

        // One by one consider every character as center point of even and odd length palindromes
        for(int i = 1; i < len ; i++) {

            // Find the longest even length palindrome with center points as i-1 and i
            low = i - 1;
            high = i;

            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if(high - low + 1 > maxLen) {
                    start = low;
                    maxLen = high - low + 1;
                }
                low--;
                high++;
            }

            // Find the longest odd length palindrome with center point as i
            low = i - 1;
            high = i + 1;

            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if(high - low + 1 > maxLen) {
                    start = low;
                    maxLen = high - low + 1;
                }
                low--;
                high++;
            }
        }
        return str.substring(start, start + maxLen);
    }
}