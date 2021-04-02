package practice.DSA.BinarySearch;

/**
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 * The array will not contain duplicates.
 */
public class MinimumElementInRotatedArray {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Minimum element in rotated array: " + getMinimum(arr));
    }


    public static int getMinimum(int[] rotated) {

        int left = 0;
        int right = rotated.length - 1;

        while(left <= right) {

            int mid = (left + right)/2;

            if(rotated[left] <= rotated[right])
                return rotated[left];

            else if(rotated[mid] <= rotated[mid-1] && rotated[mid] <= rotated[mid+1])
                return rotated[mid];

            else if(rotated[mid] <= rotated[right])
                right = mid - 1;

            else
                left = mid + 1;
        }

        return -1;
    }
}
