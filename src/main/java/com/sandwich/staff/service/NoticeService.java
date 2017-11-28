package com.sandwich.staff.service;

import java.util.HashMap;
import java.util.List;

import com.sandwich.common.CommandMap;
public interface NoticeService {
	void saveNotice(CommandMap notice);

	List getNoticeList();
	
	HashMap getNotice(int noticeNo);

}
