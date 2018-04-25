package com.spring20180420.ex1;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student1(){
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동");
		student.setAge(10);
		student.setHobbys(hobbys);
		
		return student;
	}
	
	@Bean
	public Student student2(){

		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("검도");
		hobbys.add("꽃꽃이");
		
		Student student = new Student("홍길금");
		student.setAge(50);
		student.setHobbys(hobbys);
		
		return student;
	}
}
