package practice.DSA.Array;

/**
 * Given a binary array, find the number of minimum adjacent swaps needed to group 1's and 0's.
 */
public class MinimumSwapsToSortBinary {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 0, 0, 0, 0, 1};
        System.out.println(findSwaps(arr));
    }

    public static int findSwaps(int[] array) {

        int nLeft = 0, nRight = 0, numberOfZeros = 0, numberOfOnes = 0;

        for(int i = 0 ; i < array.length ; i++) {
            if(array[i] == 0) {
                nLeft += i - numberOfZeros++;   // No. of steps to move the 0 to the left
            }
            else {
                nRight += i - numberOfOnes++;  // No. of steps to move the 1 to the left
            }

            System.out.println("For arr["+ i + "] = "+ array[i] +", nLeft = " + nLeft + ", nRight = " + nRight);
        }
        return Math.min(nLeft, nRight);
    }
}
