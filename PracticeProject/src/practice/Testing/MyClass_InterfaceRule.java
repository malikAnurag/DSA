package practice.Testing;


/*
 * The method from the more specific interface is called in this case. More specific interface here is interfaceTwo!! 
 * 
 * */
	interface InterfaceOne
	{
	    default void anyMethod()
	    {
	        System.out.println("Hi... From Interface One");
	    }
	}
	 
	interface InterfaceTwo extends InterfaceOne
	{
	    @Override
	    default void anyMethod() 
	    {
	        System.out.println("Hi... From Interface Two");
	    }
	}
	 
	public class MyClass_InterfaceRule implements InterfaceOne, InterfaceTwo
	{
	    public static void main(String[] args) 
	    {
	        new MyClass_InterfaceRule().anyMethod();
	    }
	}

