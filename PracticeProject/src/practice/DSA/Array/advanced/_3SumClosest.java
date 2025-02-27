package practice.DSA.Array.advanced;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find THREE integers in nums such that the sum
 * is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

//Time Complexity: O(n^2). We have outer and inner loops, each going through n elements.
//Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2)
//This is asymptotically equivalent to O(n^2)
//Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.

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
