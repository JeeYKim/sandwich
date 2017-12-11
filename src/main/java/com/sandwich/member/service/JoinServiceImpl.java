package com.sandwich.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.sandwich.member.dao.JoinDao;
import com.sandwich.common.dao.AbstractDAO;

@Service("joinService")
public class JoinServiceImpl implements JoinService {
    Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Resource(name = "joinDAO")
	private JoinDao JoinDao;

	/*@Override
	public void insertMember(Map<String, Object> map, HttpServletRequest request) throws Exception {
		JoinDao.insertMember(map);
	} // 회원정보를 DB에 등록(회원가입)
*/
	

	@Override
	public Map checkId(Map<String, Object> map) throws Exception {
		return JoinDao.checkId(map);
	} // 회원가입 id중복체크

	@Override
	public void insertMember(Map<String, Object> map) throws Exception {
		JoinDao.insertMember(map);  
		// TODO Auto-generated method stub
		
	}

}