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
import com.sandwich.purchase.service.purchaseService;


@Controller

public class purchaseController {
   Logger log = Logger.getLogger(this.getClass());
   
   
   @Resource 
   private purchaseService  purchaseService;

   
   

   
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
      int amount = 0;
      int amount2 = 0;
      int num2 = 0;
      int num1 = 0;
      int num3 = 0;

      
      commandMap.put("PURCHASE_ID", session.getAttribute("PURCHASE_ID"));
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
               if (amount <= 0) {
                  
                  try {
                     list3 = purchaseService.countfind2((String) list.get(i).get("PURCHASE_SMALLTYPE"));
                     amount2 = (Integer) list3.get("SANDWICH_AMOUNT");

                     if (amount2 <= 0) {
                        System.out.println("3번째 걸림");
                        mav.setViewName("샌드위치 재고 없음");
                        return mav;
                     } else {
                        num1 = Integer.parseInt(String.valueOf(list3.get("SANDWICH_AMOUNT")));
                        num2 = Integer.parseInt(String.valueOf(list.get(i).get("PURCHASE_AMOUNT")));
                        System.out.println(num1 + "넘 투우");
                        num3 = num1 - num2;                  
                        list3.remove("SANDWICH_AMOUNT");
                        list3.put("SANDWICH_AMOUNT", String.valueOf(num3));
                        num3 = 0;                     
                        purchaseService.countSubPurchase(list3); 
                     }
                  } catch (Exception e) {

                     System.out.println("2번째 걸림" + e);
                     mav.setViewName("sandwichnono");
                     return mav;
                  }
               } else {               
                  try{                  
                     num1 = Integer.parseInt(String.valueOf(list2.get("SANDWICH_AMOUNT")));
                     num2 = Integer.parseInt(String.valueOf(list.get(i).get("PURCHASE_AMOUNT")));
                     num3 = num1 - num2;               
                     list2.remove("SANDWICH_AMOUNT");
                     list2.put("SANDWICH_AMOUNT", String.valueOf(num3));
                     num3 = 0;      
                     purchaseService.countSubPurchase(list2); 
                     
                  }catch(Exception e){
                     System.out.println("4번째 걸림");
                     mav.setViewName("sandwichnono");
                     return mav;
                  }
               }      
         } catch (Exception e) {
            System.out.println("1번째 걸림" + e);
            mav.setViewName("sandwichnono");
            return mav;
         }
      }      
      System.out.println("요기까지 되었당11");
      purchaseService.sandwichPurchase(commandMap.getMap());
      purchaseService.basketAsPurchase(commandMap.getMap());
      mav.setViewName("basketAsPurchase");
      return mav;
   }
   
   //주문 하러 가기 포스트
   @RequestMapping(value="/gopurchase.jy", method=RequestMethod.POST)
   public ModelAndView orderTwo(CommandMap commandMap, HttpServletRequest request) throws Exception{
      ModelAndView mav = new ModelAndView();
      
     
      
     String[] amountEach1 = request.getParameterValues("amountEA");
     
     System.out.println("길이 : "+amountEach1.length);
     System.out.println("투스트링 : "+amountEach1.toString());
     for(int i =0; i<amountEach1.length;i++) {
     System.out.println("i번인덱스의 값 : "+amountEach1[i]);
     }
     
     List<Map<String,Object>> check = purchaseService.endDateOver(commandMap.getMap());
     
     if(check.size() > 0){ 
        purchaseService.sandDataOverAsGarbage(check);
        purchaseService.sandDataOver(check);  
        System.out.println("성공적");
     }
     
     
      System.out.println();
      
      System.out.println("주문하러가기");
      mav.setViewName("orderend");   
      
   
      
      
      return mav;
   }
   
   
/*   //주문 완료
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