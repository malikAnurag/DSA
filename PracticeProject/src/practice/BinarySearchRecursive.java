package practice;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive {

	public static void main(String[] args) {
		
		int[] arr = new int[] {29,2,45,11,55,7,6};
		Arrays.sort(arr);
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int l = 0, r = arr.length-1;
		for(int i: arr)
			System.out.print(i+" ");
		System.out.println();
		System.out.println(binarySearch(arr,n,l,r));
	}
	
	public static int binarySearch(int[] arr, int n,int l, int r) {

		if(l <= r) {
			int mid = l + (r-l)/2;
			
			if(arr[mid]==n)
			{
				return mid;
			}
			
			if(arr[mid] > n)
				return binarySearch(arr,n,l,mid-1);
			
			return binarySearch(arr,n,mid+1,r);
		}
		return -1;
	}
}
