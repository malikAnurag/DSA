package practice.Testing;

public class ExceptionTest {
	

	public void f1() {//throws Exception{}{
		
		try {
			int x=100;
		}
//		catch(Exception e) {e.printStackTrace();}
		catch(ArithmeticException | NumberFormatException a) {a.printStackTrace();}
		
	}
}

class childClass extends ExceptionTest{
	
//	public void f1() throws Exception{}
}
