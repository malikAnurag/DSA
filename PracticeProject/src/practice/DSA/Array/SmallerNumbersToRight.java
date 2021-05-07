package practice.DSA.Array;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, return a new array where each element in the new array is the number of smaller elements
 * to the right of that element in the original input array.
 * For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0],
 */
public class SmallerNumbersToRight {

    public static void main(String[] args) {

        int[] A = new int[]{3, 4, 9, 6, 1};
        System.out.println("Original Array: ");

        for (int l : A) {
            System.out.print(l + " ");
        }

        A = smallerNum(A);

        System.out.println("\n\nResultant Array: ");
        for (int l : A) {
            System.out.print(l + " ");
        }
    }

    public static int[] smallerNum(int[] arr) {

        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int num = 0;
            while (j < arr.length) {
                if (arr[j] < arr[i]) {
                    num++;
                }
                j++;
            }
            al.add(num);
        }
        return al.stream().mapToInt(i -> i).toArray();
    }
}
