package practice.DSA.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(getPermutations(new int[] {1,2,3}));
    }

    static List<List<Integer>> getPermutations(int[] nums) {

        List<Integer> numsList = new ArrayList<>();

        for(int num : nums) {
            numsList.add(num);
        }
        backtrack(numsList, 0, numsList.size());
        return result;
    }

    static void backtrack(List<Integer> numsList, int start, int n) {

        if(start == n) {
            result.add(new ArrayList(numsList));
            return;
        }

        for(int i = start ; i < n ; i++) {

            Collections.swap(numsList, start, i);

            backtrack(numsList, start + 1, n);

            Collections.swap(numsList, start, i);
        }
    }
}
