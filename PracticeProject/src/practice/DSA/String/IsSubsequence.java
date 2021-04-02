package practice.DSA.String;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the
 * characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde"
 * while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its
 * subsequence. In this scenario, how would you change your code?
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 *  Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {

    public static void main(String[] args) {

        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String sub, String txt) {

        int s = 0;
        int t = 0;

        int m = sub.length();
        int n = txt.length();
        int counter = 0;

        while(s < m && t < n) {
            if(sub.charAt(s) == txt.charAt(t)) {
                s++;
                t++;
                counter++;
            } else {
                t++;
            }
        }
        return counter == sub.length();
    }
}
