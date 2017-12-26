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
import com.sandwich.common.Paging;

 
@Controller
public class IngredientController {
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 10;
	
	private String pagingHtml;
	private Paging page;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final static String FILE_PATH = "C:\\Java\\Project\\sandwich\\src\\main\\webapp\\resources\\sandwich\\";
	
	@Resource(name = "ingredientService")
	private IngredientService ingredientService;
	
	private int totalcount;
	
	@RequestMapping(value=" /ingredientInsertForm")
	public String ingredientForm(Model model)throws Exception{
		
		return "ingredientForm";
	}
	
	@RequestMapping(value="/ingredientInsert")
	public String ingredientInsert(Model model, CommandMap commandmap, HttpServletRequest request) throws Exception{
		
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

		if( multipartHttpServletRequest.getFile("SANDWICH_THUMBNAIL").getSize() > 0 ) {
			MultipartFile file = multipartHttpServletRequest.getFile("SANDWICH_THUMBNAIL");

			String fileName = request.getSession().getAttribute("MEMBER_ID")+"_"+"ingredient"+"_"+file.getOriginalFilename();
			
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
		
		String isSearch = request.getParameter("isSearch");
		
		Map<String, Object> isSearchMap = new HashMap<String, Object>();
		
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null일때.
			currentPage = 1;
		} else { //currentPage가 null이 아니고 존재할때.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		List<Map<String,Object>> ingredientList = ingredientService.ingredientList();
	
		totalCount = ingredientList.size();
		
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "ingredientList.jy");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		ingredientList = ingredientList.subList(page.getStartCount(), lastCount);

		model.addAttribute("isSearch", isSearch);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
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
	//폐기물
	   @RequestMapping(value="/garbage")
	   public String garbage(Model model,CommandMap commandmap, HttpServletRequest request) {
	      
	      
	      
	      if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
	            || request.getParameter("currentPage").equals("0")) { //currentPage가 null일때.
	         currentPage = 1;
	      } else { //currentPage가 null이 아니고 존재할때.
	         currentPage = Integer.parseInt(request.getParameter("currentPage")); 
	      }
	      
	      
	      List<Map<String,Object>> garbageList = ingredientService.garbageList();
	      
	      
	      System.out.println(garbageList.size());
	   
	      totalCount = garbageList.size();
	      page = new Paging(currentPage, totalCount, blockCount, blockPage, "garbage.jy");
	      pagingHtml = page.getPagingHtml().toString();

	      int lastCount = totalCount;

	      if (page.getEndCount() < totalCount)
	         lastCount = page.getEndCount() + 1;

	      garbageList = garbageList.subList(page.getStartCount(), lastCount);


	      
	      model.addAttribute("totalCount", totalCount);
	      model.addAttribute("pagingHtml", pagingHtml);
	      model.addAttribute("currentPage", currentPage);
	      model.addAttribute("list",garbageList);
	         
	   
	      totalcount=garbageList.size();
	      
	      model.addAttribute("garbageList", garbageList);
	      model.addAttribute("totalcount", totalcount);
	      
	      return "garbage";
	   }   
}
