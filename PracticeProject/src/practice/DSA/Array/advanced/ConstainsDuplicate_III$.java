package practice.DSA.Array.advanced;

import java.util.TreeSet;
/**
 * Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t
 * and abs(i - j) <= k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 *  Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 *  Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 * Constraints:
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 */
public class ConstainsDuplicate_III$ {

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; ++i) {

            // Find the successor of current element
            Long s = set.ceiling((long) nums[i]) != null ? Long.parseLong(String.valueOf(set.ceiling((long) nums[i]))) : null;

            if(s != null && s <= nums[i] + t)
                return true;

            // Find the predecessor of current element
            Long g = set.floor((long) nums[i]) != null ? Long.parseLong(String.valueOf(set.floor((long) nums[i]))) : null;

            if(g != null && nums[i] <= g + t)
                return true;

            set.add((long) nums[i]);

            if(set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
