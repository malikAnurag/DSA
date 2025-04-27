package practice.DSA.Array.advanced;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * <p>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    // Boyer-Moore Voting Algorithm

    public static int majorityElement(int[] nums) {

        int count = 0, candidate = -1;

        for(int i : nums) {
            if(count == 0) {
                candidate = i;
            }
            count += candidate == i ? 1 : -1;
        }
        return candidate;
    }
}
