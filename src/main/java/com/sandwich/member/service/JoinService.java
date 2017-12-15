package com.sandwich.member.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//import com.sandwich.common.common.CommandMap;

public interface JoinService {

	/*
	 * // 회원정보를 DB에 등록(회원가입) void insertMember(Map<String, Object> map,
	 * HttpServletRequest request) throws Exception;
	 */

	// 회원가입 id중복체크
	int checkId(Map<String, Object> map) throws Exception;

	// 회원정보를 DB에 등록(회원가입)
	void insertMember(Map<String, Object> map) throws Exception;
	// TODO Auto-generated method stub

}
