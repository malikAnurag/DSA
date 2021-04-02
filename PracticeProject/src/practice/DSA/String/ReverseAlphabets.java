package practice.DSA.String;

/**
 * Reverse the string leaving special characters intact at their original positions!
 * */

public class ReverseAlphabets {

	public static void main(String[] args) {

		String s = new String("a@b$&c(de)");
//		String s1 = "Anurag is my full name";
		System.out.println("Original String: " + s);
		System.out.println("Reversed string: " + reverseAlpha(s));

	}

	public static String reverseAlpha(String str) {

		int left = 0;
		int right = str.length() - 1;

		char[] c = str.toCharArray();

		while (left < right) {
			if (!Character.isAlphabetic(c[left]))
				left++;
			else if (!Character.isAlphabetic(c[right]))
				right--;
			else {
				char temp = c[left];
				c[left] = c[right];
				c[right] = temp;
				left++;
				right--;
			}
		}
		return new String(c);
	}
}
