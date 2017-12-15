package com.sandwich.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.sandwich.member.dao.JoinDao;
import com.sandwich.common.dao.AbstractDAO;

@Service("joinService")
public class JoinServiceImpl implements JoinService {
    Logger log = Logger.getLogger(this.getClass());
    
	@Resource(name = "joinDAO")
	private JoinDao JoinDao;

	

	
	@Override
	public int checkId(Map<String, Object> map) throws Exception {
		return JoinDao.checkId(map);
	}   //회원가입 id중복체크

	//회원가입 DB등록
	public void insertMember(Map<String, Object> map) throws Exception {
		JoinDao.insertMember(map);  
		// TODO Auto-generated method stub
		
	}

}