package practice.DSA.Array;

public class ArrayReversal {

    public static void main(String[] args) {

        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        reverse(A);

        for (int i : A)
            System.out.print(i + " ");

    }

    public static void reverse(int[] arr) {

        int r = arr.length - 1;
        int l = 0;

        while (l <= r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}


