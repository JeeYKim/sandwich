package com.sandwich.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandwich.common.CommandMap;
import com.sandwich.admin.service.OrderAdminService;

@Controller
public class OrderAdminController {
	
	@Autowired
	private OrderAdminService orderService;
	
	@RequestMapping(value = "/orderAdminList")
	public String orderAdminList(CommandMap param, Model model) {
		
		List orderAdminList = orderService.getOrderAdminList(param.getMap());
		model.addAttribute("orderList", orderAdminList);
		
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
