package practice.Math;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(101));
    }

    public static int addDigits(int num) {

        while (num >= 10) {
            int result = 0;
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            for (char x : sb.toString().toCharArray()) {
                result += Integer.parseInt(String.valueOf(x));
            }
            num = result;
        }
        return num;
    }
    /* Mathematical Digital Root
    *
    * public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
    *
    * */


}
