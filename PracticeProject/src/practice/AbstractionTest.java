package practice;

public class AbstractionTest extends ABC{

    public void foo() {
        System.out.println("foo");
    }

    @Override
    public void foo1() {

    }

    public static void main(String[] args) {

        AbstractionTest ab = new AbstractionTest();
        ab.foo();
    }

}


abstract class ABC {

    public void foo() {
        System.out.println("foo");
    }

    public abstract void foo1();

}
