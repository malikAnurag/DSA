package practice.DSA.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous sub-array with equal number of 0 and 1.
 */
public class ContiguousSubarrayWithZeroAndOne {

    public static void main(String[] args) {

        System.out.println(findMaxLength(new int[]{1, 1, 0, 1, 1, 0, 1}));

    }

    public static int findMaxLength(int[] nums) {

        int max_length = 0;
        int ending_index = 0;
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;            //setting 0 as -1

            sum += nums[i];
//            System.out.println(sum);
            if (sum == 0) {
                ending_index = i;
                max_length = i + 1;
            }

            // if again sum becomes equal to the one that was previously encountered,
            // then check if the new length is greater than the previous one
            if (hm.containsKey(sum)) {
                if (max_length < i - hm.get(sum)) {
                    max_length = i - hm.get(sum);
                    ending_index = i;
                }
            } else {
                hm.put(sum, i);                       // store index corresponding to every sum
            }
            System.out.println("\nSum,index = " + hm);
            System.out.println("Max Length = " + max_length);
        }

        int end = ending_index - max_length + 1;

        System.out.println("Equal number of zeroes and ones from index : " + end + ", to index: " + ending_index + ". \nThe length of this array is: " + max_length);
        return max_length;

    }
}
