package practice.DSA.Array;

/**
 * Equilibrium/Pivot index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:

 * Example :
 * Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
 * Output: 3
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * Input: A[] = {1, 2, 3}
 * Output: -1
 */
public class PivotIndex {

    public static void main(String[] args) {
        System.out.println(findPivot(new int[]{-7, 1, 5, 2, -4, 3, 0}));
        System.out.println(findPivot(new int[]{1, 2, 3}));
    }

    public static int findPivot(int[] array) {

        int sum = 0;
        int lSum = 0;

        for (int i : array) {
            sum += i;
        }

        for (int i = 0; i < array.length; i++) {
            sum -= array[i];

            if (lSum == sum) {
                return i;
            }

            lSum += array[i];
        }
        return -1;
    }


}
