package practice.Sorting;

public class QuickSort {

    public static void main(String args[]) {
        int n = 5;
        int arr[] = {4, 2, 6, 9, 2};

        qSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void qSort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = getPartitionIndex(arr, low, high);
            qSort(arr, low, pi - 1);
            qSort(arr, pi + 1, high);
        }
    }

    public static int getPartitionIndex(int[] arr, int low, int high) {

        int i = low;
        int pivot = arr[high];

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int t = arr[i];
        arr[i] = arr[high];
        arr[high] = t;
        return i;
    }
}
