package practice.Testing;

public class StringClass {

	public static void main(String[] args) {

		String str = new String("Anurag");

		changeStr(str);

		System.out.println(str);

	}

	private static void changeStr(String str) {
		str += "ABCD";
	}

}
