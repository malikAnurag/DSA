package practice.LeetCodePending;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    static List<List<Integer>> al = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        generateSubsets(0, n - 1, new ArrayList<>(), nums);
        return al;
    }

    private static void generateSubsets(int start, int end, List<Integer> curr, int[] nums) {

        al.add(new ArrayList<>(curr));

        for (int i = start; i <= end; i++) {
            curr.add(nums[i]);
            generateSubsets(i + 1, end, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
