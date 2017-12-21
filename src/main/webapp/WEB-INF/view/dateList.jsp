<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" type="text/css"
	href="./resources/css/modal_email.css" />
<title>Insert title here</title>
<style>
.left-box {
	position: absolute;
	float: left;
	top: 0;
	left: 10%;
}

.s_smalltype {
	text-align: center;
}

.right-box {
	position: absolute;
	float: left;
	top: 55px;
	left: 50%;
}
</style>
</head>
<body>

	<div class='reft-box'>
		<div style="font-weight:bold; font-size:20px;">
		유통기한
		</div>
		<table border=1>
			<c:forEach var="dateList" items="${dateList}" varStatus="stat">
				<tr>

					<%-- <td>${dateList.SANDWICH_NO}</td>  --%>
					<td class="s_smalltype">&nbsp;&nbsp;&nbsp;${dateList.SANDWICH_SMALLTYPE}&nbsp;&nbsp;&nbsp;</td>
					<c:if test="${dateList.SANDWICH_DATE lt 7}">
						<td style="color: red;">&nbsp;&nbsp;&nbsp;유통기한이&nbsp;	${dateList.SANDWICH_DATE}일 남았습니다.&nbsp;&nbsp;&nbsp;</td>
					</c:if>
					<c:if test="${dateList.SANDWICH_DATE ge 7}">
						<td>&nbsp;&nbsp;&nbsp;유통기한이&nbsp; ${dateList.SANDWICH_DATE}일 남았습니다.&nbsp;&nbsp;&nbsp;</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		</br>
	</div>
  


	<div class='right-box'>
	
		<div style="font-weight:bold; font-size:20px;">
		재고
		</div>
		<table border=1>

			<c:forEach var="stockList" items="${stockList}" varStatus="stat">
				<tr>

					<%-- <td>${stockList.SANDWICH_NO}</td>  --%>
					<td class="s_smalltype">&nbsp;&nbsp;&nbsp;${stockList.SANDWICH_SMALLTYPE}&nbsp;&nbsp;&nbsp;</td>
					<c:if test="${stockList.SANDWICH_AMOUNT lt 50}">
						<td style="color: red;">&nbsp;&nbsp;&nbsp;재고가&nbsp;${stockList.SANDWICH_AMOUNT} 개 남았습니다.&nbsp;&nbsp;&nbsp;</td>
					</c:if>
					<c:if test="${stockList.SANDWICH_AMOUNT ge 50}">
						<td>&nbsp;&nbsp;&nbsp;재고가&nbsp; ${stockList.SANDWICH_AMOUNT}개 남았습니다.&nbsp;&nbsp;&nbsp;</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>




</body>
</html>