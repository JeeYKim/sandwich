package com.sandwich.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sandwich.admin.dao.AdminMemberDAO;

@Service("AdminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService{
	
	@Resource(name="AdminMemberDAO")
	private AdminMemberDAO AdminMemberDAO;
	
	//회원 정보
	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception {
		return AdminMemberDAO.selectMemberList(map);
	}
	
	// 회원 아이디 검색
	@Override
	public List<Map<String, Object>> searchMemberId(Map<String, Object> map) throws Exception {
		return AdminMemberDAO.searchMemberId(map);
	}

	// 회원 이름 검색
	@Override
	public List<Map<String, Object>> searchMemberName(Map<String, Object> map) throws Exception {
		return AdminMemberDAO.searchMemberName(map);
	}

	// 회원 이메일 검색
	@Override
	public List<Map<String, Object>> searchMemberEMAIL(Map<String, Object> map) throws Exception {
		return AdminMemberDAO.searchMemberEMAIL(map);
	}
	
	//회원 삭제
	@Override
	public void deleteMember(Map<String, Object> map) throws Exception {
		AdminMemberDAO.deleteMember(map);
	}
		
	//회원 상세보기
	@Override
	public Map<String, Object> selectMemberDetail(Map<String, Object> map) throws Exception {
		return AdminMemberDAO.selectMemberDetail(map);
	}
		
	//회원 수정
	@Override
	public void updateMember(Map<String, Object> map) throws Exception {
		AdminMemberDAO.updateMember(map);
	}

}
