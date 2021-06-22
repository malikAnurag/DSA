package practice.Testing;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {

		boolean[] arr = new boolean[2];
		arr[0] = true;
		arr[1] = false;

		System.out.println(print(arr));

		System.out.println(Arrays.toString(arr));
	}

	public static boolean print(boolean[] arr) {
		return arr[1] = true;
	}
}
