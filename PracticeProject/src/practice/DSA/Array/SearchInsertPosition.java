package practice.DSA.Array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] arr = new int[] {1,3,5,6};

        System.out.println(findIndex(arr, 5));
        System.out.println(findIndex(arr, 2));
        System.out.println(findIndex(arr, 7));
        System.out.println(findIndex(arr, 0));
    }

    public static int findIndex(int[] nums, int target) {

        int index = - 1;

        for(int i = 0 ; i < nums.length ; i++) {

            if(nums[i] == target) {
                index = i;
                break;
            }
            else if(nums[i] > target) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            index = nums.length;
        }
        return index;
    }
}
