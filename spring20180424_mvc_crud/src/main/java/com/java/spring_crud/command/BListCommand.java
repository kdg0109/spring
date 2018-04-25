package com.java.spring_crud.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.java.spring_crud.dao.BDao;
import com.java.spring_crud.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {

		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
		
	}

}
