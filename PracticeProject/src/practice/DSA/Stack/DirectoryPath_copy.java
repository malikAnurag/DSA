package practice.DSA.Stack;

import java.util.Stack;

public class DirectoryPath_copy {

    public static void main(String[] args) {
        String A = "/../../";
        String B = "/../../home/../c//d";
        String C = "/home//foo";

        System.out.println(getPath(A));
        System.out.println(getPath(B));
        System.out.println(getPath(C));
    }


    public static String getPath(String A) {

        Stack<String> st = new Stack<>();

        String[] str = A.trim().split("/");

        for(String s : str) {
            if (s.equals("..")) {
                if(!st.isEmpty())
                    st.pop();
            }
            else {
                if(!s.isEmpty() && !s.equals("."))
                    st.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }

        return sb.toString().length() > 0 ? sb.toString() : "/";


    }
}
