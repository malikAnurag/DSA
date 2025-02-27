package practice.Sorting;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = new int[]{29, 2, 45, 11, 55, 7, 6};

        heapSort(arr);

        for(int i : arr)
            System.out.print(i + " ");
    }

    public static void heapSort(int[] arr) {

        // For a complete binary tree, the last non-leaf node is at index arr.length / 2 - 1
        // If you start heapifying from the last non-leaf node, you avoid unnecessary checks on leaf nodes
        for(int i = arr.length/2 - 1 ; i >= 0 ; i--) {
            heapify(arr, arr.length, i);
        }

        for(int i = arr.length - 1 ; i >= 0 ; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i , 0);
        }
    }


    private static void heapify(int[] arr, int heapSize, int index) {

        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        int largest = index;

        if(leftChild < heapSize && arr[leftChild] > arr[largest])
            largest = leftChild;

        if(rightChild < heapSize && arr[rightChild] > arr[largest])
            largest = rightChild;

        if(largest != index) {
            int t = arr[index];
            arr[index] = arr[largest];
            arr[largest] = t;
            heapify(arr, heapSize, largest);
        }
    }
}
