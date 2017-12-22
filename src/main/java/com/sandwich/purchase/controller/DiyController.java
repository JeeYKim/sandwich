package com.sandwich.purchase.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sandwich.purchase.service.diyService;

@Controller
public class DiyController {
   
   @Resource
   private diyService diy;
   
   
   //DIY창 띠우기
   @RequestMapping(value = "/diy.jy")
   public String DIYForm(Model model) {
      
      List<Map<String,Object>> list = diy.selectAll();
      
      System.out.println(list.size());
      //모든 재료 정보 꺼내와서 전달
      model.addAttribute("AllIngre",list);
      
      return "diyForm";
   }
   
   
   
   
   
   //재료 추가
   @SuppressWarnings({ "null", "unchecked" })
   @RequestMapping(value = "/addIngre.jy")
   public String ToppingAdd(Model model, int no,HttpSession session) {
	   
	   System.out.println("받아온 no의값 : " + no);
      
      Map<String,Object> list = diy.selectOne(no);
      //선택된 이미지에 해당하는 재료정보 꺼내옴
      
      System.out.println("sandwich_no : " + list.get("SANDWICH_NO"));
      System.out.println("맵사이즈 : " + list.size());
      //세션에 재료목록이 없을시 (= 첫 재료 선택일 때)
      if(session.getAttribute("ingreList")==null || session.getAttribute("ingreList").equals("")){
      
         
         System.out.println("if문진입");
         List<Map<String,Object>> sessionList = new ArrayList<Map<String,Object>>();
         
         sessionList.add(list);
         
         session.setAttribute("ingreList", sessionList);
         
         
         model.addAttribute("ingreList",sessionList);
      
      }else{
         
         List<Map<String,Object>> sessionList =(List<Map<String, Object>>) session.getAttribute("ingreList");
         
         sessionList.add(list);
         
         session.setAttribute("ingreList", sessionList);
         
         model.addAttribute("ingreList", sessionList);

      }
      
      return "/purchase/diy2";
   }
   
   @RequestMapping(value = "/delIngre.jy")
   public String ToppingDelete(Model model,int no,HttpSession session) {
      
      
      List<Map<String,Object>> list = (List<Map<String, Object>>) session.getAttribute("ingreList");
      list.remove(no);
      session.setAttribute("ingreList", list);
      model.addAttribute("ingreList",list);
      
      return "/purchase/diy2";
   }
   
   
   @RequestMapping(value = "/addAmount.jy")
   @ResponseBody
   public String addAmount(Model model, HttpSession session) {
	   System.out.println("abcd메소드 진입");
	   /*List<Map<String, Object>> list = (List<Map<String, Object>>) session.getAttribute("ingreList");
	   Map<String, Object> sandwich = list.get(index);
	   
	   System.out.println("꺼내온 맵 크기 : "+ sandwich.size());
	   
	   session.setAttribute("sandwich", sandwich);
	   model.addAttribute("sandwich", sandwich);*/
      
      
      
      
      return "123";
   }
   
  /* @RequestMapping(value = "/aaa.jy")
   public String addAmount(Model model, int index, HttpSession session) {
	   System.out.println("amount컨트롤러 진입");
	   List<Map<String, Object>> list = (List<Map<String, Object>>) session.getAttribute("ingreList");
	   Map<String, Object> sandwich = list.get(index);
	   
	   System.out.println("꺼내온 맵 크기 : "+ sandwich.size());
	   
	   session.setAttribute("sandwich", sandwich);
	   model.addAttribute("sandwich", sandwich);
	   
	   return "/purchase/diy2";
   }
   
   */

}
























