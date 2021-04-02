package practice.DSA;

/**
 * Find out the repeated elements without using extra space.
 */

public class RepeatedNumber {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 3, 1};

        for (int l : arr)
            System.out.print(l + " ");
        System.out.println();
        printRepeated(arr);
    }

    public static void printRepeated(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int index = arr[i] % n;
            arr[index] += n;
            System.out.println("ArrayElement-" + arr[index] + ", Index-" + index);
        }
        System.out.println("\nArray after increment: ");
        for (int k : arr)
            System.out.print(k + " ");
        System.out.println("\n");

        for (int i = 0; i < n; i++) {
            if (arr[i] / n > 1)
                System.out.print(i + " ");
        }
    }
}
