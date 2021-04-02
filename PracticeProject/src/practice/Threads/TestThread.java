package practice.Threads;

public class TestThread {

	public static void main(String[] args) {
		
		byte y[] = {65,66,67,68,69};
		
		String str = new String(y);
		System.out.println(str);
		
		Thread.State[] states = Thread.State.values();
		
		for(Thread.State s :states)
			System.out.println(s.toString());
	}
}


