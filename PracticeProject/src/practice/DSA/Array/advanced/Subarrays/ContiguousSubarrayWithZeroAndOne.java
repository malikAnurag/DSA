package practice.DSA.Array.advanced.Subarrays;

import java.util.HashMap;
import java.util.Map;
/**
 * Given a binary array, find the maximum length of a contiguous sub-array with equal number of 0s and 1s.
 * {1, 1, 0, 1, 1, 0, 1}
 * 4
 */
public class ContiguousSubarrayWithZeroAndOne {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{1, 0, 0, 1, 1, 0, 1}));
    }

    public static int findMaxLength(int[] nums) {

        int maxLength = 0, endingIndex = 0, sum = 0, n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++) {

            nums[i] = nums[i] == 0 ? -1 : 1;            //setting 0 as -1

            sum += nums[i];

            if(sum == 0) {
                endingIndex = i;
                maxLength = i + 1;
            }

            // if again sum becomes equal to the one that was previously encountered,
            // then check if the new length is greater than the previous one
            if(hm.containsKey(sum)) {
                if(maxLength < i - hm.get(sum)) {
                    maxLength = i - hm.get(sum);
                    endingIndex = i;
                }
            } else {
                hm.put(sum, i);                       // store index corresponding to every sum
            }
        }

        int startIndex = endingIndex - maxLength + 1;

        System.out.println("Equal number of zeroes and ones from index : " + startIndex + " to index: " + endingIndex + ". \nThe length of this array is: " + maxLength);
        return maxLength;
    }
}