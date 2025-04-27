package practice.DP.Knapsack.zero_one;

import java.util.Arrays;

/**
 * You are given n  objects, a knapsack of capacity  c, array v, and array w. The ith object has value v[i] and weight w[i].
 * Determine the maximum total value that you can get by selecting objects in such a manner that their sum of weights is not greater than the capacity c.
 * <p>
 * Input format:
 * First line: Two integers n and c  denoting the number of objects and capacity of the knapsack ( 1 <= n<= 10^3 and  1 <= C <= 2*10^6 ) .
 * Second line:  n  integers  (0 <= Vi <= 50)
 * Third line:  n integers  ( 10 <=Wi <= 2*10^6)
 * <p>
 * Output format:
 * Print a single integer denoting the maximum value that you can get by selecting the objects.
 * <p>
 * Sample Input
 * 4 20
 * 10 2 1 3
 * 10 5 10 10
 * <p>
 * Sample Output
 * 13
 */

public class Knapsack_01_recursive_memoization {

    static int[][] t;

    public static void main(String[] args) {

        int[] weight = new int[]{10, 5, 10, 10};
        int[] value = new int[]{10, 2, 1, 3};
        int n = 4;
        t = new int[n + 1][2_00_000_2];
        for (int[] arr : t)
            Arrays.fill(arr, -1);

        System.out.println(knapsack(value, weight, n, 20));
    }

    static int knapsack(int[] value, int[] weight, int n, int capacity) {

        if (n == 0 || capacity == 0) {
            return 0;
        }

        // fill in those values that are getting changed in the recursive calls
        // here those values are n & capacity

        if (t[n][capacity] != -1)
            return t[n][capacity];

        if (weight[n - 1] <= capacity) {
            return t[n][capacity] = Math.max((value[n - 1] + knapsack(value, weight, n - 1, capacity - weight[n - 1])),
                    knapsack(value, weight, n - 1, capacity));
        }
        return t[n][capacity] = knapsack(value, weight, n - 1, capacity);
    }
}
