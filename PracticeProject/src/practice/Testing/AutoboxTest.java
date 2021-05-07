package practice.Testing;

public class AutoboxTest {

    public static void main(String[] args) {
        Integer a1 = new Integer(55);
        foo(a1);
    }


    public static void foo(int a) {
        a += 1;
        System.out.println("Result : "+ a);
    }

}
