package practice.DSA.Array.advanced;

import java.util.Arrays;

/**
 * Given a circular array A of integers represented by A, find the maximum possible sum of a non-empty sub-array of A.
 */
public class MaxCircularSum$ {

    public static void main(String[] args) {
        int A[] = {11, 10, -20, 5, -3, -5, 8, -13, 10};
        System.out.println("Maximum circular sum is " + maxCircularSum(A));
    }

    public static int maxCircularSum(int[] arr) {

        boolean isNegative = true;
        // Check for negatives as kadane's algorithm doesn't work for all negatives in an array!
        for (int i : arr) {
            if (i >= 0) {
                isNegative = false;
                break;
            }
        }
        if (isNegative) {
            Arrays.sort(arr);
            return arr[arr.length - 1];
        }

        // Case 1: get the maximum sum using standard kadane's algorithm
        int max_kadane = kadane(arr);

        // Case 2: Wrapping of contributing elements implies non wrapping of non contributing elements, so find out the sum of
        // non contributing elements and subtract this sum from the total sum.
        // To find out the sum of non contributing, invert sign of each element and then run Kadane’s algorithm.
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = -arr[i];
        }

        //array-sum - (-max subarray sum of inverted array)
        sum = sum + kadane(arr);

        return Math.max(max_kadane, sum);
    }

    public static int kadane(int[] arr) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i : arr) {
            sum += i;

            if (sum < 0)
                sum = 0;

            if (maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }
}
