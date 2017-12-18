package com.sandwich.member.controller;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.CommandMap;
import com.sandwich.member.service.JoinService;

@Controller
public class JoinController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private JoinService joinService;
    
	//회원가입 폼
	@RequestMapping(value="/join.jy")
	public ModelAndView JoinForm() throws Exception{
		ModelAndView mav = new ModelAndView("join");
		
		
		
		return mav;
	}
	
	//회원가입 성공시
	@RequestMapping(value="/join.jy", method=RequestMethod.POST)
	public ModelAndView JoinSuccess(CommandMap commandMap) throws Exception{
		ModelAndView mav = new ModelAndView("main");
		
		
		System.out.println("ID : "+commandMap.get("MEMBER_ID"));
		System.out.println("PW : "+commandMap.get("MEMBER_PW"));
		System.out.println("NAME : "+commandMap.get("MEMBER_NAME"));
		System.out.println("EMAIL : "+commandMap.get("MEMBER_EMAIL"));
		
		joinService.insertMember(commandMap.getMap()); 
		
		
		return mav;
	}
	
	//아이디 중복 체크
	@RequestMapping(value="/checkId.jy")
	@ResponseBody
	public  int checkId(HttpServletRequest request,HttpServletResponse response, CommandMap commandMap) throws Exception
	{
		//스크립트에 넘겨준id 값을 받음
		String mem_id = (String) commandMap.getMap().get("mem_id");

		//을 MEMBER_ID 값으로 map에 다시 넣어줌
		commandMap.getMap().put("MEMBER_ID", mem_id);
		
		//MEMBER 테이블에 입력한 ID가 있는지에 대한 여부 체크
		int checkId = joinService.checkId(commandMap.getMap());
		
		System.out.println("checkId="+checkId);
		System.out.println(commandMap.getMap());
		
	   return checkId;
	}
	
}
	