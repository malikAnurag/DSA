package practice.LeetCodePending;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {

        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1;
        int k = b.length() - 1;
        int carry = 0;

        while (i >= 0 || k >= 0) {
            int j = carry;
            j += (i < 0) ? 0 : a.charAt(i--) - '0';
            j += (k < 0) ? 0 : b.charAt(k--) - '0';
            carry = j > 1 ? 1 : 0;
            sum.append(j % 2);
        }
        if (carry != 0) sum.append(carry);
        return sum.reverse().toString();
    }
}
