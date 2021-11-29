package practice.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row,
 * you may move to either index i or index i + 1 on the next row.
 *
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 *
 * Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 *
 * Constraints:
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */
public class Triangle {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> al = new ArrayList<>();al.add(2);
        List<Integer> al1 = new ArrayList<>();al1.add(3);al1.add(4);
        List<Integer> al2 = new ArrayList<>();al2.add(6);al2.add(5);al2.add(7);
        List<Integer> al3 = new ArrayList<>();al3.add(4);al3.add(1);al3.add(8);al3.add(3);
        list.add(al);list.add(al1);list.add(al2);list.add(al3);
        System.out.println(getMinimumTotal(list));
    }

    /*
    * When we work from bottom to top, all cells, except for those in the bottom row (which are our base case and
    * so don't need to be modified anyway) have exactly two cells below them.
    * Where (row, col) is the current cell, the cells below are located at (row + 1, col) and (row + 1, col + 1).
    * At the end, the answer will be in triangle[0][0].
    * */
    public static int getMinimumTotal(List<List<Integer>> triangle) {

        for(int row = triangle.size() - 2 ; row >= 0 ; row--) {

            for(int col = 0 ; col <= row ; col++) {

                int val = triangle.get(row).get(col) + Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, val);
            }
        }
        return triangle.get(0).get(0);
    }
}