package com.sandwich.member.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.CommandMap;
import com.sandwich.member.service.LoginService;


@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	//로그인 폼
	@RequestMapping(value = "/loginForm.jy")
	public String login(Model model)
	{
		return "loginForm";
	}
	
	//로그인 성공 여부 체크(로그인 처리)
	@SuppressWarnings("unused")
	@RequestMapping(value = "/loginSuccess.jy")
	public String loginSuccess(Model model, CommandMap commandMap, HttpSession session, HttpServletRequest request)
	throws Exception {
		System.out.println("받은아이디" + request.getParameter("MEMBER_ID"));/*commandMap.get("MEMBER_ID"));*/
		System.out.println("받은 비밀번호" + request.getParameter("MEMBER_PW"));
		//해당 아이디로 검색하여 회원 정보 가져오기
		
		/*commandMap.put("MEMBER_ID", request.getParameter("MEMBER_ID"));
		commandMap.put("MEMBER_PW", request.getParameter("MEMBER_PW"));*/
		
		Map<String, Object> loginChk = loginService.selectId(commandMap.getMap());
		

		//가입 되어 있지 않으면
		if(loginChk == null)
		{
			//입력한 아이디가 없다는 메시지 출력
			model.addAttribute("message", "해당 아이디가 없습니다.");
			return "loginForm";
		}
		//해당 회원정보가 있으면
		else
		{
			System.out.println("비밀번호1 : " + loginChk.get("MEMBER_PW")
			+ "\n 비밀번호2 : " + commandMap.get("MEMBER_PW"));
			
			//비밀번호가 일치하면
			if(loginChk.get("MEMBER_PW").toString().equals(commandMap.get("MEMBER_PW").toString()))
			{
				//loginChk.Map을 "MEMBER" 영역에 저장
				model.addAttribute("MEMBER", loginChk);
				//세션 영역 저장(아이디,이름,레벨)
				session.setAttribute("MEMBER_ID", commandMap.get("MEMBER_ID"));
				session.setAttribute("MEMBER_NAME", loginChk.get("MEMBER_NAME"));
				session.setAttribute("MEMBER_LEVEL", loginChk.get("MEMBER_LEVEL"));
				
				System.out.println("세션에 넣은 아이디 : " + session.getAttribute("MEMBER_ID"));
				/*session.setAttribute("MEMBER_LEVEL", loginChk.get("MEMBER_LEVEL"));*/
				
				return "redirect:/main.jy";
			}
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "loginForm";
		}
	}
	
	//로그아웃
	@RequestMapping(value = "/logout.jy")
	public String logout(Model model, HttpServletRequest request, HttpSession session, CommandMap commandMap)
	{
		//getSession(false) : 현재 세션이 존재하면 기존 세션 리턴, 없으면 null값 리턴
		session = request.getSession(false);
		
		//현재 세션이 존재하면
		if(session != null)
		{
			//세션 소멸
			session.invalidate();
		}
		
		return "redirect:/main.jy";
	}
	
	@RequestMapping(value = "/findIdForm.jy")
	public String findIdForm(Model model) {
		
		System.out.println("연결됌=-==-=-=-=-=-=-=-");
		return "/member/find_Id";
	}
	//아이디 찾기 처리
		@RequestMapping(value = "/findId.jy")
		public @ResponseBody String findId(Model model, CommandMap commandMap) throws Exception
		{
			
			
			System.out.println((String)commandMap.getMap().get("idname"));
			//ajax jason data
			String idname = (String)commandMap.getMap().get("idname"); 
			String idemail = (String)commandMap.getMap().get("idemail"); 
			
			
			
			System.out.println("아이디찾기");
			//json data -> commandMap에 쿼리 컬럼명과 매핑하여 넣음
			commandMap.put("MEMBER_NAME", idname);
			commandMap.put("MEMBER_EMAIL", idemail);
			
			//쿼리 반환 값 String 변수로 받음
			String findId = loginService.findId(commandMap.getMap());
	        System.out.println("찾은아이디 : " + findId);
	        
			return findId;
		}	
		
		
		@RequestMapping(value = "/findPwForm.jy")
		public String findPwForm(Model model)
		{
			return "/member/find_Pw";
		}
		
		//비번찾기
		@RequestMapping(value = "/findPw.jy")
		public @ResponseBody String findPw(Model model, CommandMap commandMap) throws Exception
		{
			//ajax json data
			String pwname = (String)commandMap.getMap().get("pwname");
			String pwid = (String)commandMap.getMap().get("pwid");
			String pwemail = (String)commandMap.getMap().get("pwemail");
			
			System.out.println(pwname);
			System.out.println(pwid);
			System.out.println(pwemail);
			
			System.out.println("��й�ȣ ã��");
			//json data -> commandMap에 넣기� �־���
			commandMap.put("MEMBER_NAME", pwname);
			commandMap.put("MEMBER_ID", pwid);
			commandMap.put("MEMBER_EMAIL", pwemail);
			
			System.out.println(commandMap.getMap());
			
			//쿼리 반환 값 String 변수로 받음
			String findPw = loginService.findPw(commandMap.getMap());
			
			
			System.out.println("찾으신 비밀번호 : " + findPw);
			
			return findPw;
		}
	
	

}
