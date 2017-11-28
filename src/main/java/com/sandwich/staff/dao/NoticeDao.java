package com.sandwich.staff.dao;

import java.util.HashMap;
import java.util.List;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

public interface NoticeDao {
	String NAME_SPACE = "sandwich.notice.";
	void insertNotice(CommandMap notice);
	List getNoticeList();
	
	
	HashMap getNotice(int noticeNo);

}
