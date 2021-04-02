package practice.Sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{29, 2, 45, 11, 55, 7, 6};
        bubbleSort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
