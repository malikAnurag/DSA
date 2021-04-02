package practice.DSA.String;

/**
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Return the power of the string.
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 *
 *  Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 *
 * Example 3:
 *
 * Input: s = "triplepillooooow"
 * Output: 5
 *
 * Example 4:
 *
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 *
 * Example 5:
 *
 * Input: s = "tourist"
 * Output: 1
 */
public class ConsecutiveCharacters {

    public static void main(String[] args) {

        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("ee"));
    }

    public static int maxPower(String s) {

        char[] arr = s.toCharArray();

        int counter = 1;
        int max = Integer.MIN_VALUE;
        char prev = '\0';

        for (char c : arr) {
            if (prev != '\0') {
                if (c == prev) {
                    counter++;
                } else if (c != prev) {
                    max = Math.max(max, counter);
                    counter = 1;
                    prev = c;
                }
            } else {
                prev = c;
            }
        }
        return Math.max(max, counter);

    }

}
