package practice.Math;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 * Example 1:
 * Input: n = 27
 * Output: true
 *
 * Example 2:
 * Input: n = 0
 * Output: false
 *
 *  Example 3:
 * Input: n = 9
 * Output: true
 *
 *  Example 4:
 * Input: n = 45
 * Output: false
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThreeWithoutLoop(27));
        System.out.println(isPowerOfThreeWithoutLoop(0));
        System.out.println(isPowerOfThreeWithoutLoop(9));
        System.out.println(isPowerOfThreeWithoutLoop(45));
    }

    // n is a power of three if and only if i is an integer.
    // In Java, we check if a number is an integer by taking the decimal part (using % 1) and checking if it is 0.
    public static boolean isPowerOfThreeWithoutLoop(int n) {
        return (Math.log10(n)/Math.log10(3)) % 1 == 0;
    }
}
