package practice;

import java.util.ArrayList;

public class Streams {

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);al.add(2);al.add(3);
		final int a=10;
		al.stream().forEach(t->{
//			a++;
		});
	}
}
