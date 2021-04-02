package com.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "PersonEntity")
public class Person {

	@Id
	@Column(name = "PersonId")
	@GeneratedValue
	private int Id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private String gender;

	public Person(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
