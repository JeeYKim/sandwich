package com.sandwich.staff.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

@Repository
public class NoticeDaoImpl extends AbstractDAO implements NoticeDao {

	public void insertNotice(CommandMap notice) {
		insert(NAME_SPACE + "insertNotice", notice.getMap());
	}

	public List getNoticeList(Map param) {
		List noticeList = selectList(NAME_SPACE + "getNoticeList", param);
		
		return noticeList;
	}
	
	public HashMap getNotice(int noticeNo) {
		HashMap notice = (HashMap) selectOne(NAME_SPACE + "getNotice", noticeNo);
		return notice;
	}
	
	public HashMap noticeModify(int noticeNo) {
		HashMap notice = (HashMap) update(NAME_SPACE + "noticeModify", noticeNo);
		return notice;
	}
	
	public void updateNotice(CommandMap notice){
		update(NAME_SPACE + "noticeModify", notice.getMap());
		
	}
	
	public void noticeDelete(int noticeNo){
		delete(NAME_SPACE + "noticeDelete", noticeNo);
	}

	@Override
	public List getMainNoticeList(Map param) {
		List mainNoticeList = selectList(NAME_SPACE + "getMainNoticeList", param);
		return mainNoticeList;
	}
}