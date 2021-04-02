package practice;

public class StringClass {

	public static void main(String[] args) {


		String str = new String("abc");
		String str1 = new String("abc");

		System.out.println(str.equals(str1));


		boolean flag = true;
		String strg = null;
		System.out.println(strg+flag);

		StringBuilder strB = new StringBuilder("hjasbfabk");

		strB.deleteCharAt(4);
		System.out.println(strB);

		System.out.println("192".compareTo("12"));
	}


}
