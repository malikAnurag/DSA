package practice.Testing;

class A
{
    static int i;
 
    static
    {
        i = 100;
 
        System.out.println(1);
    }
 
    static void staticMethod()
    {
        System.out.println(i);
 
        System.out.println(2);
    }
}
 
public class B
{

	/*
	final float finalMethod()
    {
        //final method
		return 1.0f;
    }
	
	final int finalMethod() {return 10;}
    
    */
    
	// Gives error of duplicate method and shows that only different return type doesn't matter!!
	
    public static void main(String[] args)
    {
        System.out.println(4);
        
        int marks = 4;
        
        assert marks > 35;
 
        System.out.println(A.i);
 
        A.staticMethod();
    }
}