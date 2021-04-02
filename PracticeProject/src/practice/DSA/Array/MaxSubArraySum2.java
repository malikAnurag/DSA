package practice.DSA.Array;

public class MaxSubArraySum2 {

	public static void main(String[] args) {

		int[] A = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] A1 = new int[] { -1, -2};

		System.out.println("Maximum sub array sum in A is: " + findMaxSum(A));
		System.out.println("Maximum sub array sum in A1 is: " + findMaxSum(A1));
	}

	public static int findMaxSum(int[] arr) {

		int n = arr.length;
		int sum = arr[0];
		int maxSum = arr[0];

		for (int i = 1; i < n; i++) {

			sum = Math.max(arr[i], sum + arr[i]);
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;

	}

}
