package com.learning.design.patterns.creational;

public class BuilderDemo {

	public static void main(String[] args) {
		User user = new UserBuilder()
				.firstName("ajay")
				.lastName("vijay")
				.age(30)
				.address("bengaluru")
				.build();
		System.out.println(user);
		
		//java examples
		StringBuilder stringBuilder =  new StringBuilder();
		// all instances of java.lang.Appendable interface

	}

}

class User {
	String firstName;
	String lastName;
	int age;
	String address;
	String phone;

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", phone=" + phone + "]";
	}

}

class UserBuilder {

	User user;

	public UserBuilder() {
		this.user = new User();
	}

	public UserBuilder firstName(String firstName) {
		if (firstName != null) {
			user.firstName = firstName;
		}
		return this;
	}

	public UserBuilder lastName(String lastName) {
		if (lastName != null) {
			user.lastName = lastName;
		}
		return this;
	}

	public UserBuilder age(int age) {
		if (age > 0) {
			user.age = age;
		}
		return this;
	}

	public UserBuilder address(String address) {
		if (address != null) {
			user.address = address;
		}
		return this;
	}

	public UserBuilder phone(String phone) {
		if (phone != null) {
			user.phone = phone;
		}
		return this;
	}

	public User build() {
		return this.user;
	}
}
