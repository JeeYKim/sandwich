package com.sandwich.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandwich.admin.service.StaffMoneyService;
import com.sandwich.common.CommandMap;
import com.sandwich.common.Paging;

@Controller
public class StaffMoneyController {


	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 10;
	
	private String pagingHtml;
	private Paging page;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="staffMoneyService")
	 private StaffMoneyService staffMoneyService;
	
	@RequestMapping(value=" /staffMoney")
	public String staffMoneyList(Model model, HttpServletRequest request)throws Exception{
		
		List staffMoney = staffMoneyService.getStaffMoney();
		
		List staffId = staffMoneyService.getStaffId();
		
		System.out.println("staffID : " + staffId);
		
	
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null일때.
			currentPage = 1;
		} else { //currentPage가 null이 아니고 존재할때.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		totalCount = staffMoney.size();
		
		int lastCount = totalCount;
		
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "staffMoney.jy");
		pagingHtml = page.getPagingHtml().toString();
		
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		staffMoney = staffMoney.subList(page.getStartCount(), lastCount);
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("staffMoney", staffMoney);
		model.addAttribute("staffId", staffId);
		
		return "staffMoneyList";
	}
	
	@RequestMapping(value ="/staffMoneyInsert")
	public String staffMoneyInsert(Model model, CommandMap commandmap) throws Exception{
		
		staffMoneyService.staffMoneyInsert(commandmap);
		
		return "redirect:/staffMoney.jy";
		
	}
	
	@RequestMapping(value="/staffMoneyDelete")
	public String staffMoneyDelete(int STAFF_NO) {
		
		staffMoneyService.staffMoneyDelete(STAFF_NO);
		
		return "redirect:/staffMoney.jy";
	}
	
	
}
