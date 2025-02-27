package practice.DSA.Array.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
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

        int[] arr = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};

        List<List<Integer>> al = getTriplets(arr);

        for (List list : al) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> getTriplets(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < nums.length - 2; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {

                int low = i + 1;
                int high = nums.length - 1;
                int sum = -nums[i];

                while (low < high) {

                    if(nums[low] + nums[high] == sum) {

                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] > sum) {
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
