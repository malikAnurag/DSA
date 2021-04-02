package practice.DSA.Array2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * <p>
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a
 * closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 */
public class IntervalListIntersection {

    public static void main(String[] args) {

        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] intersection = getIntersectionList(A, B);

        for (int i = 0; i < intersection.length; i++) {
            System.out.println(intersection[i][0] + ", " + intersection[i][1]);
        }
    }

    public static int[][] getIntersectionList(int[][] A, int[][] B) {

        List<int[]> al = new ArrayList<>();

        int i = 0, j = 0;

        while (i < A.length && j < B.length) {

            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);

            if (low <= high)
                al.add(new int[]{low, high});

            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return al.toArray(new int[al.size()][]);
    }
}
