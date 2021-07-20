package practice.DSA.BinarySearch.RotatedArray;

/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot
 * index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 * You must decrease the overall operation steps as much as possible.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums is guaranteed to be rotated at some pivot.
 * -104 <= target <= 104
 *
 * Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 */
public class SearchInRotatedWithDuplicates {

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }

    public static boolean search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while(left <= right) {

            int mid = (left + right) / 2;

            if(nums[mid] == target)
                return true;

            if(nums[mid] == nums[left])
                left++;   //"duplicate", jump

             // we are on the 'bigger' increasing side, like [5,5,7] from [5,5,7,0,1,3,4]
            else if(nums[left] < nums[mid]) {

                // if target is between nums[left] and nums[mid], it makes sense to set the right border to mid-1
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;

                // if target is NOT between nums[left] and nums[mid] then target is on the 'right' side of mid ; limit the 'left' border [left=mid+1]
                else left = mid + 1;

                // case nums[mid] < nums[left] : we are on the 'smaller' increasing side, like [0,1,3,4] from [5,5,7,0,1,3,4]
            }
            else {

                // if target is between nums[mid] and nums[right], it makes sense to set the left border to mid+1
                if(nums[mid] < target && nums[right] >= target)
                    left = mid + 1;

                // if target is NOT between nums[mid] and nums[right] then target is on the 'left' side of mid ; limit the 'right' border [right=mid-1]
                else right = mid - 1;
            }
        }
        return false;
    }
}