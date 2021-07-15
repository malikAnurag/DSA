package practice.DSA.BinarySearch.advanced;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 *  Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 *  Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class CalculatePowerOfN {

    public static void main(String[] args) {
        System.out.println(getPower(2.0000, 10));
        System.out.println(getPower(2.1000, 3));
        System.out.println(getPower(2.0000, -2));
    }

    public static double getPower(double x, int n) {

        double result = calculatePower(x, n);

        if(n < 0)
            return 1/result;

        return result;
    }

    public static double calculatePower(double x, int n) {

        if(n == 0)
            return 1;
        if(n == 1)
            return x;

        double half = calculatePower(x, n/2);

        if(n % 2 == 0)
            return half * half;

        return half * half * x;
    }
}
