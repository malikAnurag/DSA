package practice.DSA.Array.Advanced;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, return an array output such that output[i] is equal to the product of all the
 * elements of nums except nums[i].
 * <p>
 * Please solve it without division, in O(n) time and constant space complexity (The output array does not count as extra space
 * for the purpose of space complexity analysis.)
 */
public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4};
        printProductBelow(array);
        printProductAbove(array);

        int[] arr = productExceptSelf(array);
        System.out.println("\n\nResultant array: ");
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] product = new int[n];
        Arrays.fill(product, 1);

        //Product Below
        int p = 1;
        for (int i = 0; i < n; i++) {
            product[i] = p;
            p *= nums[i];
        }

        //Product Above
        p = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] *= p;
            p *= nums[i];
        }
        return product;
    }


    public static void printProductBelow(int[] nums) {

        int n = nums.length;
        int[] product = new int[n];
        Arrays.fill(product, 1);
        int p = 1;
        for (int i = 0; i < n; i++) {
            product[i] = p;
            p *= nums[i];
        }

        System.out.println("\n\nBelow product array: ");
        for (int i : product)
            System.out.print(i + " ");
    }

    public static void printProductAbove(int[] nums) {

        int n = nums.length;
        int[] product = new int[n];
        Arrays.fill(product, 1);
        int p = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] = p;
            p *= nums[i];
        }

        System.out.println("\n\nAbove product array: ");
        for (int i : product)
            System.out.print(i + " ");
    }
}
