package com.sandwich.admin.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;

@Repository("AdminMemberDAO")
public class AdminMemberDAO extends AbstractDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//관리자 회원 목록
	public List<Map<String, Object>> selectMemberList(Map<String, Object> map)throws Exception{
		return sqlSession.selectList("AdminMember.selectMemberList", map);
	}
	
	// 회원 아이디 검색
	public List<Map<String, Object>> searchMemberId(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("AdminMember.searchMemberId", map);
	}

	// 회원 이름 검색
	public List<Map<String, Object>> searchMemberName(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("AdminMember.searchMemberName", map);
	}

	// 회원 이메일 검색
	public List<Map<String, Object>> searchMemberEMAIL(Map<String, Object> map) throws Exception {
		return sqlSession.selectList("AdminMember.searchMemberEMAIL", map);
	}
		
	// 회원 삭제
	public void deleteMember(Map<String, Object> map) throws Exception {
		sqlSession.update("AdminMember.deleteMember", map);
	}
		
	// 회원 상세정보
	public Map<String, Object> selectMemberDetail(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne("AdminMember.selectMemberDetail", map);
	}
		
	// 회원정보 수정
	public void updateMember(Map<String, Object> map) {
		sqlSession.update("AdminMember.updateMember", map);
	}

}
