package practice.DSA.RecursionAndBacktracking;

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
 */

public class Permutations {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        generatePermutations(new int[]{1, 2, 3});
        System.out.println(result.toString());
    }

    static void generatePermutations(int[] arr) {

        List<Integer> al = new ArrayList<>();

        for(int i : arr) {
            al.add(i);
        }
        int n = al.size();
        generate(0, al, n);
    }

    static void generate(int start, List<Integer> al, int n) {

        if(start == n) {
            result.add(new ArrayList<>(al));
            return;
        }

        for(int i = start ; i < n ; i++) {
            Collections.swap(al, start, i);
            generate(start + 1, al, n);
            Collections.swap(al, start, i);
        }
    }
}