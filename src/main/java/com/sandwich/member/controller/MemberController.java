package com.sandwich.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sandwich.common.CommandMap;
import com.sandwich.member.service.LoginService;
import com.sandwich.member.service.MemberService;

//마이페이지 컨트롤러
@Controller
public class MemberController {
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	
	//마이페이지
	@RequestMapping(value = "/mypage.jy")
	public String mypage(HttpSession session, Model model, CommandMap commandMap) throws Exception
	{
		String mem_id = session.getAttribute("MEMBER_ID").toString();//세션에서 회원 아이디 가져오기
		
		commandMap.getMap().put("MEMBER_ID", mem_id); //회원 아이디 commandMap에 넣기
		
		return "mypage";
	}
	
	//회원정보 조회
	@RequestMapping(value = "/memberInfo.jy")
	public String memInfo(HttpSession session, Model model, CommandMap commandMap) throws Exception 
	{
		System.out.println("---------------나의 정보 조회 컨트롤러 진입-----------");
		String mem_id = session.getAttribute("MEMBER_ID").toString();
		
		commandMap.getMap().put("MEMBER_ID", mem_id);
		
		Map<String, Object> myInfo = memberService.myinfoDetail(commandMap.getMap());
		System.out.println("---------나의 아이디-------- : " + myInfo.get("MEMBER_ID"));
		model.addAttribute("myInfo", myInfo);
		
		return "/mypage/member_Info";
	}
	//회원 정보 수정 폼
	   @RequestMapping(value = "/memberUpdateForm.jy")
	   public String memUpdateForm(HttpSession session, Model model, CommandMap commandMap) 
	         throws Exception
	   { 
	      System.out.println("===========회원 정보 수정 폼 컨트롤러 진입===========");
	         
	      String mem_id = session.getAttribute("MEMBER_ID").toString(); //MEMBER_ID 값 설정
	         
	      commandMap.getMap().put("MEMBER_ID", mem_id); //MEMBER_ID 커맨드 map에 put
	   
	      //회원 ID에 해당하는 회원정보 myinfo 맵으로 받아오기
	      Map<String, Object> myInfo = memberService.myinfoDetail(commandMap.getMap());
	      //아이디 출력
	      System.out.println("===========나의 아이디=========== : " + myInfo.get("MEMBER_ID"));
	      model.addAttribute("myInfo", myInfo); //myinfo 영역에 저장
	           
	      String email = (String)myInfo.get("MEMBER_EMAIL");
	         
	      System.out.println("===========나의 이메일=========== : " + email); 
	         
	      //입력한 email 주소를 @를 기준으로 쪼갬
	      String [] split_email = email.split("@");
	         
	      //세션 영역 저장(이메일) : ex) ykc90831@gmail.com
	      session.setAttribute("email1", split_email[0].toString()); // ykc90831
	      session.setAttribute("email2", split_email[1].toString()); // gmail.com

	      return "mem_update_Form";
	   }
	
	//회원정보 수정처리
	@RequestMapping(value = "/memberUpdateAction.jy", method=RequestMethod.POST)
	public String memUpdateAction(HttpSession session, Model model, CommandMap commandMap) throws Exception
	{
		 System.out.println("===========회원 정보 수정 처리 컨트롤러 진입===========");
	      //split 된 이메일을 다시 합침
	     String MEMBER_EMAIL = commandMap.getMap().get(("MEMBER_EMAIL1"))
	            +"@"+ commandMap.getMap().get(("MEMBER_EMAIL2"));
	      
	     commandMap.getMap().put("MEMBER_EMAIL", MEMBER_EMAIL); //MEMBER_EMAIL map에 삽입
	      
		//map확인
		System.out.println("--------회원정보 수정처리에 필요한 commandMap출력-------");
		System.out.println(commandMap.getMap());
		
		//updatemember map 선언
		Map<String, Object> updatemember = new HashMap<String, Object>();
		updatemember = commandMap.getMap();//update 할 정보를 updatemember에 넣음
		memberService.updateMyinfo(updatemember);//update 쿼리 실행
		
		//memberMap map 선언
		Map<String, Object> memberMap = new HashMap<String, Object>();
		memberMap = memberService.myinfoDetail(commandMap.getMap());//바뀐 회원정보를 불러옴
		model.addAttribute("memberInfo", memberMap);//model에 저장
		
		
		return "mem_update_Form";
	}
	
	//회원정보 삭제처리
	@RequestMapping(value = "/memberDeleteAction.jy")
	public String memDeleteAction(HttpSession session, Model model, CommandMap commandMap) throws Exception
	{
		System.out.println("-------회원정보 삭제처리 컬트롤러 진입--------");
		String mem_id = commandMap.getMap().get("MEMBER_ID").toString();
		
		commandMap.getMap().put("MEMBER_ID", mem_id);//MEMBER_ID commandMap에 저장
		System.out.println(commandMap.getMap());
		
		//map확인
		System.out.println("--------회원정보 삭제처리에 필요한 commandMap 출력-------");
		memberService.deleteMember(commandMap.getMap());
		
		Map<String, Object> member = new HashMap<String, Object>(); //member map 선언
	    member = memberService.myinfoDetail(commandMap.getMap()); //회원 정보를 map에 담음
	    
	    session.invalidate(); //세션 종료
	    
	    return "member_Info";
	}

}
