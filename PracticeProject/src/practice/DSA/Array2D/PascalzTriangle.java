package practice.DSA.Array2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * TODO : check https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 */
public class PascalzTriangle {

    public static void main(String[] args) {
        System.out.println(generatePascalTriangle(5));
    }

    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> al;

        for(int i = 1; i <= numRows; i++) {
            al = new ArrayList();
            for(int j = 0; j < i; j++) {
                int t;

                if(j == 0 || j == i - 1) {
                    al.add(1);
                } else {
                    t = result.get(i - 2).get(j) + result.get(i - 2).get(j - 1);
                    al.add(t);
                }
            }
            result.add(al);
        }
        return result;
    }
}
