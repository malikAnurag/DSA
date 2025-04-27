package practice.DSA.String.advanced;

/**
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none),
 * followed by some number of 1's (also possibly none).
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 * <p>
 * Return the minimum number of flips to make s monotone increasing.
 * <p>
 * Example 1:
 * Input: s = "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 * <p>
 * Example 2:
 * Input: s = "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 * <p>
 * Example 3:
 * Input: s = "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 * <p>
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is either '0' or '1'.
 */
public class FlipStringToMonotone {

    public static void main(String[] args) {
        System.out.println(getMinFlips("00110"));
        System.out.println(getMinFlips("010110"));
        System.out.println(getMinFlips("00011000"));
    }

    static int getMinFlips(String s) {

        int ones = 0, flips = 0;

        for (char c : s.toCharArray()) {

            if (c == '1') {
                ones++;
            } else {
                if (ones == 0)
                    continue;
                else {
                    flips++;
                }
            }
            if (ones < flips) {
                flips = ones;
            }
        }
        return flips;
    }
}
