package com.sandwich.member.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sandwich.common.CommandMap;
import com.sandwich.member.service.JoinService;

@Controller
public class JoinController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private JoinService joinService;
	
	String authNum = ""; //인증번호 초기화
    
	//회원가입 폼
	@RequestMapping(value="/join.jy")
	public ModelAndView JoinForm(Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request, CommandMap Map)throws Exception{
		ModelAndView mav = new ModelAndView("joinForm");
		
		String email1 = (String)session.getAttribute("email1");
		String email2 = (String)session.getAttribute("email2");
		
		
		
		return mav;
	}
	
	//회원가입 성공시
	@RequestMapping(value="/join.jy", method=RequestMethod.POST)
	public ModelAndView JoinSuccess(Model model, CommandMap commandMap, HttpServletRequest request) throws Exception 
	{
		ModelAndView mav = new ModelAndView("join_complete");
		
		String MEMBER_EMAIL = request.getParameter("MEMBER_EMAIL1")+"@"+request.getParameter("MEMBER_EMAIL2");
		
        Map<String, Object> memberMap = new HashMap<String, Object>();
		
        memberMap = commandMap.getMap();
        memberMap.put("MEMBER_EMAIL", MEMBER_EMAIL);
		
		System.out.println("ID : "+commandMap.get("MEMBER_ID"));
		System.out.println("PW : "+commandMap.get("MEMBER_PW"));
		System.out.println("NAME : "+commandMap.get("MEMBER_NAME"));
		System.out.println("EMAIL : "+commandMap.get("MEMBER_EMAIL"));
		
		joinService.insertMember(memberMap); 
		
		
		return mav;
	}
	
	//아이디 중복 체크
	@RequestMapping(value="/checkId.jy")
	@ResponseBody
	public  int checkId(HttpServletRequest request,HttpServletResponse response, CommandMap commandMap) throws Exception
	{
		//스크립트에 넘겨준id 값을 받음
		String mem_id = (String) commandMap.getMap().get("mem_id");

		//을 MEMBER_ID 값으로 map에 다시 넣어줌
		commandMap.getMap().put("MEMBER_ID", mem_id);
		
		//MEMBER 테이블에 입력한 ID가 있는지에 대한 여부 체크
		int checkId = joinService.checkId(commandMap.getMap());
		
		System.out.println("checkId="+checkId);
		System.out.println(commandMap.getMap());
		
	   return checkId;
	}
	
	
	//이메일 인증 선택
		@RequestMapping(value = "/joinEmail.jy")
		public String joinEmail(Model model)
		{		
			return "joinEmail";
		}
		
		//이메일 인증
		@RequestMapping(value = "/modal_email.jy")
		public String modal_email(Model model) 
		{
			return "/member/modal_email";
		}
		
		//이메일 인증 로직 시작
	@RequestMapping(value = "/join_Step1/modal_email_auth.jy")
	public String email_auth(HttpServletResponse response, HttpServletRequest request, HttpSession session, Model model,
			CommandMap commandMap) throws Exception {
			
			//ajax로 넘겨준 email 값을 받음
			String email = (String) commandMap.getMap().get("email");
			
			//그 값(이메일)이 잘 들어왔는지 확인
		    System.out.println("email = " + email);
		    
			//입력한 email 주소를 @를 기준으로 쪼갬
			String [] split_email = email.split("@");
			
			//세션 영역 저장(이메일) : ex) ykc90831@gmail.com
		    session.setAttribute("email1", split_email[0].toString()); // ykc90831
		    session.setAttribute("email2", split_email[1].toString()); // gmail.com
			
			//email을 MEMBER_EMAIL 값으로 map에 다시 넣어줌
			commandMap.getMap().put("MEMBER_EMAIL", email);
			
			//commandMap에 잘 들어갔는지 확인
			System.out.println(commandMap.getMap());
			
			//MEMBER 테이블에 입력한 이메일이 있는지에 대한 여부 체크
			int checkNum = joinService.checkEmail(commandMap.getMap());
			
			System.out.println("checkNum="+checkNum); //이메일 유/무 check
			
			//등록된 이메일이 없을 경우,
			if(checkNum==0)
			{
			
			authNum = RandomNum(); //인증번호 생성
			sendEmail(email.toString(), authNum);
			System.out.println("메일보냄");
			System.out.println("인증번호 :"+authNum);
			}
			
			String checkNumString = String.valueOf(checkNum);
			PrintWriter writer = response.getWriter();
			
			//이메일이 있는지 여부에 대한 checkNum을 write -> joinStep1.jsp 안에 email_code에서 checkNum을 가져다 씀 
			writer.write(checkNumString);        
			writer.flush(); //강제성..
			writer.close();
					
			model.addAttribute("email",email);
			model.addAttribute("authNum", authNum);
							
			return "join_Step1";
		}
		
		//인증된 이메일로 메일 보내기
		private void sendEmail(String email,String authNum)
		{
			System.out.println("이메일보내기 ");
			String host ="smtp.gmail.com";
			String subject = "불타는 인증 번호 전달"; // 메일 제목
			String fromName ="불타는 관리자"; //보낸이
			String from="JY@gmail.com"; //관리자 메일
			String to1 = email; //회원 이메일
			
			String content = "안녕하세요. 불타는 샌드위치입니다. 인증번호[" + authNum +"]"; //인증버호 발송 메일 내용
			
			try
			{
				Properties props = new Properties();
				
				props.put("mail.smtp,starttls.enable","true");
				props.put("mail.transport.protocol", "smtp");
				props.put("mail.smtp.host",host);
				props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.put("mail.smtp.port", "465");
				props.put("mail.smtp.user", from);
				props.put("mail.smtp.auth", "true");
				
				Session mailSession = Session.getInstance(props,new javax.mail.Authenticator()
				{
						protected PasswordAuthentication getPasswordAuthentication()
						{
						  //관리자 이메일 패스워드 인증
					      return new PasswordAuthentication("qweasd120123@gmail.com","rlawldud");
					    
				}
				});
				Message msg = new MimeMessage(mailSession);
				msg.setFrom(new InternetAddress(from,MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는사람설정
				
				InternetAddress[] address1 = {new InternetAddress(to1)};
				
				msg.setRecipients(Message.RecipientType.TO, address1); //받는사람설정1
				msg.setSubject(subject); //제목설정
				msg.setSentDate(new java.util.Date()); //보내는 날짜설정
				msg.setContent(content,"text/html;charset=utf-8"); //내용설정
				
				Transport.send(msg);
			}
			catch (MessagingException e) 
			{
				e.printStackTrace();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				
			}
		}
		
		//인증번호 랜덤 생성
		public String RandomNum()
		{
			StringBuffer buffer = new StringBuffer();
			for(int i = 0;i<=6;i++)
			{
				int n= (int)(Math.random() * 10);
				buffer.append(n);
			}
			return buffer.toString();
		}
		
		//인증번호 유효성 검증
		@RequestMapping(value="/join_Step1/modal_email_auth_success.jy", method=RequestMethod.POST)
	    public @ResponseBody String authValidate (HttpServletRequest request) throws Exception   
	    {
	         
	        String str = authNum;
	        System.out.println("인증번호 검사 : "+ authNum);
	        return str;
	    }
		
		
	
	
	
	
}
	