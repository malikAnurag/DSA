package practice;

public class staticTest {

	int x;
	
	public static void main(String[] args) {

		Laptop lp = new Laptop();
		lp.memory = "ABC";
//		x = 100;
		System.out.println(lp.memory);

	}
}

class Laptop {
	String memory;
}