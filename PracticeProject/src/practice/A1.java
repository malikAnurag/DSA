package practice;

public class A1
{
    static String s = "AAA";
 
    static
    {
        s = s + "BBB";
        System.out.println("Static block A");
    }
 
    {
        s = "AAABBB";
        System.out.println("IIB A");
    }
}
