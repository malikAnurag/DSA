package practice.DSA.String;

import java.util.Stack;

/**
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 *
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseOrderOfWords {

    public static void main(String[] args) {
        System.out.println(getReversedString("the sky is blue"));
        System.out.println(getReversedString("  hello world!  "));
        System.out.println(getReversedString("a good   example"));
    }

    public static String getReversedString(String S) {

        String[] arr = S.split(" ");

        Stack<String> st = new Stack<>();

        for(String s : arr) {
            s = s.trim();
            if(s.length() > 0) {
                st.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
