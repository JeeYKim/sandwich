package com.sandwich.staff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.common.CommandMap;
import com.sandwich.staff.dao.NoticeDao;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	public void saveNotice(CommandMap notice) {
		if(notice.get("noticeNo") == null) {
			noticeDao.insertNotice(notice);
		} else {
			
			if(notice.get("noticeFile") == null) {
				notice.put("noticeFile", notice.get("orgNoticeFile"));
			}
			noticeDao.updateNotice(notice);
		}
	}

	public List getNoticeList(Map param) {
		List noticeList = noticeDao.getNoticeList(param);
		return noticeList;
	}
	
	public HashMap getNotice(int noticeNo) {
		HashMap notice = noticeDao.getNotice(noticeNo);
		
		return notice;
	}
	
	public void noticeDelete(int noticeNo){
		noticeDao.noticeDelete(noticeNo);
	}

	
}
