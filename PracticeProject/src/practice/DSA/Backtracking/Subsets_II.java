package practice.DSA.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class Subsets_II {

    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        for(List<Integer> al : getSubsets(new int[]{1, 2, 3}))
            System.out.println(al);
    }

    public static List<List<Integer>> getSubsets(int[] nums) {

        if(nums.length == 0)
            return result;

        Arrays.sort(nums);

        bt(0, new ArrayList<>(), nums);
        return result;
    }

    static void bt(int start, List<Integer> current, int[] nums) {

        result.add(new ArrayList<>(current));

        for(int i = start ; i < nums.length ; i++) {

            if(i > start && nums[i - 1] == nums[i])
                continue;

            current.add(nums[i]);

            bt(i + 1, current, nums);

            current.remove(current.size() - 1);
        }
    }
}
