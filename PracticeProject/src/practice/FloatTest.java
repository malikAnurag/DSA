package practice;

import java.math.BigDecimal;

public class FloatTest {

    public static void main(String[] args) {

        Float f1 = -10.002f;

        BigDecimal b1 = new BigDecimal(f1);

        System.out.println(b1);

        BigDecimal b2 = new BigDecimal(f1.toString());

        System.out.println(b2);

//        printDouble(f1);
    }


    public static void printDouble(double value) {

        BigDecimal b1 = new BigDecimal(value);
        System.out.println(b1);

    }
}