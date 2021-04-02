package assignment2_Fibonacci;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long[] fibo = calc_fib_mod(1000L, m);
        
        int periodicity = 0;
        
        for(int i = 2 ; i<fibo.length-1 ; i++)
        {
        		if(fibo[i] == 0 && fibo[i+1] == 1) {
        			periodicity = i ;
        			break;
        		}
        }
    
        int fiboNum = (int) (n % periodicity);
        System.out.println("FiboNum: "+fiboNum);
        System.out.println("Result: "+ calc_fib(fiboNum)%m);
        return periodicity;
    }
    
    private static long[] calc_fib_mod(long n, long m) {
  	  
  	  long[] F = new long[(int) (n+1)];
  	  
  	  F[0] = 0;
  	  F[1] = 1;
  	  
  	  for(int i= 2 ; i<=n ; i++)
  		  F[i] = (F[i-1] + F[i-2]) % m;

      return F;
    }
    
    
    private static long calc_fib(int n) {
  	  
  	  if(n<=1)
  		  return n;
  	  
  	  int[] F = new int[n+1];
  	  
  	  F[0] = 0;
  	  F[1] = 1;
  	  
  	  for(int i= 2 ; i<=n ; i++)
  		  F[i] = F[i-1] + F[i-2];

      return F[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        getFibonacciHugeNaive(n, m);
        //System.out.println(getFibonacciHugeNaive(n, m));
    }
}

