package practice.DSA.Array.advanced;

/**
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 *
 * As the answer can be very large, return it modulo 10^9 + 7.
 *
 * Example 1:
 *
 * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (arr[i], arr[j], arr[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 *
 *
 * Example 2:
 * Input: arr = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 */
public class _3SumWithMultiplicity$ {

    public static void main(String[] args) {
        System.out.println(getMultiplicity(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(getMultiplicity(new int[]{1, 1, 2, 2, 2, 2}, 5));
    }

    public static int getMultiplicity(int[] arr, int target) {

        long result = 0;
        long mod = 1_000_000_007;
        long[] c = new long[101];

        for (int i : arr)
            c[i]++;

        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {

                int k = target - i - j;

                if(k < 0 || k > 100) continue;

                if (i == j && j == k) {
                    result += (c[i] * (c[i] - 1) * (c[i] - 2)) / 6; // nC3
                } else if (i == j) {
                    result += (c[i] * (c[i] - 1) * c[k]) / 2; // nC2 * K
                } else if (j < k) {
                    result += c[i] * c[j] * c[k]; // n1 * n2 * n3
                }
            }
        }
        return (int) (result % mod);
    }
}
