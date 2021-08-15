package practice.DSA.String;
/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 *
 * Example 1:
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 *
 * Example 2:
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 *
 * Example 3:
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * Constraints:
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("123", "11"));
    }

    public static String addStrings(String num1, String num2) {

        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        int sum, carry = 0;
        StringBuilder ans = new StringBuilder();

        while(l1 >= 0 && l2 >= 0) {
            int d1 = num1.charAt(l1) - '0';
            int d2 = num2.charAt(l2) - '0';

            sum = d1 + d2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            ans.insert(0, sum);
            l1--;
            l2--;
        }

        while(l1 >= 0) {
            int d1 = num1.charAt(l1) - '0';
            sum = d1 + carry;
            carry = sum / 10;
            sum = sum % 10;

            ans.insert(0, sum);
            l1--;
        }

        while(l2 >= 0) {
            int d2 = num2.charAt(l2) - '0';
            sum = d2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            ans.insert(0, sum);
            l2--;
        }

        if(carry == 1) {
            ans.insert(0, "1");
        }
        return ans.toString();
    }
}