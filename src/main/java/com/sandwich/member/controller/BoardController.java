package com.sandwich.member.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sandwich.common.CommandMap;

@Controller
public class BoardController {
	
	

	
	@RequestMapping(value = "/boardWriteForm")
	public String boardWriteForm() {
		return "boardWriteForm";
	}
	
	
}
