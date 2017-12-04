package com.sandwich.staff.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.sandwich.staff.service.NoticeService;

@Controller
public class NoticeController {
	private final static String FILE_PATH = "/Users/yhshin/Documents/sandwich/src/main/webapp/upload/notice/";
											
	@Autowired
	private NoticeService noticeService; 
	
	@RequestMapping(value = "/noticeWriteForm")
	public String noticeWriteForm() {
		return "noticeWriteForm";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/noticeSave")
	public String noticeSave(Model model, CommandMap notice, HttpServletRequest request) {
		// session 정보에서 갖고 올것 
		int memberId = 1;
		
		// 첨부파일 처리 
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartHttpServletRequest.getFile("noticeFile");
		if( file !=null && file.getSize() > 0 ) {
			String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String fileName = memberId + "-" + System.currentTimeMillis() + ext;
			
			File uploadFile = new File(FILE_PATH + fileName);

			try {
				file.transferTo(uploadFile);
			} catch (Exception e) {

			}
			notice.put("noticeFile", fileName);
		}
		
		notice.put("memberId", memberId);
		
		// service call
		noticeService.saveNotice(notice);
		
		return "redirect:noticeList.jy";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/noticeList")
	public String noticeList(CommandMap param, Model model) {
		
		List noticeList = noticeService.getNoticeList(param.getMap());
		model.addAttribute("noticeList", noticeList);
		return "noticeList";
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/noticeView")
	public String noticeView(int noticeNo, Model model)  {
		
		HashMap notice = noticeService.getNotice(noticeNo);
		model.addAttribute("notice", notice);
		
		return "noticeView";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/noticeModifyForm")
	public String noticeModifyForm(int noticeNo, Model model)  {
		HashMap notice = noticeService.getNotice(noticeNo);
		model.addAttribute("notice", notice); 
		
		return "noticeModifyForm";
	}
	
	@RequestMapping(value = "/noticeDelete")
	public String noticeDelete(int noticeNo){
		
		noticeService.noticeDelete(noticeNo);
		
		return "redirect:noticeList.jy";	
		
	}
	
}