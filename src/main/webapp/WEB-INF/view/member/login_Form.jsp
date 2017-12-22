<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/sandwich/resources/css/loginForm.css?ver=1" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
function find_Id()
{
	//아이디 찾기 팝업 창
	window.open('/sandwich/findIdForm.jy','','toolbar=no,menubar=no,location=no,height=650,width=600'); 
} 

function find_Pw()
{
	//비밀번호 찾기 팝업 창
	window.open('/sandwich/findPwForm.jy','','toolbar=no,menubar=no,location=no,height=650,width=600'); 
}
</script>

<title>Insert title here</title>
</head>
<body>

	<div class="message">${message}</div>
	<div id="loginform">
		<div id="loginformtop"></div>
		
		<form name="loginform" method="post"
			action="/sandwich/loginSuccess.jy">
			<div id="loginformmiddle">
				<h2>Login</h2>
					<div id="id_label">ID</div>
					<div id="username_input">

						<div id="username_inputleft"></div>

						<div id="username_inputmiddle">

							<input type="text" name="MEMBER_ID" id="ID" required="required">
							<img id="url_user" src="resources/images/login/mailicon.png" alt="" style="height:15px">

						</div>

						<div id="username_inputright"></div>
					</div>
					<div id="password_label">비밀번호</div>

					<div id="password_input">
  
						<div id="password_inputleft"></div>     

						<div id="password_inputmiddle">

							<input type="password" name="MEMBER_PW" id="PW"	required="required"> 
							<img id="url_password" src="resources/images/login/passicon.png" alt="" style="width:15px">

						</div>


						<div id="password_inputright"></div>
    
					</div>
   					
					<div id="submit">
						<%--로그인 버튼이 이미지이기 때문에 따로 submit 설정 --%>
						 <input type="image" src="resources/images/login/sing_in_2.PNG"
							id="submit2" value="Sign In"
							onchange="javascript:document.getElementById('frm').value=this.value"> 
							
						<%--onchange : 버튼 -> 태그 ID가 frm인 것의 값을 찾아서 바꿔줌 --%>
					</div>
						
					<%--아이디/비밀번호 찾기 --%>
<br><br><br><br><br><br><br><br><br>
					<div id="links_left">
						
							<a href="javascript:find_Id();" style="margin: 0 30px 30px 120px">아이디 찾기</a>
						
							<a href="javascript:find_Pw();">비밀번호 찾기</a>
					


					</div>   

					<!-- 회원가입 페이지로 -->
					<div id="links_right">
						<a href="join.jy" style="margin: 0 50px 0 0;">회원가입</a>
						
					</div> 
					
				</div>
			
		</form>
		<div id="loginformbottom"></div>
	</div>
	<br><br><br><br>

</body>
</html>