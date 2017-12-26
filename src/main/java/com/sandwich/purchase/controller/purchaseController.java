package com.sandwich.purchase.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.CommandMap;
import com.sandwich.common.Paging;
import com.sandwich.purchase.service.diyService;
import com.sandwich.purchase.service.purchaseService;


@Controller

public class purchaseController {
   Logger log = Logger.getLogger(this.getClass());
   
   private int currentPage = 1;
   private int totalCount;
   private int blockCount = 10;
   private int blockPage = 10;
   
   private String pagingHtml;
   private Paging page;
   
   
   @Resource 
   private purchaseService  purchaseService;
   
   @Resource
   private diyService diy;

  
   
   
   
 //결제하기  
   @RequestMapping(value="/gopurchase.jy", method=RequestMethod.POST)
   public String goPurchase(CommandMap commandMap, Model model, HttpServletRequest request, HttpSession session) throws Exception{
        
     String[] amountEach_temp = request.getParameterValues("amountEA");
     String[] sandwich_no_temp = request.getParameterValues("SANDWICH_NO");
     
     /*session.setAttribute("MEMBER_ID", "rock");*/
     String userId = (String) session.getAttribute("MEMBER_ID");
     

     //주문한 재료에 대한 모든 정보를 담은 리스트
     List<Map<String, Object>> AllIngredient = new ArrayList<Map<String, Object>>();			//1
     //주문한 재료의 남은수량 리스트
     ArrayList<Integer> leftAmount = new ArrayList<Integer>();									//2
     //재료 주문량
     ArrayList<String> amountEach1 = new ArrayList<String>(Arrays.asList(amountEach_temp));		//3
     //주문한 샌드위치 번호
     ArrayList<String> sandwich_no = new ArrayList<String>(Arrays.asList(sandwich_no_temp));	//4
     //purchase 테이블에 옮겨질 재료 정보
     ArrayList<Map<String, Object>> allPurchase = new ArrayList<Map<String, Object>>();
     //
     int orderedIngre = amountEach1.size();
     
     /*System.out.println("갯수");
     for(int i =0; i < amountEach1.size(); i++) {
         System.out.println(i+"번 인덱스의 값 : "+amountEach1.get(i));
     }
     
     System.out.println("샌드위치넘버");
     for(int i =0; i < sandwich_no.size(); i++) {
         System.out.println(i+"번 인덱스의 값 : "+sandwich_no.get(i));
     }*/
    
     
     //주문한 재료를 AllIngredient 리스트에 저장
     for(int i = 0; i<orderedIngre; i++) {
    	 AllIngredient.add(i, diy.selectIngre(Integer.parseInt(sandwich_no.get(i))));
    	 
     }
     for(int i = 0; i<orderedIngre; i++) {
     System.out.println("------------------------------------------------------");
     System.out.println(i+"번째 재료 번호1 :"+ AllIngredient.get(i).get("SANDWICH_NO") );
     System.out.println(i+"번째 재료 빅타입2 :"+ AllIngredient.get(i).get("SANDWICH_BIGTYPE") );
     System.out.println(i+"번째 재료 스몰타입3 :"+ AllIngredient.get(i).get("SANDWICH_SMALLTYPE") );
     System.out.println(i+"번째 재료 어마운트4 :"+ AllIngredient.get(i).get("SANDWICH_AMOUNT") );
     System.out.println(i+"번째 재료 프라이스5 :"+ AllIngredient.get(i).get("SANDWICH_PRICE") );
     System.out.println(i+"번째 재료 썸네일6 :"+ AllIngredient.get(i).get("SANDWICH_THUMNAIL") );
     System.out.println(i+"번째 재료 오더데이트7 :"+ AllIngredient.get(i).get("SANDWICH_ORDERDATE") );
     System.out.println(i+"번째 재료 엔드데이트8 :"+ AllIngredient.get(i).get("SANDWICH_ENDDATE") );
     System.out.println(i+"번째 재료 넘버9 :"+ AllIngredient.get(i).get("NO") );
     System.out.println("------------------------------------------------------");
     }
    
     
     // sandwich 테이블 재고 - 주문한 재료 숫자
     for (int i =0; i<orderedIngre; i++) {
    	 
     
     leftAmount.add(i, (Integer.parseInt(String.valueOf(AllIngredient.get(i).get("SANDWICH_AMOUNT") ))) - Integer.parseInt(amountEach1.get(i)));
     
     System.out.println(i+"번째 재료 남은 수량 : " + leftAmount.get(i));
     
     }
     
     
     //남은 재고 sandwich 테이블에 업데이트
     for (int i =0; i<orderedIngre; i++) {
    	 diy.updateAmount(sandwich_no.get(i), leftAmount.get(i));
     }
     
     System.out.println("재고 업데이트 완료");
     
     
     //구매내용 purchase테이블에 저장
     
    /* for(int i=0; i<orderedIngre; i++) {
     System.out.println(allPurchase.get(i).put("PURCHASE_ID", ""));
     
     }*/
     HashMap aa = new HashMap();
     aa.put("PURCHASE_ID", "aa");
	 diy.plusPurchasNo(aa);
	 System.out.println("시퀀스 플러스 1");
	 
     for(int i=0; i<orderedIngre; i++) {
    
     allPurchase.add(i, new HashMap());
     allPurchase.get(i).put("PURCHASE_ID", userId);
     allPurchase.get(i).put("PURCHASE_BIGTYPE", AllIngredient.get(i).get("SANDWICH_BIGTYPE"));
     allPurchase.get(i).put("PURCHASE_SMALLTYPE", AllIngredient.get(i).get("SANDWICH_SMALLTYPE"));
     allPurchase.get(i).put("PURCHASE_AMOUNT", amountEach1.get(i));
     allPurchase.get(i).put("PURCHASE_PRICE", Integer.parseInt(amountEach1.get(i)) * Integer.parseInt(String.valueOf(AllIngredient.get(i).get("SANDWICH_PRICE"))));
     allPurchase.get(i).put("PURCHASE_BASKET", 1);
     }
     
     
     
     for(int i=0; i<orderedIngre; i++) {
    	 diy.goPurchase(allPurchase.get(i));	//db저장
     }
     
     
     
     purchaseService.sandwichPurchase(aa);
     
     /*redirectAttributes.addAttribute("testParameter", testParameter);*/
     return "redirect:/mypurchas.jy";
  }
   
  
   
 //장바구니 리스트 보기
   @RequestMapping(value="/basketlist.jy") 
   public ModelAndView basketList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
      
	   	 String[] amountEach_temp = request.getParameterValues("amountEA");
	     String[] sandwich_no_temp = request.getParameterValues("SANDWICH_NO");
	     
	     /*session.setAttribute("MEMBER_ID", "rock");*/
	     String userId = (String) session.getAttribute("MEMBER_ID");
	     

	     //주문한 재료에 대한 모든 정보를 담은 리스트
	     List<Map<String, Object>> AllIngredient = new ArrayList<Map<String, Object>>();			//1
	     //주문한 재료의 남은수량 리스트
	     ArrayList<Integer> leftAmount = new ArrayList<Integer>();									//2
	     //재료 주문량
	     ArrayList<String> amountEach1 = new ArrayList<String>(Arrays.asList(amountEach_temp));		//3
	     //주문한 샌드위치 번호
	     ArrayList<String> sandwich_no = new ArrayList<String>(Arrays.asList(sandwich_no_temp));	//4
	     //purchase 테이블에 옮겨질 재료 정보
	     ArrayList<Map<String, Object>> allPurchase = new ArrayList<Map<String, Object>>();
	     //
	     int orderedIngre = amountEach1.size();
	     
	 
	     
	     //주문한 재료를 AllIngredient 리스트에 저장
	     for(int i = 0; i<orderedIngre; i++) {
	    	 AllIngredient.add(i, diy.selectIngre(Integer.parseInt(sandwich_no.get(i))));
	    	 
	     }
	     /*for(int i = 0; i<orderedIngre; i++) {
	     System.out.println("------------------------------------------------------");
	     System.out.println(i+"번째 재료 번호1 :"+ AllIngredient.get(i).get("SANDWICH_NO") );
	     System.out.println(i+"번째 재료 빅타입2 :"+ AllIngredient.get(i).get("SANDWICH_BIGTYPE") );
	     System.out.println(i+"번째 재료 스몰타입3 :"+ AllIngredient.get(i).get("SANDWICH_SMALLTYPE") );
	     System.out.println(i+"번째 재료 어마운트4 :"+ AllIngredient.get(i).get("SANDWICH_AMOUNT") );
	     System.out.println(i+"번째 재료 프라이스5 :"+ AllIngredient.get(i).get("SANDWICH_PRICE") );
	     System.out.println(i+"번째 재료 썸네일6 :"+ AllIngredient.get(i).get("SANDWICH_THUMNAIL") );
	     System.out.println(i+"번째 재료 오더데이트7 :"+ AllIngredient.get(i).get("SANDWICH_ORDERDATE") );
	     System.out.println(i+"번째 재료 엔드데이트8 :"+ AllIngredient.get(i).get("SANDWICH_ENDDATE") );
	     System.out.println(i+"번째 재료 넘버9 :"+ AllIngredient.get(i).get("NO") );
	     System.out.println("------------------------------------------------------");
	     }*/
	    
	     
	    
	     
	    /* for(int i=0; i<orderedIngre; i++) {
	     System.out.println(allPurchase.get(i).put("PURCHASE_ID", ""));
	     
	     }*/
	     HashMap aa = new HashMap();
	     aa.put("PURCHASE_ID", "aa");
		 diy.plusPurchasNo(aa);
		 System.out.println("시퀀스 플러스 1");
		 
	     for(int i=0; i<orderedIngre; i++) {
	    
	     allPurchase.add(i, new HashMap());
	     allPurchase.get(i).put("PURCHASE_ID", userId);
	     allPurchase.get(i).put("PURCHASE_BIGTYPE", AllIngredient.get(i).get("SANDWICH_BIGTYPE"));
	     allPurchase.get(i).put("PURCHASE_SMALLTYPE", AllIngredient.get(i).get("SANDWICH_SMALLTYPE"));
	     allPurchase.get(i).put("PURCHASE_AMOUNT", amountEach1.get(i));
	     allPurchase.get(i).put("PURCHASE_PRICE", Integer.parseInt(amountEach1.get(i)) * Integer.parseInt(String.valueOf(AllIngredient.get(i).get("SANDWICH_PRICE"))));
	     allPurchase.get(i).put("PURCHASE_BASKET", 0);
	     }
	     
	     
	     
	     for(int i=0; i<orderedIngre; i++) {
	    	 diy.goPurchase(allPurchase.get(i));	//db저장
	     }
	     
	     
	     
	     
	     
	     
	     
	     
	     //-------------------------------------------
	   
	   ModelAndView mav = new ModelAndView();
      
      
      
      commandMap.put("PURCHASE_ID", userId);
      
      
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
   
   
   
   
   

   //내가 주문 한 내역 보기
   @RequestMapping(value="/mypurchas.jy")
   public ModelAndView myOrder(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
      ModelAndView mav = new ModelAndView();
      
      
      commandMap.put("PURCHASE_ID", session.getAttribute("MEMBER_ID"));
      
      
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
     
      
      List<Map<String,Object>> list = purchaseService.myselectPurchaseOne(commandMap.getMap());
      System.out.println("리스트 : " + list.size());
      mav.addObject("list",list);
      
      mav.setViewName("mypurchaseDetail");
      
      return mav;
   }
   
   
   
   
   
   
   
   //장바구니 결제하기
   @RequestMapping(value="/basketasorder.jy")
   public ModelAndView basketAsOrder(CommandMap commandMap, HttpSession session) throws Exception{
      ModelAndView mav = new ModelAndView();
      System.out.println("장바구니에서 결제");
      commandMap.put("order_yes", 1);
      String key;
      int amount = 0;
      int amount2 = 0;
      int num2 = 0;
      int num1 = 0;
      int num3 = 0;

      
      commandMap.put("PURCHASE_ID", session.getAttribute("MEMBER_ID"));
      System.out.println(" commandMap아이디 " + commandMap.get("PURCHASE_ID"));
      System.out.println("장바구니 상세 : " + commandMap.get("PURCHASE_NO"));
      List<Map<String,Object>> list = purchaseService.basketListOne(commandMap.getMap());
      Map<String, Object> list2 = null;
      Map<String, Object> list3 = null;
      List<Map<String,Object>> list4 = new ArrayList<Map<String,Object>>();
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
   
   
   
   
   
  
   
   


   
   
   // 재고 수량 체크 with ajax
   @RequestMapping(value = "/check.jy")
   public  @ResponseBody int check(int s_amount,int sandwich_no, Model model, HttpSession session) {
      
      int amount = 0;
      int acfal = 0;
      
      System.out.println("--------------");
      System.out.println(s_amount);
      System.out.println(sandwich_no);
      

      // 샌드위치 넘버 가지고 하나 맵 정보 가져온걸 리스트로 받아냄
      
      
      Map<String, Object> select = diy.selectIngre(sandwich_no);
      Map<String, Object> list2 = diy.countfind3(String.valueOf(select.get("SANDWICH_SMALLTYPE")));
      amount = Integer.parseInt(String.valueOf(list2.get("SANDWICH_AMOUNT")));
      amount = amount - s_amount;
      
      if (amount <= 0) {
         try {

            Map<String, Object> list3 = diy.countfind4(String.valueOf(select.get("SANDWICH_SMALLTYPE")));
            amount = 0;
            amount = Integer.parseInt(String.valueOf(list3.get("SANDWICH_AMOUNT")));
            amount = amount - s_amount;

            if (amount <= 0) {
               System.out.println("제고좀 채워 넣어라");
               acfal = 3;
               model.addAttribute(acfal);
               System.out.println("에이시팔 3번"+acfal);
               
               return acfal;
            } else {
            	acfal = 2;
            	model.addAttribute(acfal);
               System.out.println("에이시팔 2번"+acfal);
               return acfal;

            }
         } catch (Exception e) {
            System.out.println("1번 망했다");
            acfal = 3;
            model.addAttribute(acfal);
            
            return acfal;
         }
      } else {
    	  acfal = 1;
    	  model.addAttribute(acfal);
         System.out.println("에이시팔 1번"+acfal);
         return acfal;
      }
   }

}