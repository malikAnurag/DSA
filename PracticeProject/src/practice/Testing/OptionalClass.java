package practice.Testing;

import java.util.Optional;

/*	Even if your optional is not null, then also orElse makes a call to your function which is the overhead.
 * 	But in case of orElseGet the function is only called when the optional object is null. 
 * 
 * */

public class OptionalClass {

	public static void main(String[] args) {

		String nullName = "abc";
		String name = Optional.ofNullable(nullName).orElse(print());
		System.out.println(name);
		System.out.println("----------------------------------------------");
		String name1 = "Anurag";
		String name1Copy = Optional.ofNullable(name1).orElseGet(()->print());
		System.out.println(name1Copy);

	}
	
	public static String print() {
		System.out.println("Method Called!!");
		return "abcd";
	}
}
