package com.sandwich.staff.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sandwich.common.CommandMap;
import com.sandwich.common.Paging;
import com.sandwich.staff.service.OrderService;

@Controller
public class OrderController {
	private int blockCount = 10;
	private int blockPage = 10;
	
	@Autowired
	private OrderService orderService; 
	
	@RequestMapping(value = "/orderWriteForm")
	public String orderWriteForm(Model model) 
			throws JsonGenerationException, JsonMappingException, IOException {
		List sandwichs = orderService.getSandwich();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(sandwichs);
		
		model.addAttribute("sandwichList", json);
		return "orderWriteForm";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/orderSave")
	public String orderSave(Model model, CommandMap order) {

		int memberId = 1;
		
		order.put("memberId", memberId);
		
		orderService.saveOrder(order);
		
		return "redirect:orderList.jy";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/orderList")
	public String orderList(CommandMap param, Model model) {
		int currentPage, totalCount;
		
		if(param.get("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.valueOf( (String) param.get("currentPage") );
		}
		
		//totalCount = orderService.getOrderListCount(param.getMap());
		List orderList = orderService.getOrderList(param.getMap());
		
		totalCount = orderList.size();
		Paging page = new Paging(currentPage, totalCount, blockCount, blockPage, "orderList.jy");
		String pagingHtml = page.getPagingHtml().toString();
		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		orderList = orderList.subList(page.getStartCount(), lastCount);
		
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("orderList", orderList);

		return "orderList";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/orderView")
	public String orderView(int orderNo, Model model)  {
		
		HashMap order = orderService.getOrder(orderNo);
		model.addAttribute("order", order);
		
		return "orderView";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/orderModifyForm")
	public String orderModifyForm(int orderNo, Model model)  {
		HashMap order = orderService.getOrder(orderNo);
		model.addAttribute("order", order); 
		
		return "orderModifyForm";
	}
	
	@RequestMapping(value = "/orderDelete")
	public String orderDelete(int orderNo){
		
		orderService.orderDelete(orderNo);
		
		return "redirect:orderList.jy";	
		
	}
}