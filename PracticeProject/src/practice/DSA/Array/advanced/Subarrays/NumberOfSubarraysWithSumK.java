package practice.DSA.Array.Advanced.Subarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous sub-arrays whose
 * sum equals to k.
 */

public class NumberOfSubarraysWithSumK {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{3, 3, 3, -1, -5, 3, 3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        int currSum = 0;
        Map<Integer, Integer> prevSum = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            currSum += nums[i];

            if(currSum == k) {
                count++;
            }

            // currsum exceeds given sum by currsum - k. If we have seen this sum before, that means we have seen an array with sum k.
            // currSum = sum(seen before) + k as currSum is cumulative sum
            // This means that the elements from the point of previous sum to the point of current sum, sums up to k.
            // This value will determine the number of times a subarray with sum k has occurred up to the current index
            if(prevSum.containsKey(currSum - k)) {
                count += prevSum.get(currSum - k);
            }

            Integer p = prevSum.get(currSum);

            if(p == null) {
                prevSum.put(currSum, 1);
            }
            else {
                prevSum.put(currSum, p + 1);
            }
        }
        return count;
    }
}
