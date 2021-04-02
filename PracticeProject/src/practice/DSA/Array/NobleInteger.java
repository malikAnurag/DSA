package practice.DSA.Array;

import java.util.Arrays;

/**
 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in
 * the array equals to p.
 * If such an integer is found return 1 else return -1.
 * Note: Duplicates and negative values can also be present in the array.
 */
public class NobleInteger {

    public static void main(String[] args) {
        System.out.println("Nobel integer present: " + isNobleIntegerPresent(new int[]{7, 3, 16, 10}));
        System.out.println("Nobel integer present: " + isNobleIntegerPresent(new int[]{-1, -9, -2, -78, 1}));
    }


    public static int isNobleIntegerPresent(int[] A) {

        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {

            if (A[i] == A[i + 1])
                continue;

            if (A[i] == A.length - i - 1)
                return 1;

            if (A[A.length - 1] == 0)
                return 1;
        }
        return -1;
    }
}
