package practice.DSA.Stack;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a##c", t = "#a#c"
 * Output: true
 * Explanation: Both s and t become "c".
 * Example 4:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */
public class BackSpaceCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("abcde##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }

    public static boolean backspaceCompare(String S, String T) {
        return getProcessedString(S).equals(getProcessedString(T));
    }

    public static String getProcessedString(String S) {

        Stack<Character> stack = new Stack<>();

        for (char x : S.toCharArray()) {
            if (x != '#')
                stack.push(x);
            else if (!stack.empty())
                stack.pop();
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

//        System.out.println("Returning String : " + sb.reverse());
        return sb.reverse().toString();
    }
}
