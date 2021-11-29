package practice.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 *  Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 *  Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak(Arrays.asList("leet", "code"), "leetcode"));
        System.out.println(wordBreak(Arrays.asList("apple","pen"), "applepenapple"));
        System.out.println(wordBreak(Arrays.asList("cats","dog","sand","and","cat"), "catsandog"));
    }

    static boolean wordBreak(List<String> dict, String word) {

        int n = word.length();
        Set<String> hs = new HashSet<>(dict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1 ; i <= n ; i++) {

            for(int j = 0 ; j < i ; j++) {

                String str = word.substring(j, i);

                if(dp[j] && hs.contains(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}