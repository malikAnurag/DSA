package practice.DSA.BinarySearch.RotatedArray;

/**
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 * The array CAN HAVE duplicates.
 */
public class MinimumElementRotatedWithDuplicates$ {

    public static void main(String[] args) {

        int[] arr1 = {3, 1, 3};
        int[] arr2 = {1, 3, 5};
        int[] arr3 = {4, 5, 6, 7, 0, 1, 2};
        int[] arr4 = {2, 2, 2, 0, 1};

        System.out.println("Minimum Element : " + getMinimum(arr1));
        System.out.println("Minimum Element : " + getMinimum(arr2));
        System.out.println("Minimum Element : " + getMinimum(arr3));
        System.out.println("Minimum Element : " + getMinimum(arr4));
    }

    public static int getMinimum(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        if (arr.length == 1)
            return arr[0];

        while (low < high) {

            int mid = (low + high) / 2;

            if (arr[mid] == arr[high]) {
                high--;
            }
            else if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return arr[high];
    }
}
