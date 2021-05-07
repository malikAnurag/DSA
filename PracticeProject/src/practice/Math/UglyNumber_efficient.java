package practice.Math;

import java.util.TreeSet;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 *
 * Input  : n = 7
 * Output : 8
 *
 * Input  : n = 10
 * Output : 12
 *
 * Input  : n = 15
 * Output : 24
 *
 * Input  : n = 150
 * Output : 5832
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

public class UglyNumber_efficient {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {

        if (n == 1)
            return n;

        int[] nums = {2, 3, 5};

        TreeSet<Long> set = new TreeSet<>();
        Long result = 1L;
        set.add(result);

        for (int i = 0; i < n; i++) {
            // Each time we poll the peak value of q, is the ith number
            result = set.pollFirst();
            for (int num : nums) {
                Long uglyNum = result * num;
                if (!set.contains(uglyNum)) {
                    set.add(uglyNum);
                }
            }
            for(long k : set)
                System.out.print(k + " ");

            System.out.println();
        }
        return result.intValue();
    }
}
