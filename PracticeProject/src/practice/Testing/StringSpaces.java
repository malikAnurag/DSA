package practice.Testing;

import java.util.ArrayList;
import java.util.Scanner;

public class StringSpaces {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(getReversed(str));
	}
	
	
	public static String getReversed(String str) {
		
		char[] input = str.toCharArray();
		
		ArrayList<Integer> spaces = new ArrayList<>();
		
		for(int i = 0; i<input.length; i++)
		{
			if(input[i]==' ') {
				spaces.add(i);
			}
		}
		
		String str1 = str.replaceAll("\\s", "");
		StringBuilder sb = new StringBuilder(str1);
		sb.reverse();
		
		StringBuilder sb1 = new StringBuilder();
		
		int counter = 0;
		for(int j=0; j< str.length(); j++)
		{
			if(spaces.contains(j)) {
				sb1.append(" ");
				continue;
			}
			sb1.append(sb.charAt(counter++));
		}
		
		return sb1.toString();
		
	}
	
}
