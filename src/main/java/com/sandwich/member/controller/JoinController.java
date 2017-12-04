package com.sandwich.member.controller;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.CommandMap;
//import com.sandwich.common.common.CommandMap;
import com.sandwich.member.service.JoinService;
@Controller
public class JoinController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private JoinService joinService;

	@RequestMapping(value="/join.jy")
	public ModelAndView JoinForm()throws Exception{
		ModelAndView mav = new ModelAndView("/member/join");
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/join.jy", method=RequestMethod.POST)
	public ModelAndView JoinS(CommandMap commandMap) throws Exception{
		ModelAndView mav = new ModelAndView("main");
		
		
		
		
		joinService.insertMember(commandMap.getMap()); 
		
		
		return mav;
	}
}
		
