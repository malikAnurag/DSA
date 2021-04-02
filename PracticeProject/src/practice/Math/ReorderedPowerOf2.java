package practice.Math;

import java.util.Arrays;

/**
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 *
 * Example 2:
 * Input: 10
 * Output: false
 *
 *  Example 3:
 * Input: 16
 * Output: true
 *
 *  Example 4:
 * Input: 24
 * Output: false
 *
 *  Example 5:
 * Input: 46
 * Output: true
 */
public class ReorderedPowerOf2 {

    public static void main(String[] args) {
        System.out.println(getResult(1));
        System.out.println(getResult(10));
        System.out.println(getResult(16));
        System.out.println(getResult(24));
        System.out.println(getResult(46));
    }

    public static boolean getResult(int N) {

        int[] countN = count(N);
        int num = 1;

        for (int i = 0; i <= 31; i++) {
            int[] count = count(num);
            if (Arrays.equals(countN, count)) {
                return true;
            }
            num = num << 1;
        }
        return false;
    }

    private static int[] count(int N) {
        int[] arr = new int[10];
        Arrays.fill(arr, 0);

        while (N > 0) {
            arr[N % 10]++;
            N /= 10;
        }
        return arr;
    }


}
