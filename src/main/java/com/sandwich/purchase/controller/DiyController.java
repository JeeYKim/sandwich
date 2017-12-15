package com.sandwich.purchase.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandwich.purchase.service.diyService;

@Controller
public class DiyController {
   
   @Resource
   private diyService diy;
   
   
   //DIY창 띠우기
   @RequestMapping(value = "/diy.jy")
   public String DIYForm(Model model) {
      
      List<Map<String,Object>> list = diy.selectAll();
      //모든 재료 정보 꺼내와서 전달
      model.addAttribute("AllIngre",list);
      
      return "diyForm";
   }
   
   
   
   
   
   //재료 추가
   @SuppressWarnings({ "null", "unchecked" })
   @RequestMapping(value = "/addIngre.jy")
   public String ToppingAdd(Model model, int no,HttpSession session) {
      
      Map<String,Object> list = diy.selectOne(no);
      //선택된 이미지에 해당하는 재료정보 꺼내옴
      
      
      //세션에 재료목록이 없을시 (= 첫 재료 선택일 때)
      if(session.getAttribute("ingreList")==null || session.getAttribute("ingreList").equals("")){
      
         
         
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
      
      return "diy2";
   }
   
   @RequestMapping(value = "/delIngre.jy")
   public String ToppingDelete(Model model,int no,HttpSession session) {
      
      
      List<Map<String,Object>> list = (List<Map<String, Object>>) session.getAttribute("ingreList");
      list.remove(no);
      session.setAttribute("ingreList", list);
      model.addAttribute("ingreList",list);
      
      return "diy2";
   }
   
   

}