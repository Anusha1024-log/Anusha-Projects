package org.training.juneau;

import java.util.Arrays;

import org.apache.juneau.annotation.Beanc;

public class Details {
	
	String name;
	int age;
	String address;
	String[] skills;
	
	@Beanc(properties = "name,age,address,skills")
	public Details(String name, int age, String address, String[] skills) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.skills = skills;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}


	@Override
	public String toString() {
		return "Details [name=" + name + ", age=" + age + ", address=" + address + ", skills=" + Arrays.toString(skills)
				+ "]";
	}
	
}
