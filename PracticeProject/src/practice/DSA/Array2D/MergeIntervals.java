package practice.DSA.Array2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of
 * the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 *  Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeIntervals {

    public static void main(String[] args) {

        for(int[] res : merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})) {
            System.out.print(Arrays.toString(res) + " ");
        }
        System.out.println();
        for(int[] res : merge(new int[][]{{1, 4}, {2, 3}})) {
            System.out.print(Arrays.toString(res) + " ");
        }
        System.out.println();
        for(int[] res : merge(new int[][]{{1, 4}, {4, 5}})) {
            System.out.print(Arrays.toString(res) + " ");
        }
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        List<int[]> al = new ArrayList();
        al.add(intervals[0]);

        for(int i = 1; i < intervals.length ; i++) {

            int[] prev = al.get(al.size() - 1);

            int[] curr = intervals[i];

            if(prev[1] >= curr[0]) {

                if(prev[1] <= curr[1]) {

                    int[] interval = new int[2];
                    interval[0] = prev[0];
                    interval[1] = curr[1];

                    al.remove(prev);
                    al.add(interval);
                }
            }
            else {
                al.add(intervals[i]);
            }
        }

        int[][] result = new int[al.size()][2];
        int count = 0;

        for(int[] arr : al) {
            result[count++] = arr;
        }
        return result;
    }
}
