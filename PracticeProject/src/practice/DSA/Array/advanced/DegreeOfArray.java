package practice.DSA.Array.advanced;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 *
 * Example 2:
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 * Constraints:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfArray {

    public static void main(String[] args) {
        System.out.println(getMinLength(new int[]{1, 2, 2, 3, 1}));
        System.out.println(getMinLength(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    static int getMinLength(int[] arr) {

        Map<Integer, Integer> hm = new HashMap<>(), left = new HashMap<>(), right = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++) {

            if(!hm.containsKey(arr[i])) {
                hm.put(arr[i], 1);
            }
            else {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
            left.putIfAbsent(arr[i], i);
            right.put(arr[i], i);
        }

        int degree = Collections.max(hm.values());
        int len = arr.length;

        for(int i : arr) {
            if(hm.get(i) == degree) {
                len = Math.min(len, right.get(i) - left.get(i) + 1);
            }
        }
        return len;
    }
}
