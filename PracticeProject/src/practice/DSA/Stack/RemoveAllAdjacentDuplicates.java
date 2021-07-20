package practice.DSA.Stack;

import java.util.Stack;

/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the
 * right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * It is guaranteed that the answer is unique.
 *
 * Example 1:
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 *
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 *
 *  Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 */

public class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }

    public static String removeDuplicates(String s, int k) {

        Stack<Pair> st = new Stack();

        for(char c : s.toCharArray()) {

            if(!st.isEmpty() && st.peek().character == c) {

                int count = st.peek().freq;

                if(count + 1 == k) {
                    st.pop();
                }
                else {
                    Pair p = st.pop();
                    p.freq += 1;
                    st.push(p);
                }
            } else {
                Pair p = new Pair(c, 1);
                st.push(p);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {

            Pair pair = st.pop();

            for(int i = 0; i < pair.freq; i++)
                sb.append(pair.character);
        }
        return sb.reverse().toString();
    }

    static class Pair {
        char character;
        int freq;

        public Pair(char character, int freq) {
            this.character = character;
            this.freq = freq;
        }
    }
}
