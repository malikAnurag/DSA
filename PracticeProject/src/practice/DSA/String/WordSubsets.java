package practice.DSA.String;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 *
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
 * For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 *
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 *
 * Return a list of all universal words in A.  You can return the words in any order.
 *
 *
 * Example 1:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * Example 2:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * Example 3:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 * Example 4:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * Output: ["google","leetcode"]
 * Example 5:
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 */
public class WordSubsets {

    public static void main(String[] args) {
        System.out.println(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"}).toString());
    }


    public static List<String> wordSubsets(String[] A, String[] B) {

        List<String> result = new ArrayList();

        int[] target = new int[26];

        for (String s : B) {
            int[] temp = new int[26];

            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
                target[c - 'a'] = Math.max(target[c - 'a'], temp[c - 'a']);
            }
        }

        for (String a : A) {

            int[] source = new int[26];
            for (char c : a.toCharArray())
                source[c - 'a']++;

            if (subset(source, target)) {
                result.add(a);
            }
        }
        return result;
    }

    public static boolean subset(int[] source, int[] destination) {

        for (int i = 0; i < 26; i++) {
            if (source[i] < destination[i])
                return false;
        }
        return true;
    }
}
