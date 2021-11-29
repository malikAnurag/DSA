package practice.DSA.BinarySearch.advanced;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 *
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class SingleElementinSortedArray {

    public static void main(String[] args) {
        System.out.println(getSingleElement(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(getSingleElement(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    /*
    * The single element is at the first even index not followed by its pair. We used this property in the linear search algorithm,
    * where we iterated over all the even indexes until we encountered the first one not followed by its pair.
    *
    * After the single element, the pattern changes to being odd indexes followed by their pair. This means that the single element (an even index) and
    * all elements after it are even indexes not followed by their pair.
    * Therefore, given any even index in the array, we can easily determine whether the single element is to the left or to the right.
    * */
    static int getSingleElement(int[] nums) {

        int left = 0, right = nums.length - 1;

        while(left < right) {

            int mid = left + (right - left)/2;

            if(mid % 2 != 0) {
                mid--;
            }

            if(nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}
