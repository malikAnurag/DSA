package practice.DSA.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous sub-arrays whose
 * sum equals to k.
 */
public class SubArraySum {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{3, 3, 3, -1, -5, 3, 3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> prevSum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            currSum += nums[i];

            if (currSum == k)
                count++;

            // currsum exceeds given sum by currsum - sum. Find number of subarrays having this sum and exclude
            // those subarray from currsum by increasing count by same amount.
            if (prevSum.containsKey(currSum - k))
                count += prevSum.get(currSum - k);

            Integer p = prevSum.get(currSum);

            if (p == null)
                prevSum.put(currSum, 1);
            else
                prevSum.put(currSum, p + 1);
        }
        return count;
    }
}
