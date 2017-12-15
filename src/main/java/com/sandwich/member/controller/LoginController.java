package com.sandwich.member.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.CommandMap;
import com.sandwich.member.service.LoginService;
import com.sandwich.model.MemberModel;

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
	
	
	@RequestMapping("/findIdForm.jy")
	public String idFindForm() {
		return "findIdForm";
	}
 	
 	@RequestMapping(value="/findIdForm.jy", method=RequestMethod.POST)
 	public ModelAndView idFind(HttpServletRequest request) {
 		ModelAndView mav = new ModelAndView();
 		String member_name = (String) request.getParameter("member_name");
 		String member_email = (String) request.getParameter("member_email");
 		
 		System.out.println(member_name);
 		System.out.println(member_email);
 		
 		MemberModel member = new MemberModel();
 		member.setMember_name(member_name);
 		member.setMember_email(member_email);
 		
 		MemberModel idFindMember = loginService.idFind(member);
 	/*	System.out.println("db값 : "+ idFindMember.getMember_email());
 		System.out.println("가져온값: "+ member_email);*/
 		
 		
 		if(idFindMember != null) {
 			System.out.println("null이 아님");
 			if(member_email.equals(idFindMember.getMember_email())) {
 				mav.addObject("idFindMember", idFindMember);
 				mav.setViewName("idFindSuccess");
 				System.out.println("찾아온 아이디 : " + idFindMember.getMember_id());
 				return mav;
 				
 			} else {
 				mav.setViewName("idFindFail");
 				return mav;
 			}
 		} else {
 			mav.setViewName("idFindFail");
 			return mav;
 		}
 		
 	}
 	
 	@RequestMapping("/findPwForm.jy")
 	public String pwFindForm() {
 		return "findPwForm";
 	}
 	
 	@RequestMapping(value="/findPwForm.jy", method=RequestMethod.POST)
 	public ModelAndView pwFind(HttpServletRequest request) {
 		ModelAndView mav = new ModelAndView();
 		String member_id = (String) request.getParameter("member_id");
 		String member_email = (String) request.getParameter("member_email");
 		MemberModel member = new MemberModel();
 		member.setMember_id(member_id);
 		member.setMember_email(member_email);
 		
 		MemberModel pwFindMember = loginService.pwFind(member);
 		
 		if (pwFindMember != null) {
 			if(member_email.equals(pwFindMember.getMember_email())) {
 				mav.addObject("pwFindMember", pwFindMember);
 				mav.setViewName("pwFindSuccess");
 				return mav;
 				
 			} else {
 				mav.setViewName("pwFindFail");
 				return mav;
 			}
 		} else {
 			mav.setViewName("pwFindFail");
 			return mav;
 		}
 	}
	

}
