package builderPattern.domainObject;

public class UserBuilder {

	protected final String firstName;
	protected final String lastName;
	protected int age;
	protected String phone;
	protected String address;

    public UserBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }
    public UserBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
    public User build() {
        User user =  new User(this);
        validateUserObject(user);
        return user;
    }
    private void validateUserObject(User user) {
    }
}
