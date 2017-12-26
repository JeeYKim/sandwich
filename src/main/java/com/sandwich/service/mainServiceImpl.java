package com.sandwich.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sandwich.dao.mainDAO;

@Service("mainService")
public class mainServiceImpl implements mainService{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="mainDAO")
	private mainDAO mainDAO;  
	
	@SuppressWarnings("rawtypes")
	public List getBoardList() {
		
		List list = mainDAO.boardList();
		
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List getNotice() {
		
		List noticeList = mainDAO.notice();
		
		return noticeList;
	}

}
