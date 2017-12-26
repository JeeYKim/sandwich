package com.sandwich.purchase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class testController {
	
	@RequestMapping("test11.jy")
	public String testForm() {
		return "/test11";
	}
	
	@RequestMapping("test1.jy")
	public String test(Model model) {
		String result = "모델전송 가능한가";
		model.addAttribute(result, result);
		
		return "/test22";
	}

}
