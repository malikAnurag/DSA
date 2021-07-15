package practice.DP;

/**
 * Find length of Longest increasing subsequence in a 1-D array
 * */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] A = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
		System.out.println("Size of longest subsequence: " + computeSeq(A));
	}

	public static int computeSeq(int[] arr) {

		int n = arr.length, max = Integer.MIN_VALUE;
		int[] dp = new int[n];

		for(int i = 0; i < n; i++)
			dp[i] = 1;

		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		for(int k : dp) {
			max = Math.max(max, k);
		}
		return max;
	}
}