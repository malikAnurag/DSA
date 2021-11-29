package practice.DP;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(getMaxProduct(2));
        System.out.println(getMaxProduct(10));
    }

    // Hint-1 : There is a simple O(n) solution to this problem.
    // Hint-2 : You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
    // To ge the max product, we see that more the number of 3s, the larger the product.
    static int getMaxProduct(int n) {

        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        int prod = 1;

        while(n > 4) {
            prod *= 3;
            n -= 3;
        }
        prod *= n;
        return prod;
    }
}