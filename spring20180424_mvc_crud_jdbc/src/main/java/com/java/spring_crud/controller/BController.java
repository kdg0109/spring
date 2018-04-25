package com.java.spring_crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring_crud.command.BCommand;
import com.java.spring_crud.command.BContentCommand;
import com.java.spring_crud.command.BDeleteCommand;
import com.java.spring_crud.command.BListCommand;
import com.java.spring_crud.command.BModifyCommand;
import com.java.spring_crud.command.BReplyCommand;
import com.java.spring_crud.command.BReplyViewCommand;
import com.java.spring_crud.command.BWriteCommand;
import com.java.spring_crud.util.Constant;

//auto scan에 걸림

@Controller
public class BController {

	BCommand command;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template){
		this.template = template;
		Constant.template = this.template;
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	//작성할 페이지로
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	//작성 다 했을 때
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	//게시판 글 클릭했을 때
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	//답변 보는거
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model){
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	//답변 하는거
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model){
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
