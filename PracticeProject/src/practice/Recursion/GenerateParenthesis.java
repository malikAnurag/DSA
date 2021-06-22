package practice.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 *  Example 2:
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> al = new ArrayList<>();
        generate(n, n, al, new StringBuilder());
        return al;
    }

    private static void generate(int left, int right, List<String> al, StringBuilder sb) {

        if(left == 0 && right == 0) {
            al.add(sb.toString());
            return;
        }

        if(left > 0) {
            sb.append("(");
            generate(left - 1, right , al, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(left < right) {
            sb.append(")");
            generate(left, right - 1, al, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
