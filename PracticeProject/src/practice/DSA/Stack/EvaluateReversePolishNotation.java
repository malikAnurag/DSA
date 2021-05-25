package practice.DSA.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * Note that division between two integers should truncate toward zero.
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will
 * not be any division by zero operation.
 *
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 *  Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 *  Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvaluateReversePolishNotation {

    static Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("/", (a, b) -> a / b);
        OPERATIONS.put("*", (a, b) -> a * b);
    }

    public static void main(String[] args) {
        System.out.println(evaluate(new String[] {"2","1","+","3","*"}));
        System.out.println(evaluate(new String[] {"4","13","5","/","+"}));
        System.out.println(evaluate(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public static int evaluate(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(String s : tokens) {

            if(OPERATIONS.containsKey(s)) {
                int n2 = st.pop();
                int n1 = st.pop();

                st.push(OPERATIONS.get(s).apply(n1, n2));
            }
            else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
