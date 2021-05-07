package practice.DSA.String;

import java.util.Arrays;

/**
 * Given a word and a text, return the count of the occurrences of anagrams of the word in the text(For eg: anagrams of word for are for, ofr, rof etc.))
 *
 * Examples:
 *
 * Input : forxxorfxdofr
 *         for
 * Output : 3
 * Explanation : Anagrams of the word for - for, orf, ofr appear in the text and hence the count is 3.
 *
 * Input : aabaabaa
 *         aaba
 * Output : 4
 * Explanation : Anagrams of the word aaba - aaba, abaa each appear twice in the text and hence the count is 4.
 */
public class CountAnagrams {

    public static void main(String[] args) {
        System.out.println(getCount("forxxorfxdofr", "for"));
        System.out.println(getCount("aabaabaa", "aaba"));
    }

    public static int getCount(String text, String word) {

        int count = 0;
        int textL = text.length();
        int wordL = word.length();

        for (int i = 0; i <= textL - wordL; i++) {

            String str = text.substring(i, i + wordL);

            if (isAnagram(word, str)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isAnagram(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }
}
