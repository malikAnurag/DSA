package practice.DSA.Array.advanced.Subarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
 * Return the maximum score you can get by erasing exactly one subarray.
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 *
 * Example 1:
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 *
 *  Example 2:
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class MaximumErasureValue {

    public static void main(String[] args) {
        System.out.println(getErasureValue(new int[] {4,2,4,5,6}));
        System.out.println(getErasureValue(new int[] {5,2,1,2,5,2,1,2,5}));
    }

    public static int getErasureValue(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        Set<Integer> hs = new HashSet<>();
        int left = 0, right = 0, sum = 0;

        while(right < nums.length) {

            if(!hs.contains(nums[right])) {
                hs.add(nums[right]);
                sum += nums[right];
                maxSum = Math.max(sum, maxSum);
                right++;
            }
            else {
                int del = nums[left];
                sum -= del;
                hs.remove(del);
                left++;
            }
        }
        return maxSum;
    }
}
