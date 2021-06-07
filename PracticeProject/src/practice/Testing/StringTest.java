package practice.Testing;

import java.util.Arrays;

public class StringTest
{

	public static void main(String[] args) {

		String s = "";
		giveMeString(s);
		System.out.println("New String: " + s);

		System.out.println("leetcodeILove".indexOf("e"));

		String[] products = {"AnuMalik", "Anura", "Anush","asdad"};
		Arrays.sort(products);

		int k = Arrays.binarySearch(products, "Anu");
//		k = ~k;

		System.out.println("k = " + k);

	}

	public static void giveMeString(String x) {
		x+="abc";
	}
}
