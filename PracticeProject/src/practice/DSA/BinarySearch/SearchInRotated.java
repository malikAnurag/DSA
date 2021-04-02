package practice.DSA.BinarySearch;

public class SearchInRotated {

    public static void main(String[] args) {

        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(search(arr, 0, arr.length - 1, 3));

        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(search(arr, 0, arr1.length - 1, 9));
    }

    public static int search(int[] arr, int left, int right, int key) {

        if (left > right)
            return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == key)
            return mid;

        else if (arr[left] <= arr[mid]) {

            if (arr[left] <= key && key <= arr[mid])
                return search(arr, left, mid - 1, key);

            return search(arr, mid + 1, right, key);
        }

        if (arr[mid] <= key && key <= arr[right])
            return search(arr, mid + 1, right, key);

        return search(arr, left, mid - 1, key);
    }


}
