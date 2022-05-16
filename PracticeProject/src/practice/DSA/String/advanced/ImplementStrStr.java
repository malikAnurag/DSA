package practice.DSA.String.advanced;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 *  Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *  Example 3:
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 * Constraints:
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(getIndex("hello", "ll"));
        System.out.println(getIndex("aaaaa", "bba"));
        System.out.println(getIndex("", ""));
    }

    public static int getIndex(String haystack, String needle) {

        int hay = haystack.length();
        int need = needle.length();

        if(need == 0)
            return 0;

        if(need > hay)
            return -1;

        for(int i = 0 ; i < hay - need + 1 ; i++) {
            if(haystack.substring(i, i + need).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
