package practice.Java8;

interface InterfaceOne
{
    default void anyMethod()
    {
        System.out.println("Hi... From Interface One");
    }
}

interface InterfaceTwo
{
    default void anyMethod()
    {
        System.out.println("Hi... From Interface Two");
    }
}

public class DefaultMethodTest implements InterfaceOne
{
    @Override
    public void anyMethod()
    {
        InterfaceOne.super.anyMethod();
    }

    public static void main(String[] args)
    {
        new DefaultMethodTest().anyMethod();
    }
}
