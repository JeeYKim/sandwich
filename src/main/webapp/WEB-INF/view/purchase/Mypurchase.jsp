<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>내 주문 내역</title>




</head>
<body>

	<table border="3" >
		<tr>
			<td>주문번호</td>
			<td>주문가격</td>
			<td>주문날자</td>
		</tr>
		<c:forEach items="${list}" var="my" >
		 	<c:url var="viewURL" value="/mypurchaseDetail.jy">	
				<c:param name="PURCHASE_NO" value="${my.PURCHASE_NO}">
				</c:param>

			</c:url>
		<tr>
			<td class="title">
         	<a href="${ viewURL}" name="PURCHASE_NO">${my.PURCHASE_NO }</a>
         	<input type="hidden" id="PURCHASE_NO" value="${my.PURCHASE_NO }"></td>
			<td>${my.PURCHASE_ALLPRICE}</td>
			<td>${my.PURCHASE_ORDERDATE }</td>
		</tr>
		</c:forEach>
		<tr>
		<td><a href='basketlist.jy'>장바구니</a></td>
		</tr>
	</table>

</body>
</html>