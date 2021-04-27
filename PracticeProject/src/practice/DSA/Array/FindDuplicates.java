package practice.DSA.Array;

/**
 * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times.
 * Find these repeating numbers in O(n) and using only constant memory space.
 */
public class FindDuplicates {

    public static void main(String args[]) {

        int[] numRay = {0, 4, 3, 2, 7, 8, 2, 3, 1};

        for (int i = 0; i < numRay.length; i++) {

            int index = numRay[i] % 10;
            numRay[index] = numRay[index] + 10;

            System.out.println("\nIndex :" + index);
            System.out.println("Value: " + numRay[index]);
        }

        System.out.println("The repeating elements are : ");

        for (int i = 0; i < numRay.length; i++) {
            if (numRay[i] > 19) {
                System.out.println(i + " ");
            }
        }
    }
}
