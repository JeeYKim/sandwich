package com.sandwich.staff.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sandwich.common.CommandMap;
import com.sandwich.common.dao.AbstractDAO;

@Repository
public class NoticeDaoImpl extends AbstractDAO implements NoticeDao {

	public void insertNotice(CommandMap notice) {
		insert(NAME_SPACE + "insertNotice", notice.getMap());
	}

	public List getNoticeList() {
		List noticeList = selectList(NAME_SPACE + "getNoticeList");
		
		return noticeList;
	}
	
	@Override
	public HashMap getNotice(int noticeNo) {
		HashMap notice = (HashMap) selectOne(NAME_SPACE + "getNotice", noticeNo);
		return notice;
	}

}
