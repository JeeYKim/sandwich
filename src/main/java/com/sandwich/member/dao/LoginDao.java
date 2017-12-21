package com.sandwich.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;


@Repository("loginDAO")
public class LoginDao extends AbstractDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//로그인 정보 불러오기
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectId(Map<String, Object> map) throws Exception
	{
		return (Map<String, Object>)selectOne("login.loginSuccess", map);
	}

	//아아디칮가
	public String findId(Map<String, Object> map) throws Exception{
		return (String) selectOne("login.findId", map);
	}
		
	//비번찾기
	public String findPw(Map<String, Object> map) throws Exception{
		return (String) selectOne("login.findPw", map);
	}
	
}
