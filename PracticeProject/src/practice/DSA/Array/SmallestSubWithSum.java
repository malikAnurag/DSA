package practice.DSA.Array;

/**
 * Given an array of integers and a number x, find the smallest sub-array with sum greater than the given value.
 * O(n) solution!!
 */
public class SmallestSubWithSum {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 4, 45, 6, 10, 19};
        int x = 51;

        System.out.println("Smallest subarray size: " + findArray(arr, x));

        int arr2[] = {1, 10, 5, 2, 7};
        x = 9;
        System.out.println("Smallest subarray size: " + findArray(arr2, x));

        int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        x = 280;
        System.out.println("Smallest subarray size: " + findArray(arr3, x));
    }


    public static int findArray(int[] arr, int k) {

        int start = 0, end = 0, currentSum = 0;
        int n = arr.length;
        int minLength = n + 1;

        while (end < n) {

            while (currentSum <= k && end < n) {
                currentSum += arr[end++];
            }

            while (currentSum > k && start < n) {

                if (end - start < minLength)
                    minLength = end - start;

                currentSum -= arr[start++];
            }
        }
        return minLength;
    }
}
