package practice.DP;

/**
 * Find length of Longest increasing subsequence in a 1-D array
 * */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {

		int[] A = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

		System.out.println("Size of longest subsequence: " + computeSeq(A));

	}

	public static int computeSeq(int[] arr) {

		int n = arr.length;

		int[] lis = new int[n];

		for (int i = 0; i < n; i++)
			lis[i] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[j] + 1 > lis[i])
					lis[i] = lis[j] + 1;
			}
		}
		return lis[n - 1];
	}
}