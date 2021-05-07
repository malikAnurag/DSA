package practice.Testing;

public class StringTest
{

	public static void main(String[] args) {

		String s = "";
		giveMeString(s);
		System.out.println("New String: " + s);

		System.out.println("leetcodeILove".indexOf("e"));

	}

	public static void giveMeString(String x) {
		x+="abc";
	}
}
