package com.spring20180418.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String configLoc = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		Myinfo myinfo = ctx.getBean("myinfo", Myinfo.class);
		
		myinfo.getInfo();
		
		ctx.close();
	}
}
