package amazon.arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(findTwoSumIndices(arr, 9)));

        arr = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(findTwoSumIndices(arr, 6)));

        arr = new int[]{3, 3};
        System.out.println(Arrays.toString(findTwoSumIndices(arr, 6)));
    }

    public static int[] findTwoSumIndices(int[] nums, int target) {

        Map<Integer, Integer> hm = new HashMap();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int x = target - nums[i];

            if (hm.containsKey(x)) {
                res[0] = i;
                res[1] = hm.get(x);
                return res;
            } else {
                hm.put(nums[i], i);
            }
        }
        return res;
    }

}
