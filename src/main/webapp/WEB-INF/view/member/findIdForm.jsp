<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID찾기</title>
</head>
<body>
<center>
	<form action="/sandwich/findIdForm.jy" method="post">
	<br><br><br><br><br><br><br><br><br>
	<table border="1" cellspacing="0" cellpadding="0" width="50%" align="center" >
	<tr>
		<td align="center">
		이름 :
		</td>
		<td>
			<input type="text" name="member_name">
		</td>
		<td rowspan="3">
		<input type="submit" value="아이디 찾기" style="WIDTH: 90pt; HEIGHT: 60pt">
		</td>
	</tr>
	<tr>
		<td align="center">
		이메일
		</td>
		<td >
			<input type="text" name="member_email" >
		</td>
	</tr>
	<tr>
	<td>
		 <input  type="button" value="메인으로 가기" onClick="javascript:location.href='/sandwich/main.jy'">
		</td>
		
		<td>
		<input  type="button" value="비밀번호 찾기" onClick="javascript:location.href='/sandwich/findPwForm.jy'">
		<input  type="button" value="회원가입" onClick="javascript:location.href='/sandwich/join.jy'">
		</td>

	</tr>
	</table>
	</form>
	<br><br><br><br><br><br><br><br><br>
</center>
</body>
</html>