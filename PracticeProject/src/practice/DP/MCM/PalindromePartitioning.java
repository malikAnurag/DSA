package practice.DP.MCM;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * <p>
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * <p>
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class PalindromePartitioning {

    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        solve("aab", 0, new ArrayList<String>());
        System.out.println(result.toString());
    }

    // Backtracking
    public static void solve(String s, int idx, List<String> al) {

        if (idx >= s.length())
            result.add(new ArrayList<>(al));

        for (int k = idx; k < s.length(); k++) {
            if (isPalindrome(s, idx, k)) {
                al.add(s.substring(idx, k + 1));
                solve(s, k + 1, al);
                al.remove(al.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int i, int j) {

        if (i >= j)
            return true;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
