package practice.LeetCodePending;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
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
public class Subsets {

    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> llist = new ArrayList<>();
        llist.add(new ArrayList<>());

        for (int i : nums) {
            List<List<Integer>> temp = new ArrayList<>();

            for (List<Integer> list : llist) {
                List<Integer> l = new ArrayList<>(list);
                l.add(i);
                temp.add(l);
            }
            llist.addAll(temp);
        }
        return llist;
    }
}
