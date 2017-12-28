package com.sandwich.purchase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.CommandMap;
import com.sandwich.common.Paging;
import com.sandwich.purchase.service.purchaseService;


@Controller

public class purchaseController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource 
	private purchaseService  purchaseService;

	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 10;
	
	private String pagingHtml;
	private Paging page;
	

	

	
	//내가 주문 한 내역 보기
	@RequestMapping(value="/mypurchas.jy")
	public ModelAndView myOrder(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		
		commandMap.put("PURCHASE_ID", session.getAttribute("MEMBER_ID"));
		System.out.println("시발 commandMap 받아라 아이디 " + commandMap.get("PURCHASE_ID"));
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null일때.
			currentPage = 1;
		} else { //currentPage가 null이 아니고 존재할때.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		List<Map<String, Object>> list = purchaseService.myselectPurchaseList(commandMap.getMap()); 
		
		totalCount = list.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "mypurchas.jy");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;


		
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		list = list.subList(page.getStartCount(), lastCount);
		
		System.out.println("주문 내역" + list.size());
		
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("list",list);
			
	

		mav.addObject("ingredientList", list);
		
		mav.addObject("list", list);
		
		mav.setViewName("mypurchase");
		return mav;
	}
	
	//내가 주문 한 내역 상세보기 
	@RequestMapping(value="/mypurchaseDetail.jy")
	public ModelAndView myOrderOne(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		commandMap.put("PURCHASE_ID", session.getAttribute("MEMBER_ID"));
		System.out.println("시발 commandMap 받아라 아이디 " + commandMap.get("PURCHASE_ID"));
		System.out.println("주문 상세 : " + commandMap.get("PURCHASE_NO"));
		
		List<Map<String,Object>> list = purchaseService.myselectPurchaseOne(commandMap.getMap());
		System.out.println("리스트 : " + list.size());
		mav.addObject("list",list);
		
		mav.setViewName("mypurchaseDetail");
		
		return mav;
	}
	
	//장바구니 리스트 보기
	@RequestMapping(value="/basketlist.jy") 
	public ModelAndView basketList(CommandMap commandMap, HttpSession session,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		
		commandMap.put("PURCHASE_ID", session.getAttribute("MEMBER_ID"));
		System.out.println("시발 commandMap 받아라 아이디 " + commandMap.get("PURCHASE_ID"));
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null일때.
			currentPage = 1;
		} else { //currentPage가 null이 아니고 존재할때.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		List<Map<String, Object>> list = purchaseService.selectBasketList(commandMap.getMap()); 
		
		totalCount = list.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "mypurchas.jy");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		list = list.subList(page.getStartCount(), lastCount);
		
		System.out.println("주문 내역" + list.size());
		
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("list",list);
			
		mav.addObject("ingredientList", list);
		
		mav.addObject("list", list);	
		
		System.out.println("장바구니 내역" + list.size());
		mav.addObject("list", list);
		mav.setViewName("basket");
		return mav;
	}
	
	//장바구니 리스트 하나 보기
	@RequestMapping(value="/basketlistone.jy")
	public ModelAndView basketListOne(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		commandMap.put("PURCHASE_ID", session.getAttribute("MEMBER_ID"));
		System.out.println("시발 commandMap 받아라 아이디 " + commandMap.get("PURCHASE_ID"));
		System.out.println("장바구니 상세 : " + commandMap.get("PURCHASE_NO"));
		List<Map<String,Object>> list = purchaseService.basketListOne(commandMap.getMap());
		System.out.println("장바구니 상세");
		mav.addObject("list",list);
		
		 
		mav.setViewName("basketDetail");
		return mav;
	}
	
	// 결제 하기
	@RequestMapping(value="/basketasorder.jy")
	public ModelAndView basketAsOrder(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		System.out.println("장바구니에서 결제");
		commandMap.put("order_yes", 1);
		int amount = 0;
		int amount2 = 0;
		int num2 = 0;

		
		commandMap.put("PURCHASE_ID", session.getAttribute("MEMBER_ID"));
		System.out.println(" commandMap아이디 " + commandMap.get("PURCHASE_ID"));
		System.out.println("장바구니 상세 : " + commandMap.get("PURCHASE_NO"));
		List<Map<String,Object>> list = purchaseService.basketListOne(commandMap.getMap());
		Map<String, Object> list2 = null;
		Map<String, Object> list3 = null;
		List<Map<String,Object>> check = purchaseService.endDateOver(commandMap.getMap());
		
		if(check.size() > 0){ 
			purchaseService.sandDataOverAsGarbage(check);
			purchaseService.sandDataOver(check);  
			System.out.println("성공적");
		}

		for (int i = 0; i <= list.size() - 1; i++) {
			try {
				list2 = purchaseService.countfind((String) list.get(i).get("PURCHASE_SMALLTYPE"));
				amount = Integer.parseInt(String.valueOf(list2.get("SANDWICH_AMOUNT")));
				num2 = Integer.parseInt(String.valueOf(list.get(i).get("PURCHASE_AMOUNT")));
				System.out.println("amount : " + amount + "num2 : " + num2);
				amount = amount - num2;
				System.out.println("amount 결과값 : " + amount);
					if (amount < 0) {
						
						try {
							list3 = purchaseService.countfind2((String) list.get(i).get("PURCHASE_SMALLTYPE"));
							amount2 = (Integer) list3.get("SANDWICH_AMOUNT");
							System.out.println("amount2 : " + amount2 + "num2 : " + num2);
							amount2 = amount2 - num2;
							if (amount2 < 0) {
								System.out.println("3번째 걸림");
								mav.setViewName("sandwichnono");
								return mav;
							} else {
					
								list3.remove("SANDWICH_AMOUNT");	
								list3.put("SANDWICH_AMOUNT", Integer.parseInt(String.valueOf(amount2)));
								amount2 = 0;							
								purchaseService.countSubPurchase(list3); 
							}
						} catch (Exception e) {

							System.out.println("2번째 걸림" + e);
							mav.setViewName("sandwichnono");
							return mav;
						}
					} else {					
						
							list2.remove("SANDWICH_AMOUNT");
							list2.put("SANDWICH_AMOUNT", Integer.parseInt(String.valueOf(amount)));
							amount = 0;		
							purchaseService.countSubPurchase(list2); 
							
					
					}		
			} catch (Exception e) {
				System.out.println("1번째 걸림" + e);
				mav.setViewName("sandwichnono");
				return mav;
			}
		}		
		purchaseService.sandwichPurchase(commandMap.getMap());
		purchaseService.basketAsPurchase(commandMap.getMap());
		mav.setViewName("basketAsPurchase");
		return mav;
	}
	

	
	//장바구니 넣기
	@RequestMapping(value="/basketdelete.jy")
	public String purchaseToBasket(CommandMap commandMap, HttpSession session) throws Exception{

		
		commandMap.put("PURCHASE_ID", session.getAttribute("MEMBER_ID"));
		purchaseService.basketdelete(commandMap.getMap());
		System.out.println("1 "+ session.getAttribute("MEMBER_ID") + commandMap.get("PURCHASE_NO"));
		
		
		return "redirect:/basketlist.jy";
	}
	

}
