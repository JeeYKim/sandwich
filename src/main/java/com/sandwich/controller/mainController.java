package com.sandwich.controller;

import java.util.List;

import javax.annotation.Resource;

import com.sandwich.service.mainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class mainController {

	@Resource(name = "mainService")
	private mainService mainService;
	
	@RequestMapping(value="/main.jy", method = RequestMethod.GET)
	public String main(Model model){
				
		@SuppressWarnings("rawtypes")
		List DIYboard = mainService.getBoardList();
		
		@SuppressWarnings("rawtypes")
		List notice = mainService.getNotice();
		
		System.out.println("DIYboard" + DIYboard);
		
		model.addAttribute("DIYboard", DIYboard);
		model.addAttribute("notice", notice);
		
		return "main";
	}

}
