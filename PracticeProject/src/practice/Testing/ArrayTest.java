package practice.Testing;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {

		boolean[] arr = new boolean[2];
		int[] arr1 = new int[1];

		arr[0] = true;
		arr[1] = false;

		System.out.println(print(arr));
		System.out.println(Arrays.toString(arr));

		System.out.println(printInt(arr1));
		System.out.println(Arrays.toString(arr1));
	}

	public static boolean print(boolean[] arr) {
		return arr[1] = false;
	}

	static int printInt(int[] arr) {
		return arr[0] = 5;
	}
}
