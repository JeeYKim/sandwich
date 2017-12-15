package com.sandwich.purchase.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.CommandMap;
import com.sandwich.purchase.service.purchaseService;


@Controller

public class purchaseController {
	Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource 
	private purchaseService  purchaseService;
	
	//주문 하러 가기
	@RequestMapping(value="/order.jy", method = RequestMethod.GET)
	public String order_main(){
		
		
		System.out.println("주문");
		
		return "purchase";
	}
	
	

	
	//내가 주문 한 내역 보기
	@RequestMapping(value="/mypurchas.jy")
	public ModelAndView myOrder(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		session.setAttribute("PURCHASE_ID", "min");
		commandMap.put("PURCHASE_ID", session.getAttribute("PURCHASE_ID"));
		System.out.println("시발 commandMap 받아라 아이디 " + commandMap.get("PURCHASE_ID"));
		 
		List<Map<String, Object>> list = purchaseService.myselectPurchaseList(commandMap.getMap()); 
		System.out.println("주문 내역" + list.size());
		mav.addObject("list", list);
		
		mav.setViewName("mypurchase");
		return mav;
	}
	
	//내가 주문 한 내역 상세보기 
	@RequestMapping(value="/mypurchaseDetail.jy")
	public ModelAndView myOrderOne(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		commandMap.put("PURCHASE_ID", session.getAttribute("PURCHASE_ID"));
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
	public ModelAndView basketList(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		
		commandMap.put("PURCHASE_ID", session.getAttribute("PURCHASE_ID"));
		System.out.println("시발 commandMap 받아라 아이디 " + commandMap.get("PURCHASE_ID"));
		 
		List<Map<String, Object>> list = purchaseService.selectBasketList(commandMap.getMap()); 
		System.out.println("장바구니 내역" + list.size());
		mav.addObject("list", list);
		mav.setViewName("basket");
		return mav;
	}
	
	//장바구니 리스트 하나 보기
	@RequestMapping(value="/basketlistone.jy")
	public ModelAndView basketListOne(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		commandMap.put("PURCHASE_ID", session.getAttribute("PURCHASE_ID"));
		System.out.println("시발 commandMap 받아라 아이디 " + commandMap.get("PURCHASE_ID"));
		System.out.println("장바구니 상세 : " + commandMap.get("PURCHASE_NO"));
		List<Map<String,Object>> list = purchaseService.basketListOne(commandMap.getMap());
		System.out.println("장바구니 상세");
		mav.addObject("list",list);
		
		 
		mav.setViewName("basketDetail");
		return mav;
	}
	
	//장바구니에서 결제 하기
	@RequestMapping(value="/basketasorder.jy")
	public ModelAndView basketAsOrder(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		System.out.println("장바구니에서 결제");
		commandMap.put("order_yes", 1);
		String key;

		
		commandMap.put("PURCHASE_ID", session.getAttribute("PURCHASE_ID"));
		System.out.println("시발 commandMap 받아라 아이디 " + commandMap.get("PURCHASE_ID"));
		System.out.println("장바구니 상세 : " + commandMap.get("PURCHASE_NO"));
		List<Map<String,Object>> list = purchaseService.basketListOne(commandMap.getMap());
		List<Map<String,Object>> list4 = null;
		List<Map<String,Object>> check = purchaseService.endDateOver(commandMap.getMap());
		
		System.out.println("CHECK의 값" + check.size());
		if(check.size() > 0){ 
			 
			purchaseService.sandDataOverAsGarbage(check);
			System.out.println("성공적");
			purchaseService.sandDataOver(check);  
			System.out.println("성공적,쩔어");
		}
		
		 Iterator<String> iterator = list.get(0).keySet().iterator();
		 while (iterator.hasNext()) {
		         key = (String) iterator.next();
		        System.out.print(" key = "+key);
		        System.out.print("value = " + list.get(0).get(key));
		    }
		 
		for(int i=0; i<=list.size(); i++){  
 
			List<Map<String,Object>> list2 = purchaseService.countfind((String) list.get(i).get("PURCHASE_SMALLTYPE")); 
			System.out.println(list2.size());
			int amount = (Integer) list2.get(i).get("SANDWITCH_AMOUNT"); 
			System.out.println(amount);
			if(amount < 0){
				List<Map<String,Object>> list3 = purchaseService.countfind2((String) list.get(i).get("PURCHASE_SMALLTYPE")); 
				int amount2 = (Integer) list3.get(i).get("SANDWITCH_AMOUNT");
				if(amount2 <0){
					System.out.println(list.get(i).get("SANDWITCH_SMALLTYPE") + " 의 개수가 부족합니다.");
					mav.setViewName("basketasorder");
					return mav;
				}else{
					list4 = (List<Map<String, Object>>) list3.get(i);
				}
			}else{
				list4 = (List<Map<String, Object>>) list2.get(i);
			}
		}

		
		
		purchaseService.countSubPurchase(list4);
		purchaseService.basketAsPurchase(commandMap.getMap());
		mav.setViewName("basketasorder");
		return mav;
	}
	
/*	//주문 하러 가기 포스트
	@RequestMapping(value="/ordertwo.jy", method=RequestMethod.POST)
	public ModelAndView orderTwo(CommandMap commandMap) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		
		System.out.println("주문하러가기");
		mav.setViewName("orderend");	
		return mav;
	}
	
	
	//주문 완료
	@RequestMapping(value="/orderend.jy", method=RequestMethod.POST)
	public ModelAndView orderEnd(Map<String,Object> commandMap) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		System.out.println("주문완료");
		commandMap.put("order_yes", 1);
		orderService.insertOrder(commandMap);
		orderService.countSubOrder(commandMap);
		orderService.orderSeqCount(null);
		
		
		mav.setViewName("main");
		return mav;
	}
	

	
	//장바구니 넣기
	@RequestMapping(value="/ordertobasket.jy", method=RequestMethod.POST)
	public ModelAndView orderToBasket(Map<String,Object> commandMap) throws Exception{
		ModelAndView mav = new ModelAndView();
		orderService.insertBasket(commandMap);
		
		mav.setViewName("main");
		return mav;
	}
	
*/
}
