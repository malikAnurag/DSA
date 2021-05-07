package practice.Testing;

public class Xyz extends Thread{

	String k;
	
	Xyz(String t){
		k=t;
	}
	
	public void run() {
		for(int i=1; i<10; i++)
			System.out.print(k+"_"+ i+ "\t");
	}
}
