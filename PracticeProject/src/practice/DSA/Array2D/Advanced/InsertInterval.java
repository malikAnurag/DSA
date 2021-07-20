package practice.DSA.Array2D.Advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 *
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public static void main(String[] args) {

        int[][] arr = insert(new int[][]{{1,3}, {6,9}}, new int[] {2,5});

        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print("[" + arr[i][0] + "," + arr[i][1] + "] ");
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList();

        for(int[] element : intervals) {

            if(newInterval == null || element[1] < newInterval[0]) { // new interval starts after existing
                result.add(element);
            }
            else if(newInterval[1] < element[0]) {// new interval finishes before existing
                result.add(newInterval);
                result.add(element);
                newInterval = null;
            }
            else {
                newInterval[0] = Math.min(element[0], newInterval[0]);
                newInterval[1] = Math.max(element[1], newInterval[1]);
            }
        }
        if(newInterval != null) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][2]);
    }
}
