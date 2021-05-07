package practice.Testing;

public class HashCodeTest {

	
	public static void main(String[] args) {
		
		Integer i1 = 2;
		Long i2 = 2L;
		Double i3 = (double)2;
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		System.out.println(i3.hashCode());
		
	}
}
