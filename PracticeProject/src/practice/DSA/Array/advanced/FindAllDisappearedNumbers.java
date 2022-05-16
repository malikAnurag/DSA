package practice.DSA.Array.Advanced;

import java.util.ArrayList;
import java.util.List;
/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class FindAllDisappearedNumbers {

    public static void main(String[] args) {
        System.out.println("\n" + findNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    static List<Integer> findNumbers(int[] nums) {

        int n = nums.length;
        List<Integer> al = new ArrayList<>();

        for(int index : nums) {
            nums[(index - 1) % n] += n;
        }

        for(int i = 0 ; i < n ; i++) {
            if(nums[i] <= n) {
                al.add(i + 1);
            }
        }
        return al;
    }
}