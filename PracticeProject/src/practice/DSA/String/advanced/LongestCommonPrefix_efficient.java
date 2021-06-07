package practice.DSA.String.advanced;

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
public class LongestCommonPrefix_efficient {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flow","flower","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while(strs[i].indexOf(prefix) != 0) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
