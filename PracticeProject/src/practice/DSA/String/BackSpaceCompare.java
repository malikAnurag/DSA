package practice.DSA.String;

import java.util.Stack;

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

        System.out.println("Returning String : " + sb.reverse().toString());
        return sb.reverse().toString();
    }
}
