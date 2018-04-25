package com.spring20180420.ex1;

import java.util.ArrayList;

public class Student {

	private String name;
	private int age;
	private ArrayList<String> hobbys;
	
	public Student(String name){
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	
	
	
}
