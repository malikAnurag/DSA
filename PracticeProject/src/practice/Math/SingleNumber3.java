package practice.Math;

import java.util.*;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 *
 * Example 1:
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 *
 * Example 2:
 * Input: nums = [-1,0]
 * Output: [-1,0]
 *
 * Example 3:
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 * TODO: https://www.youtube.com/watch?v=QRbJZOd3ZN0
 */
public class SingleNumber3 {

    public static void main(String[] args) {
        Arrays.stream(singleNumber(new int[]{1, 2, 1, 3, 2, 5})).forEach(System.out::println);
    }

    public static int[] singleNumber(int[] nums) {

        int xor = 0;

        for(int i : nums) {
            xor ^= i;
        }

        int lowestOneBit = Integer.lowestOneBit(xor);

        int[] ans = new int[2];

        for(int i : nums) {

            if( (i & lowestOneBit) == 0)
                ans[0] ^= i;
            else
                ans[1] ^= i;
        }
        return ans;
    }
}
