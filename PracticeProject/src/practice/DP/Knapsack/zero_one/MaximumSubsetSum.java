package practice.DP.Knapsack.zero_one;


/*
    Modifications :
                    1. Change weight array -> arr AND W -> sum
                    2. Ignore value array
                    3. Change max to OR condition
                    4. Number that is being included is getting subtracted just like weight is selected in knapsack
* */
public class MaximumSubsetSum {

    public static void main(String[] args) {
        System.out.println(isSubsetPossible(new int[]{2, 3, 7, 8, 10}, 11));
        System.out.println(isSubsetPossible(new int[]{2, 3, 7, 8, 10}, 19));
        System.out.println(isSubsetPossible(new int[]{2, 3, 7, 8, 10}, 24));
    }

    private static boolean isSubsetPossible(int[] arr, int sum) {

        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) { // i -> number of items (till..n)
            for (int j = 1; j <= sum; j++) { // j -> W
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
