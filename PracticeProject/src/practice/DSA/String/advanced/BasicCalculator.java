package practice.DSA.String.advanced;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 *
 * Example 2:
 * Input: s = " 2-1 + 2 "
 * Output: 3
 *
 * Example 3:
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * Constraints:
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation.
 * '-' could be used as a unary operation but it has to be inside parentheses.
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {

        Stack<Integer> st = new Stack();
        int ans = 0, curr, sign = 1;

        for(int i = 0 ; i < s.length() ; i++) {

            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                curr = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    curr = (10 * curr) + (s.charAt(i + 1) - '0');
                    i++;
                }
                curr = curr * sign;
                ans += curr;
                sign = 1;
            }
            else if(c == '+') {
                sign = 1;
            }
            else if(c == '-') {
                sign = -1;
            }
            else if(c == '(') {
                st.push(ans);
                st.push(sign);
                ans = 0;
                sign = 1;
            }
            else if(c == ')') {
                int prevSign = st.pop();
                int prevAns = st.pop();
                ans *= prevSign;
                ans += prevAns;
            }
        }
        return ans;
    }
}
