package practice.DSA.Array;

import java.util.Arrays;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 *  Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 *  Example 3:
 * Input: digits = [0]
 * Output: [1]
 */
public class PlusOne_Interesting {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getResult(new int[]{0})));
        System.out.println(Arrays.toString(getResult(new int[]{4, 3, 2, 9})));
        System.out.println(Arrays.toString(getResult(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9})));
    }

    public static int[] getResult(int[] nums) {

        for(int i = nums.length - 1 ; i >= 0 ; i--) {

            if(nums[i] == 9) {
                nums[i] = 0;
            }
            else {
                nums[i] = nums[i] + 1;
                return nums;
            }
        }
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }
}
