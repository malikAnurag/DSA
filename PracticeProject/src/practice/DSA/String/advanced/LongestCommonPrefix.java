package practice.DSA.String.advanced;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 *  Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        int minLen = Integer.MAX_VALUE;

        for(String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int counter = 0;

        StringBuilder sb = new StringBuilder();

        while(counter < minLen) {

            Set<Character> hs = new HashSet();
            boolean flag = true;

            if(counter < strs[0].length())
                hs.add(strs[0].charAt(counter));

            for(int i = 1 ; i < strs.length ; i++) {

                if(counter < strs[i].length() && hs.add(strs[i].charAt(counter))) {
                    flag = false;
                    break;
                }
            }

            if(!flag)
                break;

            if(counter < strs[0].length())
                sb.append(strs[0].charAt(counter));

            counter++;
        }
        return sb.toString();
    }
}
