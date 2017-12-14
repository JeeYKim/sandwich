<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>불타는 샌드위치</title>
	
</head>

<body>


	<header>
		<div id='cssmenu' class="align-center">
			<ul>
			   <li class="active"><a href='main'><span>집</span></a></li>
			   <li class='last'><a href='login'><span>드루와</span></a>
				
			   <li class='last'><a href='order'><span>배고파?</span></a></li>
			   <li class='last'><a href="<c:url value = "/mainNoticeList.jy"/>"><span>좀 봐줘</span></a></li>
			</ul>
		</div>
		
			<div class="logo">
				<hr class="line-1">
				<a href="#">불타는 샌드위치</a>
				<span>고갱님 맘대로 해드세요</span>
				<hr class="line-1">
			</div>
		</header>		
</body>
</html>