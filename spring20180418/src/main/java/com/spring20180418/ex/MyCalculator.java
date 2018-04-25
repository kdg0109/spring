package com.spring20180418.ex;

public class MyCalculator {
	private Calculator calculator;
	private int firstNum;
	private int secondNum;
	
	public MyCalculator() {
		
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public void add(){
		calculator.add(firstNum, secondNum);
	}
	
	public void sub(){
		calculator.sub(firstNum, secondNum);
	}
	
	public void multi(){
		calculator.multi(firstNum, secondNum);
	}
	
	public void div(){
		calculator.div(firstNum, secondNum);
	}
}
