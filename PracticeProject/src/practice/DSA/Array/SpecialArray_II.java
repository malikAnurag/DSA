package practice.DSA.Array;

import java.util.Arrays;

/**
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
 * You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that
 * subarray
 * nums[fromi..toi] is special or not.
 * Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
 * <p>
 * Example 1:
 * Input: nums = [3,4,1,2,6], queries = [[0,4]]
 * Output: [false]
 * <p>
 * Explanation:
 * The subarray is [3,4,1,2,6]. 2 and 6 are both even.
 * <p>
 * Example 2:
 * Input: nums = [4,3,1,6], queries = [[0,2],[2,3]]
 * Output: [false,true]
 * <p>
 * Explanation:
 * The subarray is [4,3,1]. 3 and 1 are both odd. So the answer to this query is false.
 * The subarray is [1,6]. There is only one pair: (1,6) and it contains numbers with different parity. So the answer to this query is true.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] <= nums.length - 1
 */
public class SpecialArray_II {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}})));
        System.out.println(Arrays.toString(isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));
    }

    private static boolean[] isArraySpecial(int[] arr, int[][] queries) {

        int n = queries.length;
        int prefix = 0;
        int[] prefixArr = new int[arr.length];
        boolean[] ans = new boolean[n];

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i - 1] % 2 == 0 && arr[i] % 2 == 0) ||
                    (arr[i - 1] % 2 != 0 && arr[i] % 2 != 0))
                prefix++;

            prefixArr[i] = prefix;
        }

        int counter = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            ans[counter++] = prefixArr[end] - (start > 0 ? prefixArr[start] : 0) == 0;
        }
        return ans;
    }

}
