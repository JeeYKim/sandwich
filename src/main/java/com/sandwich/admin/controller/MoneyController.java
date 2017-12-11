package com.sandwich.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandwich.admin.service.MoneyService;
import com.sandwich.common.CommandMap;

@Controller
public class MoneyController {

	@Resource(name="moneyService")
	private MoneyService moneyService;

	@RequestMapping(value="/MoneyList")
	public String moneyList(Model model, CommandMap DATE) {
		
		List moneyList = moneyService.getMoneyList(DATE.getMap());

		HashMap DATE1=(HashMap) DATE.getMap();
		
		System.out.println("DATE : " +DATE1);
		System.out.println("moneyList  :  "+moneyList);
		
		model.addAttribute("moneyList", moneyList);
		model.addAttribute("DATE1", DATE1);
		
		return "moneyList";
	}
	
	@RequestMapping(value="/MoneyChart")
	public String moneyChart(Model model, CommandMap DATE) {
		List moneyList = moneyService.getMoneyList(DATE.getMap());
		
		HashMap DATEweek=(HashMap) DATE.getMap();
		
		model.addAttribute("moneyList", moneyList);
		model.addAttribute("DATEweek", DATEweek);
		
		return "moneyChart";
	}
}
