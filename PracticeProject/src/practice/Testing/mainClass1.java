package practice.Testing;

import java.util.Arrays;
import java.util.List;

class Test1 {

	int i=10;
	
	public Test1(int i) {
		this.i=i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	
}

public class mainClass1{
	
	public static void main(String[] args) {
		
		Test1 t1 = new Test1(100);
		Test1 t2 = new Test1(101);
		List<Integer> al = Arrays.asList(5,10,11,13);
		al.stream().forEach((i)->{
			t1.setI(67);
//			t1=t2;
		});
		
		System.out.println(t1.i);
	}
}
