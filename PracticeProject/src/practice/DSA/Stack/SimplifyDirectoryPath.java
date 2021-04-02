package practice.DSA.Stack;

import java.util.Stack;

public class SimplifyDirectoryPath {

    public static void main(String[] args) {

        String A = "/../../";
        String B = "/../../home/../c//d";
        String C = "/home//foo";

        System.out.println(getSimplePath(A));
        System.out.println(getSimplePath(B));
        System.out.println(getSimplePath(C));

    }


    public static String getSimplePath(String A) {

        Stack<String> stack = new Stack<>();
        String[] args = A.trim().split("/");

        for (String s : args) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }

        System.out.println(stack);
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        return sb.length() != 0 ? sb.toString() : "/";
    }
}
