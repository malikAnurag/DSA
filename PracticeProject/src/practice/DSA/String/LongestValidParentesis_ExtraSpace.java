package practice.DSA.String;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *
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
public class LongestValidParentesis_ExtraSpace {

    public static void main(String[] args) {

        System.out.println(getParenthesisLength("(()"));
        System.out.println(getParenthesisLength(")()())"));
        System.out.println(getParenthesisLength(""));

    }

    public static int getParenthesisLength(String str) {

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    int len = i - st.peek();
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }
}
