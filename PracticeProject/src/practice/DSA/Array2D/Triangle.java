package practice.DSA.Array2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row,
 * you may move to either index i or index i + 1 on the next row.
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 *
 *  Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 */
public class Triangle {

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> al = new ArrayList<>();
        al.add(2);
        triangle.add(al);

        al = new ArrayList<>();
        al.add(3);al.add(4);
        triangle.add(al);

        al = new ArrayList<>();
        al.add(6);al.add(5);al.add(7);
        triangle.add(al);

        al = new ArrayList<>();
        al.add(4);al.add(1);al.add(8);al.add(3);
        triangle.add(al);

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        for(int i = 1; i < triangle.size(); i++) {

            for(int j = 0; j < triangle.get(i).size(); j++) {

                int sum;

                if(j == 0) {
                    sum = triangle.get(i - 1).get(j) + triangle.get(i).get(j);
                }
                else if(j == triangle.get(i).size() - 1) {
                    sum = triangle.get(i).get(triangle.get(i).size() - 1) + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1);
                }
                else {
                    sum = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + triangle.get(i).get(j);
                }
                triangle.get(i).set(j, sum);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
