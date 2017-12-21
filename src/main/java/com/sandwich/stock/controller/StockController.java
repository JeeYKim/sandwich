package com.sandwich.stock.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.sandwich.common.CommandMap;
import com.sandwich.stock.service.StockService;

@Controller
public class StockController {

	@Resource
	private StockService stockService;
	@RequestMapping(value = "/admin.jy", method = RequestMethod.GET)
	public String dateList(Model model, CommandMap commandMap)throws Exception{
		
		List<Map<String,Object>>dateList = stockService.dateList(commandMap.getMap());
		List<Map<String,Object>>stockList = stockService.stockList(commandMap.getMap());
		
		
		model.addAttribute("dateList", dateList);
		model.addAttribute("stockList", stockList);
		
		return "admin_main";
	}
	
	@RequestMapping(value = "/staff.jy", method = RequestMethod.GET)
	public String dateList_staff(Model model, CommandMap commandMap)throws Exception{
		
		List<Map<String,Object>>dateList = stockService.dateList(commandMap.getMap());
		List<Map<String,Object>>stockList = stockService.stockList(commandMap.getMap());
		
		
		model.addAttribute("dateList", dateList);
		model.addAttribute("stockList", stockList);
		
		return "staff_main";
	}
	
	
	
	
}
