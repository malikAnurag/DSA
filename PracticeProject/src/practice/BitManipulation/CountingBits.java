package practice.BitManipulation;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly
 * in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language
 */
public class CountingBits {

    /*
    52 (N)   : 1 1 0 "1" 0 0
    51 (N-1) : 1 1 0 "0" 1 1

    N & N-1  : 1 1 0 "0" 0 0

    In order to remove the least-significant bit for any number “N” just take its “and(&)” with “N - 1”.
    Now since the numbers “N” and “( N & ( N - 1 ) )” differ only by one bit, we can use the result obtained for “( N & ( N - 1 ) )”
     and add one to it to obtain the result for “N”.

     */


    public static void main(String[] args) {
        System.out.println("2 : " + Arrays.toString(countBits(2)));
        System.out.println("4 : " + Arrays.toString(countBits(4)));
        System.out.println("5 : " + Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int N) {

        int[] result = new int[N+1];

        for(int i = 1; i <= N ; i++)
            result[i] = result[i & (i-1)] + 1;

        return result;
    }
}
