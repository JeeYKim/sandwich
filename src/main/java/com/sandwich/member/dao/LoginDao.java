package com.sandwich.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;
import com.sandwich.model.MemberModel;

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
	
	public MemberModel idFind(MemberModel memberModel) {
		return (MemberModel) selectOne("login.idFind", memberModel);
	}
	
	public MemberModel pwFind(MemberModel memberModel) {
		return (MemberModel) selectOne("login.pwFind", memberModel);
	}

}
