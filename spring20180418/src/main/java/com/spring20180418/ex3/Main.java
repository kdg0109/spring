package com.spring20180418.ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String configLoc = "classpath:applicationCTX3.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		
		ctx.close();
	}
}
