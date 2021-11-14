package practice.Testing;

public class BooleanTest {
	
	public static void main(String[] args) {

		System.out.println("abc" instanceof String);
//
		System.out.println(isTrue());

	}
	
	public static boolean isTrue() {
		
		return (true || true && false);
	}
}
