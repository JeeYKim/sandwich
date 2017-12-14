package com.sandwich.admin.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sandwich.admin.service.IngredientService;
import com.sandwich.common.CommandMap;


@Controller
public class IngredientController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final static String FILE_PATH = "C:\\Java\\Project\\sandwich\\src\\main\\webapp\\upload\\ingredient\\";
	
	@Resource(name = "ingredientService")
	private IngredientService ingredientService;
	
	private int totalcount;
	
	@RequestMapping(value=" /ingredientInsertForm")
	public String ingredientForm(Model model)throws Exception{
		
		return "ingredientForm";
	}
	
	@RequestMapping(value="/ingredientInsert")
	public String ingredientInsert(Model model, CommandMap commandmap, HttpServletRequest request) throws Exception{
		
		int member_id=1;
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		if( multipartHttpServletRequest.getFile("SANDWICH_THUMBNAIL").getSize() > 0 ) {
			MultipartFile file = multipartHttpServletRequest.getFile("SANDWICH_THUMBNAIL");
			String fileName = member_id+"_"+"ingredient"+"_"+file.getOriginalFilename();
			
			File uploadFile = new File(FILE_PATH + fileName);

			try {
				file.transferTo(uploadFile);
			} catch (Exception e) {

			}
			commandmap.put("SANDWICH_THUMBNAIL", fileName);
		}
		
		ingredientService.ingredientInsert(commandmap);
		
		return "redirect:/ingredientList.jy";
	}
	
	@RequestMapping(value="/ingredientList")
	public String IngredientList(Model model, CommandMap commandmap, HttpServletRequest request) throws Exception{
		
		@SuppressWarnings("rawtypes")
		List ingredientList = ingredientService.ingredientList();
		System.out.println("리스트가 들어오나? : " + ingredientList);
	
		totalcount=ingredientList.size();
		
		model.addAttribute("ingredientList", ingredientList);
		model.addAttribute("totalcount", totalcount);
		
		return "ingredientList";
	}
	
	@RequestMapping(value="/ingredientView")
	public String IngredientModifyForm(int SANDWICH_NO, Model model) {
		
		HashMap ingredient = ingredientService.ingredientModifyForm(SANDWICH_NO);
		
		model.addAttribute("ingredient", ingredient);
		System.out.println("왜 안나올까? : " + ingredient);
		return "viewIngredient";
	}
	@RequestMapping(value="/ingredientDelete")
	public String IngredientDelete(int SANDWICH_NO) {
		
		ingredientService.ingredientDelete(SANDWICH_NO);
		
		return "redirect:/ingredientList.jy";
	}
	
}
