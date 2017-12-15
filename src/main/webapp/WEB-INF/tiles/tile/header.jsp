<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');

#logoWrap{
   width:600px;
   height:200px;
   margin-left:auto;
   margin-right:auto;
}
#loginWrap{

   height:50px;
/*    background-color:blue; */
   font-family: PureunJeonnam;
   
}

#loginWrap ul{
      list-style-type: none;  /* 메인 메뉴 안의 ul 내부의 목록 표시를 없애줌 */
        margin: 0px;            /* 메인 메뉴 안의 ul의 margin을 없앰 */
        padding: 0px;           /* 메인 메뉴 안의 ul의 padding을 없앰 */
}

#loginWrap ul li{
        color: white;               /* 글씨 색을 흰색으로 설정 */
        float: right;                /* 왼쪽으로 나열되도록 설정 */
        line-height: 40px;          /* 텍스트 한 줄의 높이를 30px로 설정 */
        vertical-align: middle;     /* 세로 정렬을 가운데로 설정 */
        text-align: center;         /* 텍스트를 가운데로 정렬 */
        margin-right:10px;
        font-family: PureunJeonnam;
}
.loginLink{
      text-decoration:none;               /* a 태그의 꾸밈 효과 제거 */
      font-size: 15px;                    /* 폰트 사이즈를 12px로 설정 */
        font-weight: bold;                  /* 폰트를 굵게 설정 */
        font-family: PureunJeonnam;
}

.loginname{
      text-decoration:none;               /* a 태그의 꾸밈 효과 제거 */
      font-size: 15px;                    /* 폰트 사이즈를 12px로 설정 */
        font-weight: bold;                  /* 폰트를 굵게 설정 */
        font-family: PureunJeonnam;      
        float : right;
        margin-right:40px;
        margin-top:10px;
}
</style>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>불타는 샌드위치</title>

</head>

<body>


	<header>
	<div class="container">
		<div id="loginWrap">

			<c:choose>

				<c:when test="${(sessionScope.MEMBER_LEVEL) == NULL}">
					<ul>
						<li><a class="loginLink" href="loginForm.jy">로그인</a></li>
						<li><a class="joinLink" href="join.jy">회원가입</a></li>
					</ul>
				</c:when>

				<c:otherwise>
					<ul>
						<li><a class="loginLink" href="logout.jy">로그아웃</a></li>
						<c:if test="${(sessionScope.MEMBER_LEVEL) < 1 }">
							<li><a class="loginLink" href="mypage.jy">마이페이지</a></li>
						</c:if>
						<c:if test="${(sessionScope.MEMBER_LEVEL) == 1 }">
							<li><a class="loginLink" href="staff.jy">직원페이지</a></li>
						</c:if>
						<c:if test="${(sessionScope.MEMBER_LEVEL) == 2 }">
							<li><a class="loginLink" href="admin.jy">관리자페이지</a></li>
						</c:if>
					</ul>
					<div class="loginname">${sessionScope.MEMBER_NAME}님환영합니다!</div>
				</c:otherwise>

			</c:choose>

		</div>
	</div>
	<div id='cssmenu' class="align-center">
		<ul>
			<li class="active"><a href='main.jy'><span>뽜이아</span></a></li>

			<li class='last'><a href='order.jy'><span>주문</span></a></li>
			<li class='last'><a href="<c:url value = "/mainNoticeList.jy"/>"><span>공지사항</span></a></li>
		</ul>
	</div>

	<div class="logo">
		<hr class="line-1">
		<a href="main.jy">불타는 샌드위치</a> <span>고갱님 맘대로 해드세요</span>
		<hr class="line-1">
	</div>
	</header>
</body>
</html>