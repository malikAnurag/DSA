package practice.DSA.Array.advanced.Subarrays;

/**
 * Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion.
 * In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and
 * the sum of the remaining elements is maximum possible.
 *
 * Note that the subarray needs to be non-empty after deleting one element.
 *
 * Example 1:
 * Input: arr = [1,-2,0,3]
 * Output: 4
 * Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
 *
 * Example 2:
 * Input: arr = [1,-2,-2,3]
 * Output: 3
 * Explanation: We just choose [3] and it's the maximum sum.
 *
 *  Example 3:
 * Input: arr = [-1,-1,-1,-1]
 * Output: -1
 * Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.
 *
 * Constraints:
 * 1 <= arr.length <= 105
 * -104 <= arr[i] <= 104
 */
public class MaxSubarraySumWIthDeletion {
    public int maximumSum(int[] arr) {

        int prevWithDeleted = 0;
        int prevWithoutDeleted = arr[0];
        int max = arr[0];

        /*
        * At each index i, two options are evaluated:
            - With deletion: Either carry forward the previous sum with a deletion (prevWithDeleted + arr[i]) or delete the current element (prevWithoutDeleted) — meaning we skip arr[i].
            - Without deletion: Extend the subarray or start a new one.
        * */
        for(int i = 1 ; i < arr.length ; i++) {

            prevWithDeleted = Math.max(prevWithoutDeleted, prevWithDeleted + arr[i]); // The maximum subarray sum ending at the previous index with one deletion already used.
            prevWithoutDeleted = Math.max(arr[i], prevWithoutDeleted + arr[i]); // The maximum subarray sum ending at the previous index without any deletion.
            int currMax = Math.max(prevWithDeleted, prevWithoutDeleted);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
