package assignment4_divideNconquer;

import java.util.*;
import java.io.*;

public class MajorityElementLogN {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        Arrays.sort(a);
        int n = a.length;
        boolean flag = false;
        for(int x : a) {
        		int i = binarySearch(a,left,right,x);
        		if((i+1+n/2)<= n-1 && a[i+1+n/2]==x) {
        			flag = true;
        			break;
        		}
        }
        if(flag)
        		return 5;
        return -1;
    }

    public static int binarySearch(int[] arr, int l, int r, int x) {
    	
    	if(l<=r) {
    		int mid = l + (r-l)/2;
    		if((mid==0 || arr[mid-1]<x) && arr[mid]==x)
    			return mid;
    		else if(arr[mid]>x)
    			return binarySearch(arr,l,mid-1,x);
    		else if(arr[mid]<x)
    			return binarySearch(arr,mid+1,r,x);
    	}
    		return -1;
    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

