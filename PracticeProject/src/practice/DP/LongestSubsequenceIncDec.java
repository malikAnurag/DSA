package practice.DP;

import java.util.Arrays;
import java.util.List;


/**
 * Finding the longest subsequence that first increases and then decreases
 * Input 2:
    [1, 11, 2, 10, 4, 5, 2, 1]

Output :
    6
    
Explanation :
    [1 2 10 4 2 1] is the longest subsequence.
 * 
 * */
public class LongestSubsequenceIncDec {

	public static void main(String[] args) {
		List<Integer> al = Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1);
		System.out.println("Length of longest subsequence that is first increasing and then decreasing: " + longestSubsequenceLength(al));
	}

	public static int longestSubsequenceLength(final List<Integer> A) {

		int n = A.size();
		int[] l1 = new int[n];
		int[] l2 = new int[n];
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = A.get(i);
			l1[i] = 1;
			l2[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && l1[i] < l1[j] + 1)
					l1[i] = l1[j] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j >= i; j--) {
				if (arr[i] > arr[j] && l2[i] < l2[j] + 1)
					l2[i] = l2[j] + 1;
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, l1[i] + l2[i] - 1);
		}
		return ans;
	}
}