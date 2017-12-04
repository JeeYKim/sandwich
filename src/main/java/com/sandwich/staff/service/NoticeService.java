package com.sandwich.staff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandwich.common.CommandMap;
public interface NoticeService {
	
	void saveNotice(CommandMap notice);

	List getNoticeList(Map param);
	
	HashMap getNotice(int noticeNo);

	void noticeDelete(int noticeNo);

}
