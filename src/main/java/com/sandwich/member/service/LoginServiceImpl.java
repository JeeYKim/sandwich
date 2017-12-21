package com.sandwich.member.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import com.sandwich.member.dao.LoginDao;


@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Resource(name = "loginDAO")
	private LoginDao loginDao;
	
	//로그인 정보 불러오기
	public Map<String, Object> selectId(Map<String, Object> map) throws Exception
	{
		return loginDao.selectId(map);
	}
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public String findId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.findId(map);
	}

	@Override
	public String findPw(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.findPw(map);
	}




}
