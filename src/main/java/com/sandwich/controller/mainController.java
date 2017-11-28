package com.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller

public class mainController {

	@RequestMapping(value="/main.jy", method = RequestMethod.GET)
	public String main(){
		
		System.out.println("왜안돼?");

		return "main";
	}
	@RequestMapping(value="/admin.jy", method=RequestMethod.GET)
	public String admin() {
	
		return "admin_main";
	}
	
	@RequestMapping(value="/staff.jy", method=RequestMethod.GET)
	public String staff() {
	
		return "staff_main";
	}
}
