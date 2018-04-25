package com.spring20180418.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String configLoc = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);

		myCalculator.add();
		myCalculator.sub();
		myCalculator.multi();
		myCalculator.div();
		
		ctx.close();
	}
}
