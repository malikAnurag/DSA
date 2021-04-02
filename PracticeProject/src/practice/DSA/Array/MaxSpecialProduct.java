package practice.DSA.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>
 * LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions,
 * the LeftSpecialValue is the maximum value of j.
 *
 * RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions,
 * the RightSpecialValue is the minimum value of j.
 *
 * Write a program to find the maximum special product of any integer in the array.
 * Input: You will receive array of integers as argument to function.
 * Return: Maximum special product of any integer in the array modulo 1000000007.
 * Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.
 */
public class MaxSpecialProduct {

    public static void main(String[] args) {
        int[] arr = new int[]{ 5, 4, 3, 4, 5 };
        System.out.println(maxSpecialProduct(arr));
    }


    public static int maxSpecialProduct(int[] array) {

        int size = array.length;
        if (size <= 3) {
            return 0;
        }

        double maxProduct = 0.0;

        Map<Integer, Integer> leftSpecialsCache = new HashMap<>();

        for (int index = 0; index < size; ++index) {
            int currentValue = array[index];

            int leftSpecial = findLeftSpecialValue(index, currentValue, array, leftSpecialsCache);
            int rightSpecial = findRightSpecialValue(index, currentValue, size, array);

            leftSpecialsCache.put(index, leftSpecial);

            double product = ((double) leftSpecial) * (rightSpecial);
            if (product > maxProduct) {
                maxProduct = product;
            }
        }

        while (maxProduct > 1000000007) {
            maxProduct %= 1000000007;
        }

        return (int) maxProduct;
    }

    private static int findLeftSpecialValue(int currentIndex, int currentValue, int[] array, Map<Integer, Integer> leftSpecialsCache) {
        int leftSpecial = 0;
        int leftIndex = currentIndex - 1;
        // > 0, but not >= 0 because of always zero left index if comes to zero
        while (leftIndex > 0) {
            if (array[leftIndex] > currentValue) {
                leftSpecial = leftIndex;
                break;
            }
            leftIndex = leftSpecialsCache.get(leftIndex);
        }
        return leftSpecial;
    }

    private static int findRightSpecialValue(int currentIndex, int currentValue, int size, int[] array) {
        int rightSpecial = 0;
        int rightIndex = currentIndex + 1;
        while (rightIndex < size) {
            if (array[rightIndex] > currentValue) {
                rightSpecial = rightIndex;
                break;
            }
            rightIndex++;
        }

        return rightSpecial;
    }
}
