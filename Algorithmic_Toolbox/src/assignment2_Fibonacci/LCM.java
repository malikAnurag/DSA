package assignment2_Fibonacci;

import java.util.*;



/*
 * a * b = LCM(a,b) * HCF(a,b)
 * 
 * */
public class LCM {
  private static long lcm_naive(long a, long b) {
    
	  long gcd = GCD(a,b);
	  
	  return (long)(a*b)/gcd;
  }

  
  private static long GCD(long a, long b) {
	  
	  if(a==0)
		  return b;
	  return GCD(b%a,a);
  }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    System.out.println(lcm_naive(a, b));
  }
}
