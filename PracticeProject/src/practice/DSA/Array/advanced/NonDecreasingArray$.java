package practice.DSA.Array.advanced;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 * Example 1:
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 *  Example 2:
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 */
public class NonDecreasingArray$ {

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,2,3}));
        System.out.println(checkPossibility(new int[]{4,2,1}));
    }

    public static boolean checkPossibility(int[] nums) {

        int pos = -1;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                if(pos != -1) {
                    return false;
                }
                pos = i;
            }
        }

        return pos == -1 || pos == 0 || pos == nums.length - 2 || nums[pos - 1] <= nums[pos + 1] || nums[pos] <= nums[pos + 2];
    }
}
