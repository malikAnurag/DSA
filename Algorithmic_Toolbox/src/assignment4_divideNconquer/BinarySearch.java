package assignment4_divideNconquer;

import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(Integer[] a, int x) {
        int l = 0, r = a.length-1;
        return binary(a,l,r,x);
    }

    static int binary(Integer[] a, int l, int r, int x) {
    	    
        while(l<=r) {
        	int mid = l + (r-l)/2 ;
        		if(a[mid]==x) {
        			return mid;
        		}else if(a[mid] > x) {
        			r = mid-1;
        		}
        		else {
        			l = mid+1;
        		}
        }
    		return -1;
    }
    
    static int linearSearch(Integer[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, b[i]) + " ");
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
