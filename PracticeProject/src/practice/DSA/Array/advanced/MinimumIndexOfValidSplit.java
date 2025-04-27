package practice.DSA.Array.advanced;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An element x of an integer array arr of length m is dominant if more than half the elements of arr have a value of x.
 * <p>
 * You are given a 0-indexed integer array nums of length n with one dominant element.
 * <p>
 * You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1], but the split is only valid if:
 * <p>
 * 0 <= i < n - 1
 * nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.
 * Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j, both ends being inclusive.
 * Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.
 * <p>
 * Return the minimum index of a valid split. If no valid split exists, return -1.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,2]
 * Output: 2
 * Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2].
 * In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3.
 * In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
 * Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split.
 * It can be shown that index 2 is the minimum index of a valid split.
 * <p>
 * Example 2:
 * Input: nums = [2,1,3,1,1,1,7,1,2,1]
 * Output: 4
 * Explanation: We can split the array at index 4 to obtain arrays [2,1,3,1,1] and [1,7,1,2,1].
 * In array [2,1,3,1,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
 * In array [1,7,1,2,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
 * Both [2,1,3,1,1] and [1,7,1,2,1] have the same dominant element as nums, so this is a valid split.
 * It can be shown that index 4 is the minimum index of a valid split.
 * <p>
 * Example 3:
 * Input: nums = [3,3,3,3,7,2,2]
 * Output: -1
 * Explanation: It can be shown that there is no valid split.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * nums has exactly one dominant element.
 */
public class MinimumIndexOfValidSplit {

    public int minimumIndex(List<Integer> nums) {

        int n = nums.size();
        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();

        for (int i : nums) {
            hm2.put(i, hm2.getOrDefault(i, 0) + 1);
        }

        // At each step, we check whether num is the dominant element in both halves.
        // The first split array spans indices [0, index] and has size index + 1, while the second split
        // array spans [index + 1, n - 1] and has size n - index - 1.
        // For num to be dominant in both parts, it must appear more than half the size of each array, meaning:
        //              firstMap[num]×2>size of first array and secondMap[num]×2>size of second array
        for (int index = 0; index < n; index++) {

            int x = nums.get(index);

            hm2.put(x, hm2.get(x) - 1);
            hm1.put(x, hm1.getOrDefault(x, 0) + 1);
            // [0, index] && [index + 1, n - 1]
            if ((hm1.get(x) > (index + 1) / 2) && (hm2.get(x) > (n - index - 1) / 2)) {
                return index;
            }
        }
        return -1;
    }
}
