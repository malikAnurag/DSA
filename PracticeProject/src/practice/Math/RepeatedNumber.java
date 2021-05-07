package practice.Math;

/**
 * Find out the repeated elements without using extra space
 */

public class RepeatedNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 1};
        printRepeated(arr);
    }

    public static void printRepeated(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] / n > 1)
                System.out.print(i + " ");
        }
    }
}
