package com.sandwich.member.service;

import java.util.Map;

public interface JoinService {	
	

	 // 회원정보를 DB에 등록(회원가입)
	 void insertMember(Map<String, Object> map) throws Exception;
	
	// 이메일 인증- 이메일 중복확인
	 int checkEmail(Map<String, Object> map) throws Exception;

	//회원가입 id중복체크
	 int checkId(Map<String, Object> map) throws Exception;

}
