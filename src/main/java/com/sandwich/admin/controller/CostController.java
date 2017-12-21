package com.sandwich.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandwich.admin.service.CostService;
import com.sandwich.common.CommandMap;
import com.sandwich.common.Paging;

@Controller
public class CostController {

	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 10;
	
	private String pagingHtml;
	private Paging page;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="costService")
	 private CostService costService;
	
	@RequestMapping(value=" /cost")
	public String costList(Model model, HttpServletRequest request) throws Exception{
		
		List cost = costService.getCost();
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null일때.
			currentPage = 1;
		} else { //currentPage가 null이 아니고 존재할때.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		totalCount = cost.size();
		
		int lastCount = totalCount;
		
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "cost.jy");
		pagingHtml = page.getPagingHtml().toString();
		
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		cost = cost.subList(page.getStartCount(), lastCount);
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("cost", cost);
		
		return "costList";
	}
	
	@RequestMapping(value ="/costInsert")
	public String costInsert(Model model, CommandMap commandmap) throws Exception{
		
		costService.costInsert(commandmap);
		
		return "redirect:/cost.jy";
		
	}
	
	@RequestMapping(value="/costDelete")
	public String CostDelete(int COST_NO) {
		
		costService.costDelete(COST_NO);
		
		return "redirect:/cost.jy";
	}
	
	
}
