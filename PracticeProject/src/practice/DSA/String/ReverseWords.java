package practice.DSA.String;

import java.util.Scanner;

/**
 * Reverse individual words in a sentence.
 * */
public class ReverseWords {

	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(reverse(str));
	
	}
	
	public static String reverse(String str) {
		
		String[] input = str.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : input) {
			StringBuilder sb1 = new StringBuilder(s);
			sb1.reverse();
			sb.append(sb1).append(" ");
		}
		
		return sb.toString();
	}
	
}
