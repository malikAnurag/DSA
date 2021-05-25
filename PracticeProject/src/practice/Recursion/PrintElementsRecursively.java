package practice.Recursion;

import java.util.Arrays;

/**
 * Input : [1,2,3,4,5,6]
 * [1,2,3] , [4,5,6]
 * [1,2],[3],[4,5],[6]
 * [1],[2],[4],[5]
 */

public class PrintElementsRecursively {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5, 6};
        printArrayElements(A);
    }

    public static void printArrayElements(int[] arr) {

        if(arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }

        int mid = (arr.length) / 2;

        int[] temp1 = Arrays.copyOfRange(arr, 0, mid);
        int[] temp2 = Arrays.copyOfRange(arr, mid, arr.length);

        printArrayElements(temp1);
        printArrayElements(temp2);
    }
}
