package builderPattern.main;

import builderPattern.domainObject.User;
import builderPattern.domainObject.UserBuilder;

public class main {

	public static void main(String ars[]) {

		User user1 = new UserBuilder("Lokesh", "Gupta")
							.setAge(30)
							.setPhone("1234567")
							.setAddress("Fake address 1234")
							.build();

		System.out.println(user1);

		User user2 = new UserBuilder("Jack", "Reacher")
						.setAge(40)
						.setPhone("5655")
						.build();

		System.out.println(user2);

		User user3 = new UserBuilder("Super", "Man")
						.build();

		System.out.println(user3);

	}
}
