package amazon.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(getTriplets(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> getTriplets(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // -4 -1 -1 0 1 2

        for(int i = 0 ; i < arr.length - 2 ; i++) {
            if(i == 0 || arr[i] != arr[i-1]) {

                int low = i + 1;
                int high = arr.length - 1;
                int sum = -arr[i];

                while(low < high) {

                    if(arr[low] + arr[high] == sum) {
                        result.add(Arrays.asList(arr[low], arr[i], arr[high]));

                        while(low < high && arr[low] == arr[low + 1]) low++;
                        while(low < high && arr[high] == arr[high - 1]) high--;

                        low++;
                        high--;
                    }
                    else if(arr[low] + arr[high] > sum) {
                        high--;
                    }
                    else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}
