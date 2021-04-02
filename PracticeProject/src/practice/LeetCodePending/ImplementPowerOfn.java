package practice.LeetCodePending;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class ImplementPowerOfn {

    public static void main(String[] args) {
        System.out.println(myPow(2.10000f, 3));
    }

    public static double myPow(double x, int n) {
        double res = helper(x, n);
        if (n < 0) return 1 / res;
        return res;
    }

    private static double helper(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        double half = helper(x, n / 2);
        if (n % 2 == 0) return half * half;
        return half * half * x;
    }
}
