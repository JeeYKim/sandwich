<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br><br><br><br><br>
	<center><h2><b>찾으신 ID는 ${pwFindMember.member_id} </b></h2>
	<h2><b>찾으신 PW는 ${pwFindMember.member_pw} </b></h2>
	<input  type="button" value="메인으로 가기" onClick="javascript:location.href='/sandwich/main.jy'"></center>
</body>
</html>