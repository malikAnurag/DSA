package practice.DSA.Array.advanced;

import java.util.Arrays;

/**
 * We define a harmonious array as an array where the difference between its maximum value and its
 * minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its
 * possible subsequences.
 *
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no
 * elements without changing the order of the remaining elements.
 *
 * Example 1:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 2
 *
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 */
public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(findLHS(new int[]{1, 2, 3, 4}));
        System.out.println(findLHS(new int[]{1, 1, 1, 1}));
    }

    public static int findLHS(int[] arr) {

        // O(n log n) time, O(1) space
        Arrays.sort(arr);

        int left = 0, right = 1;
        int res = 0;

        while(right < arr.length) {

            int diff = arr[right] - arr[left];

            if(diff == 1) {
                res = Math.max(res, right - left + 1);
            }

            if(diff <= 1) {
                right++;
            }
            else {
                left++;
            }
        }
        return res;
    }
}
