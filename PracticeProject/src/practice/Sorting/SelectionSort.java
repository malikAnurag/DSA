package practice.Sorting;

/**	Selection sort picks up the minimum element and puts it in the beginning, maintaining two arrays:
 * 	sorted and unsorted and converting the unsorted to sorted	*/

public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 29, 2, 45, 11, 55, 7, 6 };
		selectionSort(arr);
		for (int i : arr)
			System.out.print(i + " ");

	}

	public static void selectionSort(int[] arr) {

		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {

			int minIndex = i;

			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[minIndex])
					minIndex = j;

			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}
