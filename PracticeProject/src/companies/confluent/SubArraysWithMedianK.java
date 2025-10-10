package companies.confluent;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array nums of size n consisting of distinct integers from 1 to n and a positive integer k.
 * Return the number of non-empty subarrays in nums that have a median equal to k.
 * <p>
 * Note:
 * The median of an array is the middle element after sorting the array in ascending order. If the array is of even length, the median is the left middle element.
 * For example, the median of [2,3,1,4] is 2, and the median of [8,4,3,5,1] is 4.
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,4,5], k = 4
 * Output: 3
 * Explanation: The subarrays that have a median equal to 4 are: [4], [4,5] and [1,4,5].
 * <p>
 * Example 2:
 * Input: nums = [2,3,1], k = 3
 * Output: 1
 * Explanation: [3] is the only subarray that has a median equal to 3.
 * <p>
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i], k <= n
 * The integers in nums are distinct.
 */
public class SubArraysWithMedianK {

    public static void main(String[] args) {
        System.out.println(countSubArrays(new int[]{3, 2, 1, 4, 5}, 4));
        System.out.println(countSubArrays(new int[]{2, 3, 1}, 3));
    }

    /*
    *
        Key trick: instead of working with medians directly, compare every element to k:

        treat > k as +1
        treat < k as −1
        treat == k as 0

        If the subarray length is odd, median is k ⇔ balance == 0.
        If the subarray length is even (median is the lower middle), median is k ⇔ balance == 1.

        combined_balance = bR(j) + bL(i)

        We want combined_balance to be 0 or 1

        bL + bR = 0  →  bR = -bL          →  bR = key
        bL + bR = 1  →  bR = 1 - bL       →  bR = key + 1

    * */
    public static int countSubArrays(int[] nums, int k) {

        int less = 0, great = 0, count = 0;
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();

        int pivot = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            // k not present → no subarray can have median k
            return 0;
        }

        for (int i = pivot; i < n; i++) {

            if (nums[i] > k)
                great++;
            else if (nums[i] < k)
                less++;

            hm.put(great - less, hm.getOrDefault(great - less, 0) + 1);
        }

        great = 0;
        less = 0;

        for (int i = pivot; i >= 0; i--) {

            if (nums[i] > k)
                great++;
            else if (nums[i] < k)
                less++;

            int key = less - great;
            count += hm.getOrDefault(key, 0) + hm.getOrDefault(key + 1, 0);
        }
        return count;
    }
}
