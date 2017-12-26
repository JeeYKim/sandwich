package com.sandwich.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;

@Repository("mainDAO")
public class mainDAO  extends AbstractDAO{
	
	String NAME_SPACE = "sandwich.notice.";
	
	@SuppressWarnings("rawtypes")
	public List boardList(){
		
		List boardList = selectList("diyboard.diyBoard");
		
		return boardList;
	}
	
	@SuppressWarnings("rawtypes")
	public List notice() {
		
		List noticeList = selectList(NAME_SPACE + "noticeList");
		
		return noticeList;
	}
}
