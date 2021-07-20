package practice.DSA.Stack;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 */
public class CheckValidStringParenthesis {

    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("*())"));
    }

    public static boolean checkValidString(String s) {

        if (s.length() == 1 && !s.equals("*")) {
            return false;
        }

        //Use two stacks to store the indices for '(' and '*'
        //Whenever a ')' is encountered, pop the indices from 1st stack and if it is empty, use the second stack
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack1.push(i);
            }
            else if (s.charAt(i) == '*') {
                stack2.push(i);
            }
            else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
                else if (!stack2.isEmpty()) {
                    stack2.pop();
                }
                else {
                    return false;
                }
            }
        }
        // If both the stacks are not empty and the '*' stack has any index < that of '(' then return false
        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            if (stack2.pop() < stack1.pop()) {
                return false;
            }
        }
        return stack1.isEmpty();
    }
}
