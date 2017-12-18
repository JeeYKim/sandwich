package com.sandwich.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandwich.common.CommandMap;
import com.sandwich.common.Paging;
import com.sandwich.admin.service.OrderAdminService;

@Controller
public class OrderAdminController {
	
	private int blockCount = 10;
	private int blockPage = 10;
	
	@Autowired
	private OrderAdminService orderService;
	
	@RequestMapping(value = "/orderAdminList")
	public String orderAdminList(CommandMap param, Model model) {
		int currentPage, totalCount;

		if (param.get("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.valueOf((String) param.get("currentPage"));
		}
		
		
		List orderAdminList = orderService.getOrderAdminList(param.getMap());
		totalCount = orderAdminList.size();
		Paging page = new Paging(currentPage, totalCount, blockCount, blockPage, "orderAdminList.jy");
		String pagingHtml = page.getPagingHtml().toString();
		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		orderAdminList = orderAdminList.subList(page.getStartCount(), lastCount);
		
		model.addAttribute("orderList", orderAdminList);
		model.addAttribute("pagingHtml", pagingHtml);
		return "orderAdminList";
	}
	
	@RequestMapping(value = "/orderApproval")
	public String orderApproval(int orderNo){
		
		orderService.orderApproval(orderNo);
		return "redirect:orderAdminList.jy";
	}
	
	@RequestMapping(value = "/orderNoapproval")
	public String orderNoapproval(int orderNo) {
		
		orderService.orderNoapproval(orderNo);
		return "redirect:orderAdminList.jy";
	}
}
