package practice.DSA.String;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 *  Example 3:
 * Input: s = ""
 * Output: 0
 */
public class LongestValidParenthesis_O1_Space {

    public static void main(String[] args) {
        System.out.println(getLongest("(()"));
        System.out.println(getLongest(")()())"));
        System.out.println(getLongest(""));
    }

    public static int getLongest(String str) {

        int open = 0, closed = 0, max = 0;

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '(') {
                open++;
            } else {
                closed++;
            }

            if (closed > open) {
                open = closed = 0;
            }

            if (open == closed) {
                int len = open + closed;
                max = Math.max(len, max);
            }
        }
        open = closed = 0;

        for (int i = str.length() - 1; i >= 0; i--) {

            char c = str.charAt(i);

            if (c == '(') {
                open++;
            } else {
                closed++;
            }

            if (closed < open) {
                open = closed = 0;
            }

            if (open == closed) {
                int len = open + closed;
                max = Math.max(len, max);
            }
        }
        return max;
    }
}
