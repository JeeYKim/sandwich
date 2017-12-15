package com.sandwich.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;

@Repository("joinDAO")
public class JoinDao extends AbstractDAO {
	
	
	
	   //회원가입
		public void insertMember(Map<String, Object> map) throws Exception{
			insert("join.insertMember", map)
			;
		}
		
		
		
		//아이디 중복 확인
		public int checkId(Map<String, Object> map) throws Exception{
			return (int) selectOne("join.checkId", map);
		}
		

}