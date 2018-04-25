package com.spring20180418.ex;

public class Calculator {

	public void add(int f, int s){
		System.out.println("add");
		System.out.println(f + " + " + s + " = " + (f+s));
	}

	public void sub(int f, int s){
		System.out.println("sub");
		System.out.println(f + " - " + s + " = " + (f-s));
	}
	
	public void multi(int f, int s){
		System.out.println("multi");
		System.out.println(f + " * " + s + " = " + (f*s));
	}
	public void div(int f, int s){
		System.out.println("div");
		System.out.println(f + " / " + s + " = " + (f/s));
	}
}
