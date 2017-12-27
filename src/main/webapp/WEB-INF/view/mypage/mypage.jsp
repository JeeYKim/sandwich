<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="resources/css/mypage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>     
<!-- <script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script> -->

 
<script type="text/javascript">
                 
function member_info()
{
	//나의 정보보기 팝업 창
	window.open('/sandwich/memberInfo.jy','','toolbar=no,menubar=no,location=no,height=950,width=1200'); 
}


</script>

<title>mypage게시판</title>
</head>
<body>
<div style="text-decoration: none;color:black; font-size:2em; text-align:center">
	My&nbsp;Page
</div>
<div>
	<hr color="#2d2d2b" width="100%" size="1">
</div>
<div id="contents_area" class="col-xs-9" style="text-align:center;"> 
			<div class="ranking_cont">
				<div class="ranking_box ea2">
					<a href="#memberInfo" onclick="javascript:member_info();"> 
						<img src="resources/images/mypage/modify.png">
						<p>
							<b>내&nbsp;정보&nbsp;보기</b>내 정보를 확인하고 수정 할 수 있습니다.
						</p>
					</a>
					
					<a href="javascript:location.href='mypurchas.jy'">
						<img src="resources/images/mypage/notice.png">
						<p>
							<b>주문내역</b>내가 주문한 내역을 볼 수 있습니다.
						</p>
					</a>
					
					<a href="javascript:location.href='basketlist.jy'">
						<img src="resources/images/mypage/bookmark.png">
						<p>
							<b>장바구니</b>장바구니에 추가한 내역을 볼 수 있습니다.
						</p>
					</a>
					<a href="javascript:location.href='mypurchas.jy'">
						<img src="resources/images/mypage/my_recipe.png">
						<p>
							<b>내가&nbsp;쓴&nbsp;DIY추천</b>내가 작성한 DIY추천 내역을 볼 수 있습니다.
						</p>
					</a>
					
					<a href="javascript:location.href='boardList.jy'">
						<img src="resources/images/mypage/faq.png">
						<p>
							<b>1:1상담</b>1:1상담을 확인 할 수 있습니다.
						</p>
					</a>
				</div>
			</div>
</div>

</body>
</html>