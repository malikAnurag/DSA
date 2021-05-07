package practice.Testing;

interface InterfaceOne1
{
    default void anyMethod()
    {
        System.out.println("Hi... From Interface One");
    }
}

interface InterfaceTwo1 extends InterfaceOne
{
    @Override
    default void anyMethod()
    {
        System.out.println("Hi... From Interface Two");
    }
}

public class Myclass implements InterfaceOne1, InterfaceTwo1
{
    public static void main(String[] args)
    {
        new Myclass().anyMethod();
    }

    @Override
    public void anyMethod() {
        InterfaceTwo1.super.anyMethod();
    }
}
