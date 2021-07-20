package practice.DSA.Array.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 *  Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 * Constraints:
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
// TIME COMPLEXITY : O(n^3)
// SPACE COMPLEXITY : O(n)
public class _4Sum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++) {

            if(i != 0 && nums[i - 1] == nums[i])
                continue;

            for(int j = i + 1; j < nums.length - 2; j++) {

                if(j != i + 1 && nums[j - 1] == nums[j])
                    continue;

                int left = j + 1, right = nums.length - 1;

                while(left < right) {

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target) {
                        List<Integer> al = new ArrayList();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[left]);
                        al.add(nums[right]);
                        result.add(al);

                        while(left < right && nums[left] == nums[left + 1])
                            left++;
                        while(left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    }
                    else if(sum > target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
