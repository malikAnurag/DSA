package practice.Math;

/**
 *  Given two numbers N and A, find N-th root of A. In mathematics, Nth root of a number A is a real number that gives A, when we raise it to integer power N.
 *  These roots are used in Number Theory and other advanced branches of mathematics.
 * Refer Wiki page for more information.
 * Examples:
 * Input : A = 81
 *         N = 4
 * Output : 3
 * 3^4 = 81
 */
public class NthRootOfANumber {

    public static void main(String[] args) {

    }

    static double root(double x, int n) {
        // your code goes here

        double preCompute = Math.random() % 10;

        double precision = 0.001;

        double maxDiff = Double.MAX_VALUE;

        double currentVal = 0.0;

        while(maxDiff > precision) {
            currentVal = ((n - 1.0) * preCompute + (double) x/Math.pow(preCompute, n-1))/(double)n;
            maxDiff = Math.abs(currentVal - preCompute);
            preCompute = currentVal;
        }
        return Double.parseDouble(String.format("%.3f", currentVal));
    }
}
