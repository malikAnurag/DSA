package practice.DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * A palindrome string is a string that reads the same backward as forward.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
/*
* There can be 2^N nodes in a string of length N,
* Time Complexity : O(N * 2^N)
* Space Complexity : O(N)
* */
public class PalindromePartitioning {

    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    static List<List<String>> partition(String s) {
        backtrack(0, new ArrayList<>(), s);
        return result;
    }

    static void backtrack(int start, List<String> current, String s) {

        if(start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start ; i < s.length() ; i++) {
            if(isPalindrome(start, i, s)) {
                current.add(s.substring(start, i+1));
                backtrack(i + 1, current, s);
                current.remove(current.size() - 1);
            }
        }
    }

    static boolean isPalindrome(int left, int right, String s) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
