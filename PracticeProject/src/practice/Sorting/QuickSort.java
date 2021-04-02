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

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;

        return i + 1;
    }
}
