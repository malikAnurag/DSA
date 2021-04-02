package practice.DSA.Array;

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

        List<List<Integer>> result = subsets(new int[]{1, 2, 3});

        System.out.println("Result :");
        for(List list : result) {
            System.out.println(list.toString());
        }
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
            System.out.println(llist.toString());
        }
        return llist;
    }

}
