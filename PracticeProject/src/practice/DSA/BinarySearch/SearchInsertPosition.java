package practice.DSA.BinarySearch;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 5, 6};

        System.out.println(findIndex(arr, 5)); // 2
        System.out.println(findIndex(arr, 2)); // 1
        System.out.println(findIndex(arr, 7)); // 4
        System.out.println(findIndex(arr, 0)); // 0
    }

    public static int findIndex(int[] nums, int target) {

        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
