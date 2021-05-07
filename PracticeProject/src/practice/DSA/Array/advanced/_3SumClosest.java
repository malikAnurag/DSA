package practice.DSA.Array.advanced;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum
 * is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _3SumClosest {

    public static void main(String[] args) {
        System.out.println(getClosestSum(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int getClosestSum(int[] arr, int target) {

        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int low = i + 1;
            int high = arr.length - 1;

            while (low < high) {
                int sum = arr[i] + arr[low] + arr[high];

                if (Math.abs(target - sum) < Math.abs(res)) {
                    res = target - sum;
                }
                if (sum < target)
                    low++;
                else
                    high--;
            }
        }
        return target - res;
    }
}
