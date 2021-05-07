package practice.DSA.BinarySearch.advanced;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInSortedArray {

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        int[] arr2 = {3, 3, 7, 7, 10, 11, 11};

        System.out.println("Single missing element : "+ getSingleElement(arr1));
        System.out.println("Single missing element : "+ getSingleElement(arr2));
    }

    public static int getSingleElement(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 != 0 && arr[mid] == arr[mid - 1]))
                left = mid + 1;
            else
                right = mid;
        }
        return arr[left];
    }
}
