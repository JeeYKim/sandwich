package com.sandwich.admin.service;

import java.util.List;
import java.util.Map;

public interface AdminMemberService {
	
	//관리자 회원 목록 불러오기 
	List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception;
	
	//회원 아이디 검색
	List<Map<String, Object>> searchMemberId(Map<String, Object> map) throws Exception;
	
	//회원 이름 검색
	List<Map<String, Object>> searchMemberName(Map<String, Object> map) throws Exception;
	
	//회원 이메일 검색
	List<Map<String, Object>> searchMemberEMAIL(Map<String, Object> map) throws Exception;
	
	//회원 탈퇴
	void deleteMember(Map<String, Object> map) throws Exception;
		
	// 회원 상세정보
	Map<String, Object> selectMemberDetail(Map<String, Object> map) throws Exception;
	
	// 회원정보 수정
	void updateMember(Map<String, Object> map) throws Exception;


}
