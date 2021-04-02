package practice.DSA.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 * Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 * Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
 */
public class AmazingString {

    public static void main(String[] args) {
        System.out.println(solve("ABEC"));
    }

    public static int solve(String A) {

        int count = 0;
        Character[] arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        List<Character> al = new ArrayList<>(Arrays.asList(arr));

        for (int i = 0; i < A.length(); i++) {
            if (al.contains(A.charAt(i))) {
                count += A.length() - i;
            }
        }
        return count % 10003;
    }
}
