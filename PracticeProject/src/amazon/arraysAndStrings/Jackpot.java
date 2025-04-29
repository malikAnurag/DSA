package amazon.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given with an array of integers arr and an integer k.
 * You are allowed to choose any subarray and add an integer of your choice, x, to all the elements in the subarray.
 * This can be done at most one time. Maximize the number of indices with value k in the array and return the frequency of that value.
 * Example : arr =[2,3,2,4,3,2] k = 2 returns 4
 */
public class Jackpot {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 3, 2};
        int k = 2;
        System.out.println(maxFrequencyAfterOperation(arr, k));  // Output: 4
    }

    public static int maxFrequencyAfterOperation(int[] arr, int k) {
        int n = arr.length;
        int[] prefixK = new int[n + 1];

        // Prefix sum of how many k's seen up to index i
        for (int i = 0; i < n; i++) {
            prefixK[i + 1] = prefixK[i] + (arr[i] == k ? 1 : 0);
        }

        int maxCount = prefixK[n]; // Initial count of k

        // Try all subarrays
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freqMap = new HashMap<>();

            for (int j = i; j < n; j++) {
                int x = k - arr[j];
                freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);

                // Most frequent x so far in this subarray
                int changedToK = freqMap.get(x);
                int kOutside = prefixK[i] + (prefixK[n] - prefixK[j + 1]);

                maxCount = Math.max(maxCount, changedToK + kOutside);
            }
        }
        return maxCount;
    }
}
