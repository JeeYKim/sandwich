package com.sandwich.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandwich.common.dao.AbstractDAO;

@Repository("memberDAO")
public class MemberDao extends AbstractDAO {
	
	@SuppressWarnings("unused")
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//-----회원정보-----
	//회원정보 조회
	@SuppressWarnings("unchecked")
	public Map<String, Object> myinfoDetail(Map<String, Object>map) throws Exception
	{
		return (Map<String, Object>) selectOne("mypage.myinfoDetail", map);
	
	}
	
	//회원정보 수정
	public void updateMyinfo(Map<String, Object>map)
	{
		update("mypage.updateMyinfo", map);
	}
	
	
	public void deleteMember(Map<String, Object> map) throws Exception
	{
		update("mypage.deleteMember", map);
	}
	
	//나의 주문내역 리스트 보기
	
	//-----장바구니--------
	
	//나의 장바구니 내역보기(페이징)
	
	
	//-----내가쓴 추천------
	
	
	

}
