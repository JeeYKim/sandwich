package com.sandwich.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sandwich.common.CommandMap;
import com.sandwich.model.MemberModel;

public interface LoginService {
	
	//로그인 정보 불러오기
	Map<String, Object> selectId(Map<String, Object> map) throws Exception;
	
	MemberModel idFind(MemberModel memberModel);
	
	MemberModel pwFind(MemberModel memberModel);

}
