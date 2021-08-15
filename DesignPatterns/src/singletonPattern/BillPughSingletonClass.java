package singletonPattern;

public class BillPughSingletonClass {

	private BillPughSingletonClass() {
		// private constructor
	}

	// Inner class to provide instance of class
	private static class BillPughSingleton {
		private static final BillPughSingletonClass INSTANCE = new BillPughSingletonClass();
	}

	public static BillPughSingletonClass getInstance() {
		return BillPughSingleton.INSTANCE;
	}
}