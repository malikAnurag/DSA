package practice.DSA.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 *  Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 *  Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length())
            return false;

        Map<Character, Character> hm1 = new HashMap();
        Map<Character, Character> hm2 = new HashMap();

        for(int i = 0; i < s.length(); i++) {

            hm1.put(s.charAt(i), t.charAt(i));

            if(!hm2.containsKey(t.charAt(i))) {
                hm2.put(t.charAt(i), s.charAt(i));
            }
            else if(hm2.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }

        for(char c : t.toCharArray()) {

            char x = hm2.get(c);
            if(c != hm1.get(x)) {
                return false;
            }
        }
        return true;
    }
}
