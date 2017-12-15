package com.sandwich.staff.controller;

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

import com.sandwich.staff.service.IngredientStaffService;
import com.sandwich.common.CommandMap;
import com.sandwich.common.Paging;


@Controller
public class IngredientStaffController {
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 10;
	
	private String pagingHtml;
	private Paging page;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final static String FILE_PATH = "C:\\Java\\Project\\sandwich\\src\\main\\webapp\\upload\\ingredient\\";
	
	@Resource(name = "ingredientStaffService")
	private IngredientStaffService ingredientStaffService;
	
	private int totalcount;
	
	@RequestMapping(value=" /ingredientStaffInsertForm")
	public String ingredientStaffForm(Model model)throws Exception{
		
		return "ingredientStaffForm";
	}
	
	@RequestMapping(value="/ingredientStaffInsert")
	public String ingredientStaffInsert(Model model, CommandMap commandmap, HttpServletRequest request) throws Exception{
		
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
		
		ingredientStaffService.ingredientStaffInsert(commandmap);
		
		return "redirect:/ingredientStaffList.jy";
	}
	
	@RequestMapping(value="/ingredientStaffList")
	public String ingredientStaffList(Model model, CommandMap commandmap, HttpServletRequest request) throws Exception{
		
		String isSearch = request.getParameter("isSerch");
		
		Map<String, Object> isSearchMap = new HashMap<String, Object>();
		
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) { //currentPage가 null일때.
			currentPage = 1;
		} else { //currentPage가 null이 아니고 존재할때.
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		List<Map<String,Object>> ingredientStaffList = ingredientStaffService.ingredientStaffList();
	
		totalCount = ingredientStaffList.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "ingredientStaffList.jy");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		ingredientStaffList = ingredientStaffList.subList(page.getStartCount(), lastCount);

		model.addAttribute("isSearch", isSearch);
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pagingHtml", pagingHtml);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("list",ingredientStaffList);
			
	
		totalcount=ingredientStaffList.size();
		
		model.addAttribute("ingredientStaffList", ingredientStaffList);
		model.addAttribute("totalcount", totalcount);
		
		return "ingredientStaffList";
	}
	
	@RequestMapping(value="/ingredientStaffView")
	public String IngredientStaffModifyForm(int SANDWICH_NO, Model model) {
		
		HashMap ingredient = ingredientStaffService.ingredientStaffModifyForm(SANDWICH_NO);
		
		model.addAttribute("ingredient", ingredient);
		System.out.println("왜 안나올까? : " + ingredient);
		return "viewStaffIngredient";
	}
	@RequestMapping(value="/ingredientStaffDelete")
	public String IngredientDelete(int SANDWICH_NO) {
		
		ingredientStaffService.ingredientStaffDelete(SANDWICH_NO);
		
		return "redirect:/ingredientStaffList.jy";
	}
	
}
