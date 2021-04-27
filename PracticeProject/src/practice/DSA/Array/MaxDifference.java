package practice.DSA.Array;

/**
 * Find maximum difference between two elements such that the larger one lies after the smaller one.
 */
public class MaxDifference {

    public static void main(String[] args) {

        int[] arr1 = new int[]{2, 3, 10, 6, 4, 8, 1};
        int diff1 = findMaxDiff(arr1);
        System.out.println("Maximum difference: " + diff1);

        int[] arr2 = new int[]{7, 9, 5, 6, 3, 2};
        int diff2 = findMaxDiff(arr2);
        System.out.println("Maximum difference: " + diff2);
    }


    public static int findMaxDiff(int[] arr) {

        int min = arr[0];
        int maxD = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - min > maxD)
                maxD = arr[i] - min;

            if (arr[i] < min)
                min = arr[i];
        }
        return maxD;
    }
}
