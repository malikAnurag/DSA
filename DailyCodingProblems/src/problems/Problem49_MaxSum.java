package problems;

public class Problem49_MaxSum {

	public static void main(String[] args) {
		
		int[] A = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
		
		int result = maxSum(A);
		
		System.out.println("Max possible sum : "+result);
	}
	
	
	public static int maxSum(int[] arr) {
		
		int curr_max = arr[0];
		int max_so_far = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			curr_max = Math.max(arr[i], curr_max+arr[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		
		return max_so_far;
	}
	
}
