package practice.DSA.Array.Advanced.SlidingWindow;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */
public class MaxConsecutiveOnes_III {

    public static void main(String[] args) {
        System.out.println(getCount(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(getCount(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    /* Sliding Window technique*/
    public static int getCount(int[] arr, int k) {

        int i = 0, j = 0, zeros = 0, max = Integer.MIN_VALUE;

        while(j < arr.length) {

            if(arr[j] == 0)
                zeros++;

            while(zeros > k) {

                if(arr[i] == 0)
                    zeros--;

                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
