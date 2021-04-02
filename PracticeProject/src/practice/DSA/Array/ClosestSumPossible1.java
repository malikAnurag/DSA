package practice.DSA.Array;

import java.util.Arrays;

public class ClosestSumPossible1 {

    public static void main(String[] args) {

        int[] a1 = {-1, 3, 8, 2, 9, 5};
        int[] a2 = {4, 1, 2, 10, 5, 20};
        int aTarget = 24;

        int[] res = findClosest(a1, a2, aTarget);
        System.out.print("Closest Sum can be made using : ");
        for (int i : res)
            System.out.print(i + " ");
        System.out.println("\n-----------------------------------");

        int[] b1 = {7, 4, 1, 10};
        int[] b2 = {4, 5, 8, 7};
        int bTarget = 13;

        res = findClosest(b1, b2, bTarget);
        System.out.print("Closest Sum can be made using : ");
        for (int i : res)
            System.out.print(i + " ");
        System.out.println("\n-----------------------------------");

        int[] c1 = {6, 8, -1, -8, -3};
        int[] c2 = {4, -6, 2, 9, -3};
        int cTarget = 3;
        System.out.print("Closest Sum can be made using : ");
        res = findClosest(c1, c2, cTarget);
        for (int i : res)
            System.out.print(i + " ");

    }

    public static int[] findClosest(int[] a, int[] b, int target) {

        int[] aSorted = Arrays.copyOf(a, a.length);
        int[] bSorted = Arrays.copyOf(b, b.length);
        Arrays.sort(aSorted);
        Arrays.sort(bSorted);

        int minDiff = Math.abs(aSorted[0] + bSorted[0] - target);
        int[] closestPair = {aSorted[0], bSorted[0]};

        int i = 0, j = a.length - 1;

        while (i < a.length && j >= 0) {

            int v1 = aSorted[i];
            int v2 = bSorted[j];
            int currentDiff = Math.abs(v1 + v2 - target);

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                closestPair[0] = v1;
                closestPair[1] = v2;
            }

            if (currentDiff == 0)
                return closestPair;

            else if (minDiff < target)
                i++;
            else
                j--;
        }
        return closestPair;
    }
}
