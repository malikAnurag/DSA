package practice.DSA.Array;

import java.util.*;

/**
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 * Example 1:
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 *
 *  Example 2:
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 *
 * Note:
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class AdvantageShuffle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAdvantageArray(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(getAdvantageArray(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }

    public static int[] getAdvantageArray(int[] A, int[] B) {

        Map<Integer, Queue<Integer>> indexes = new HashMap<>();

        int n = A.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            indexes.putIfAbsent(B[i], new LinkedList<>());
            indexes.get(B[i]).add(i);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        Queue<Integer> unused = new LinkedList<>();

        while (i < n && j < n) {

            if (A[i] > B[j]) {
                int index = indexes.get(B[j]).poll();
                result[index] = A[i];
                j++;
            } else {
                unused.add(A[i]);
            }
            i++;
        }

        for (int in = 0; in < n; in++) {
            if (result[in] == -1) {
                result[in] = unused.poll();
            }
        }
        return result;
    }
}
