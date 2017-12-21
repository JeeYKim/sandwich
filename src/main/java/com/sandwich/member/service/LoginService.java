package com.sandwich.member.service;

import java.util.Map;

public interface LoginService {
	
	//로그인 정보 불러오기
	Map<String, Object> selectId(Map<String, Object> map) throws Exception;
	
	String findId(Map<String, Object> map) throws Exception;

	String findPw(Map<String, Object> map) throws Exception;

}
