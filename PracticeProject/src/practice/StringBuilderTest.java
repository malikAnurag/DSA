package practice;

import java.math.BigDecimal;

public class StringBuilderTest {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("abcd");
		sb.deleteCharAt(2);
		System.out.println(sb);

		System.out.println(Integer.valueOf(String.valueOf('8'), 16));

		System.out.println(Integer.valueOf("0000"));

		BigDecimal bd = new BigDecimal("000000");
		System.out.println(bd.equals(new BigDecimal("0")));
	}
	
}
