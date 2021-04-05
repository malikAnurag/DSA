package practice;


public class IntegerTest {

    public static void main(String[] args) {

        try {

            Integer k = 10/0;
            System.out.println(k);

            Integer i = Integer.parseInt("abc");
            System.out.print(i);

        } catch (ArithmeticException | NumberFormatException e) {
            e.printStackTrace();
            System.out.print("Exception caught!!");
        }
    }
}
