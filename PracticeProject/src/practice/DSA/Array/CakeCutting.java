package practice.DSA.Array;

import java.util.Arrays;

/**
 * Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is
 * the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the
 * rectangular cake to the jth vertical cut.
 *
 * Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts.
 * Since the answer can be a huge number, return this modulo 10^9 + 7.
 *
 * Example 1:
 * Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 * Output: 4
 * Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece
 * of cake has the maximum area.
 *
 *  Example 2:
 * Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 * Output: 6
 * Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and
 * yellow pieces of cake have the maximum area.
 *
 *  Example 3:
 * Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 * Output: 9
 *
 * //TODO : cakeCutting.png
 */
public class CakeCutting {

    public static void main(String[] args) {
        System.out.println(maxArea(5, 4, new int[]{3, 1}, new int[] {1}));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        long maxWidth = Long.MIN_VALUE;
        long maxLength = Long.MIN_VALUE;
        long len = 0, wd = 0;

        if(horizontalCuts.length == 1) {
            maxLength = Math.max(horizontalCuts[0], h - horizontalCuts[0]);
        }
        else {
            Arrays.sort(horizontalCuts);

            for(int i : horizontalCuts) {
                maxLength = Math.max(maxLength, i - len);
                len = i;
            }
            maxLength = Math.max(maxLength, h - len);
        }

        if(verticalCuts.length == 1) {
            maxWidth = Math.max(verticalCuts[0], w - verticalCuts[0]);
        }
        else {
            Arrays.sort(verticalCuts);

            for(int i : verticalCuts) {
                maxWidth = Math.max(maxWidth, i - wd);
                wd = i;
            }
            maxWidth = Math.max(maxWidth, w - wd);
        }
        // System.out.println("Len :" + maxLength + ", Width: " + maxWidth);
        return (int)((maxLength * maxWidth) % (Math.pow(10,9) + 7));
    }
}
