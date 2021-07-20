package practice.DSA.String;

import java.util.Arrays;

/**
 * Given two strings text and pattern, write a function to return true if pattern contains the permutation of text.
 * In other words, one of the second string's permutations is the substring of the first string.
 */
public class PermutationOfString$ {

    public static void main(String[] args) {

        System.out.println(checkPermutation("eidbaooo","ab" ));
    }

    public static boolean checkPermutation(String text, String pattern) {

        if(pattern.isEmpty() || pattern.length() > text.length())
            return false;

        int[] txt = new int[26];
        int[] pat = new int[26];

        int patLength = pattern.length();
        int txtLength = text.length();

        for(int i = 0 ; i < patLength ; i++) {
            pat[pattern.charAt(i) - 'a']++;
            txt[text.charAt(i) - 'a']++;
        }

        for(int i = patLength ;  i < txtLength ; i++) {

            if(Arrays.equals(pat,txt))
                return true;

            txt[text.charAt(i) - 'a']++;
            txt[text.charAt(i - patLength) - 'a']--; // Sliding window technique
        }
        return Arrays.equals(pat,txt);
    }
}
