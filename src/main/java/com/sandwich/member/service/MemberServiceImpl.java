package com.sandwich.member.service;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sandwich.member.dao.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Resource(name = "memberDAO")
	private MemberDao memberDao;
	
	// 나의 회원정보 조회
		@Override
		public Map<String, Object> myinfoDetail(Map<String, Object> map) throws Exception
		{
		   return memberDao.myinfoDetail(map);
		}
		
		// 나의 회원정보 수정
		@Override
		public void updateMyinfo(Map<String, Object> map) throws Exception
		{
	       memberDao.updateMyinfo(map);
		}
			
		//회원탈퇴
		@Override
		public void deleteMember(Map<String, Object> map) throws Exception
		{
		   memberDao.deleteMember(map);
		}

}
