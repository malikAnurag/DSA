package practice.DSA.Array.Advanced.Subarrays;

/**
 * We are given an array nums of positive integers, and two positive integers left and right (left <= right).
 *
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that
 * subarray is at least left and at most right.
 *
 * Example:
 *
 * Input:
 * nums = [2, 1, 4, 3]
 * left = 2
 * right = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 * Note:
 *
 * left, right, and nums[i] will be an integer in the range [0, 109].
 * The length of nums will be in the range of [1, 50000].
 */
public class SubArraysWithBoundedMaximum {

    public static void main(String[] args) {
        System.out.println(getCount(new int[]{2, 1, 4, 3}, 2, 3));
    }

    public static int getCount(int[] nums, int left, int right) {

        int start = - 1, last = -1;
        int res = 0;

        for(int i = 0 ; i < nums.length ; i++) {

            if(nums[i] > right) {
                start = last = i;
                continue;
            }

            if(nums[i] >= left) {
                last = i;
            }

            res += last - start;
        }
        return res;
    }
}
