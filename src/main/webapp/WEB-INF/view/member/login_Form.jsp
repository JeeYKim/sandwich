<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/loginForm.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="message">${message}</div>
<div id="loginform">
      <div id="loginformtop"></div>
      
<form name="loginform" method="post" action="/sandwich/loginSuccess.jy">
      <div id="loginformmiddle">

         <h2>Login</h2>

         <div id="id_label">ID</div>
         <div id="username_input">

            <div id="username_inputleft"></div>
            
               <div id="username_inputmiddle">
                  
                  <input type="text" name="MEMBER_ID" id="ID" required="required"> 
                  <img id="url_user" src="resources/images/login/mailicon.png" alt="">

               </div>

               <div id="username_inputright"></div>
         </div>
         <div id="password_label">비밀번호</div>
     
         <div id="password_input">

            <div id="password_inputleft"></div>

            <div id="password_inputmiddle">
                    
               <input type="password" name="MEMBER_PW" id="PW" required="required"> 
               <img id="url_password" src="resources/images/login/passicon.png" alt="">

            </div>


            <div id="password_inputright"></div>

         </div>

         <div id="submit">
            <%--로그인 버튼이 이미지이기 때문에 따로 submit 설정 --%>
            <input type="image" src="resources/images/login/login.png" id="submit2"
               value="Sign In" onchange="javascript:document.getElementById('frm').value=this.value">
               <%--onchange : 버튼 -> 태그 ID가 frm인 것의 값을 찾아서 바꿔줌 --%>
         </div>
         
         <%--아이디/비밀번호 찾기 --%>
         <div id="links_left">
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/sandwich/findIdForm.jy">아이디 찾기</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/sandwich/findPwForm.jy">비밀번호 찾기</a>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             
            
             
         </div>
         
         <%--회원가입 페이지로 --%>
         <div id="links_right">
            <a href="join.jy">회원가입</a>
         </div>
      </div>
      </form>
      <div id="loginformbottom"></div>
   </div>
</body>
</html>