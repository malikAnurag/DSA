package practice.Testing;

public class AutoBoxTest1 {

    public static void main(String[] args) {
        int a1 = 55;
        foo1(a1);
    }

    public static void foo1(Integer a) {
        a += 1;
        System.out.println("Result : " + a);
    }
}
