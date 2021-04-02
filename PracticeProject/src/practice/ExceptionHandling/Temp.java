package practice.ExceptionHandling;

public class Temp
{
    public static void throwit()
    {
        throw new RuntimeException();
    }
    public static void main(String args[])
    {
        try
        {
            System.out.println("Hello world ");
            throwit();
            System.out.println("try block ");
        }
        finally
        {
            System.out.println("Finally");
        }
    }
}
