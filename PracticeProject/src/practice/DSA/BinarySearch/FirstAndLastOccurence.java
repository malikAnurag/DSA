package practice.DSA.BinarySearch;

/**
 * Find first and last positions of an element in a sorted array
 * Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.
 *
 * Examples:
 * Input : arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
 *         x = 5
 * Output : First Occurrence = 2
 *          Last Occurrence = 5
 *
 * Input : arr[] = {1, 3, 5, 5, 5, 5, 7, 123, 125 }
 *         x = 7
 * Output : First Occurrence = 6
 *          Last Occurrence = 6
 */

public class FirstAndLastOccurence {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 5, 5, 5, 5, 67, 123, 125};

        System.out.println("First Occurence : " + findFirst(arr, 5));
        System.out.println("Last Occurence : " + findLast(arr, 5));


        int[] arr1 = new int[]{1, 3, 5, 5, 5, 5, 7, 123, 125};

        System.out.println("First Occurence : " + findFirst(arr1, 7));
        System.out.println("Last Occurence : " + findLast(arr1, 7));

        int[] arr2 = new int[]{2, 2};

        System.out.println("\n\nFirst Occurence : " + findFirst(arr2, 2));
        System.out.println("\nLast Occurence : " + findLast(arr2, 2));

    }

    public static int findFirst(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == k && (mid == 0 || arr[mid - 1] < k)) {
                return mid;
            } else if(arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int findLast(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == k && (mid == arr.length - 1 || arr[mid + 1] > k)) {
                return mid;
            } else if(arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
