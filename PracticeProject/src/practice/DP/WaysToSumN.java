package practice.DP;

/**
 * Given a set of m distinct positive integers and a value ‘N’. The problem is to count the total number of ways we can form ‘N’ by doing sum of the array elements.
 * Repetitions and different arrangements are allowed.
 *
 * Examples :
 *
 * Input : arr = {1, 5, 6}, N = 7
 * Output : 6
 *
 * Explanation:- The different ways are:
 *              1+1+1+1+1+1+1 , 1+1+5 , 1+5+1 , 5+1+1 , 1+6 , 6+1
 *
 * Input : arr = {12, 3, 1, 9}, N = 14
 * Output : 150
 */
public class WaysToSumN {

    public static void main(String[] args) {
        System.out.println(getWaysToSumN(new int[]{1, 5, 6}, 7));
        System.out.println(getWaysToSumN(new int[]{12, 3, 1, 9}, 14));
    }

    public static int getWaysToSumN(int[] arr, int N) {

        int[] count = new int[N + 1];
        count[0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j]) {
                    count[i] += count[i - arr[j]];
                }
            }
        }
        return count[N];
    }
}