package practice.DSA.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are
 * sorted lexicographicaly in this alien language.
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 *
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 *
 *  Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 */
public class AlienDictionary {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word","world","row"},"worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple","app"},"abcdefghijklmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {

        List<String> al = new ArrayList();

        for(String s : words) {
            al.add(s);
        }

        Collections.sort(al, (s1, s2) -> {

            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();

            int i = 0, j = 0;

            while(i < arr1.length && j < arr2.length) {
                char c1 = arr1[i];
                char c2 = arr2[j];

                if(c1 != c2) {
                    return order.indexOf(c1) - order.indexOf(c2);
                }
                i++;
                j++;
            }
            return arr1.length < arr2.length ? -1 : 1;
        });

        String[] newArr = new String[al.size()];
        int counter = 0;
        for(String s : al) {
            newArr[counter++] = s;
        }
        return Arrays.equals(words, newArr);
    }
}
