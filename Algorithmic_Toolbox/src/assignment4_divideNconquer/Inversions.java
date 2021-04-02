package assignment4_divideNconquer;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        numberOfInversions = mergeSort(a,b,left,right);
        return numberOfInversions;
    }

    public static int mergeSort(int[] arr, int[] temp, int low, int high) {
    		int inversions=0;	
    		if(low < high) {
    			int mid = low + (high-low)/2;
    			inversions = mergeSort(arr, temp, low, mid);
    			inversions += mergeSort(arr, temp, mid+1, high);
    			inversions += merge(arr, temp, low, mid+1, high);
    		}
    		return inversions;
    	
    }
    
    public static int merge(int[] arr, int[] temp, int left, int mid, int right) {
    	int i, j, k; 
    int inv_count = 0; 
    
    i = left; 
    j = mid; 
    k = left; 
    while ((i <= mid - 1) && (j <= right)) { 
        if (arr[i] <= arr[j]) { 
            temp[k++] = arr[i++]; 
        } 
        else { 
            temp[k++] = arr[j++]; 
            inv_count = inv_count + (mid - i); 
        } 
    } 

    while (i <= mid - 1) 
        temp[k++] = arr[i++]; 

    while (j <= right) 
        temp[k++] = arr[j++]; 

    for (i = left; i <= right; i++) 
        arr[i] = temp[i]; 

    return inv_count; 
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}

