package practice.Recursion;

import java.util.Arrays;

/**
 * Given an array, write a recursive function to sum all the previous numbers to each index of the array.
 *
 * input[] = { 1, 2, 3, 4, 5, 6, 7}
 * output[]= {1, 3, 6, 10, 15, 21, 28}
 *
 */
public class ArraySum {

    static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
    static int[] res = new int[arr.length];

    public static void main(String[] args) {
        getSum(0, 0);
        System.out.println(Arrays.toString(res));
    }

    public static void getSum(int start, int sum) {

        if(start == arr.length) {
            return;
        }

        sum += arr[start];
        res[start] = sum;

        start++;

        getSum(start, sum);
    }
}
