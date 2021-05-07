package practice.Testing;

public class ThreadTest1 {

	public static void main(String[] args) {
		
		
		Thread t1 = new Thread() {
			
			@Override
			public void run() {
				System.out.println("Runs successfully!!");
			}
		};
		t1.start();
		System.out.println("Main");
	}
	
	
	class T3 implements Runnable{

		@Override
		public void run() {
			System.out.println("Runnable");
			
		}
		
	}
}
