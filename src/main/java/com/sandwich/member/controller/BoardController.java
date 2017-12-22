package com.sandwich.member.controller;

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
import com.sandwich.common.Paging;
import com.sandwich.member.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value = "/boardWriteForm")
	public String boardWriteForm() {
		return "boardWriteForm";
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList(Model model, CommandMap param) {
		
		List boardList = boardService.getBoardList(param.getMap());
		
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	
}
