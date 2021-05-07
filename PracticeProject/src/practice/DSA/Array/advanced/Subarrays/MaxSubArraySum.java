package practice.DSA.Array.advanced.Subarrays;

/**
 * Kadane's Algorithm to find the max sum of sub-array!
 */

public class MaxSubArraySum {

    public static void main(String[] args) {

        int[] A = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};

        int[] A1 = new int[] { -1, -2}; // Doesn't work for all negatives

        System.out.println("Maximum sub array sum is: " + findMaxSum(A));
        System.out.println("Maximum sub array sum is: " + findMaxSum(A1));
    }

    public static int findMaxSum(int[] arr) {

        int n = arr.length;
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum < 0)
                sum = 0;

            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
}
