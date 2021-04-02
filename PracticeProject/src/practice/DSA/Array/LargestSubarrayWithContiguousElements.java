package practice.DSA.Array;

import java.util.Arrays;

public class LargestSubarrayWithContiguousElements {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        System.out.println("Largest subarray size with contiguous elements: " + findLength(arr));

        arr = new int[]{14, 12, 11, 20};
        System.out.println("Largest subarray size with contiguous elements: " + findLength(arr));

        arr = new int[]{10, 12, 11};
        System.out.println("Largest subarray size with contiguous elements: " + findLength(arr));

    }

    public static int findLength(int[] arr) {

        int n = arr.length;
        int maxCount = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            int count = 1;
            int start = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[start] + 1 == arr[j]) {
                    count++;
                    start++;
                }
            }
            if (count > maxCount)
                maxCount = count;
        }
        return maxCount;
    }
}
