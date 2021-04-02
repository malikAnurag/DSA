package practice;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchIterative {

	public static void main(String[] args) {
		
		int[] arr = new int[] {29,2,45,11,55,7,6};
		Arrays.sort(arr);
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int l = 0, r = arr.length-1;
		for(int i: arr)
			System.out.print(i+" ");
		System.out.println();
		System.out.println(binarySearchItr(arr,n,l,r));
	}
	
	public static int binarySearchItr(int[] arr, int n, int l, int r) {
		
		while(l<=r) {
			int mid = l + (r-l)/2;
			
			if(arr[mid]==n) {
				return mid;
			}else if(arr[mid]>n) {
				r = mid-1;
			}else {
				l = mid+1;
			}
		}
		return -1;
	}
}
