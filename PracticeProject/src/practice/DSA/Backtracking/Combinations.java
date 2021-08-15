package practice.DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *  Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(getCombinations(4, 2));
    }

    static List<List<Integer>> getCombinations(int n, int k) {
        backtrack(new ArrayList(), 1, n, k);
        return result;
    }

    private static void backtrack(List<Integer> current, int start, int n, int k) {

        if(current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start ; i <= n ; i++) {
            current.add(i);
            backtrack(current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }
}
