<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1" >
		<tr>
			<td>�ε���</td>
			<td>�ֹ���ȣ</td> 
			<td>�ֹ��ѳ�</td>
			<td>�� Ÿ��</td>
			<td>����</td>
			<td>����</td>
			<td>���� ����</td>
			<td>����</td>
			<td>�ֹ� ����</td>
		</tr>
		<c:forEach items="${list}" var="my" >

		<tr>
			<td>${my.PURCHASE_INDEX } </td>
			<td>${my.PURCHASE_NO}</td>
			<td>${my.PURCHASE_ID }</td>
			<td>${my.PURCHASE_BIGTYPE }</td>
			<td>${my.PURCHASE_SMALLTYPE }</td>
			<td>${my.PURCHASE_AMOUNT }</td>
			<td>${my.PURCHASE_PRICE}</td>
			<td>${my.PURCHASE_ORDERDATE }</td>
			<td>${my.PURCHASE_BASKET }</td>
			
			
			
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>