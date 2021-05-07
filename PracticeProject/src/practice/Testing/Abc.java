package practice.Testing;

public class Abc {

	public static void main(String[] args) throws InterruptedException {
		
		Xyz t1 = new Xyz("A");
		Xyz t2 = new Xyz("B");
		
		System.out.println(t1);
		System.out.println(t2);
		t1.start();
		t1.join();
		
		
		t2.start();
		
//		while(t1.isAlive() || t2.isAlive()); // To wait for both the threads to die
		
		t2.join();
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getPriority());
		System.out.println("OVER!!");
	}
}
