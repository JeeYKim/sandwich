<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/common.js"></script>
<link href="resources/css/ui.css" rel="stylesheet">

<div class="row" style="padding-left: 15px;">
	<h1 class="page-header">발주수정</h1>
</div>
<div>
	<form action="<c:url value="/orderSave.jy"/>" id="frm" name="frm" method="post">
		<input type="hidden" name="orderNo" value="${order.orderNo }">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*" />
			</colgroup>

			<tbody>
				<tr>
					<th scope="row">카테고리</th>
					<td>
						<select id="orderBigtype" name="orderBigtype">
							<OPTION value='' selected="selected">---재료 종류을 선택하세요---</OPTION>
							<OPTION value='빵'>빵</OPTION>
							<OPTION value='야채'>야채</OPTION>
							<OPTION value='소세지'>소세지</OPTION>
							<OPTION value='치즈'>치즈</OPTION>
							<OPTION value='소스'>소스</OPTION>
						</select>
					</td>
				</tr>

				<tr>
					<th scope="row">카테고리</th>
					<td><select id="orderSmalltype" name="orderSmalltype" size=1></select></td>
				</tr>


				<tr>
					<th scope="row">수량</th>
					<td><input type="text" id="orderAmount" name="orderAmount"
						value="${order.orderAmount}" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">가격</th>
					<td><input type="text" id="orderPrice" name="orderPrice"
						value="${order.orderPrice}" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">발주날짜</th>
					<td><input type="date" id="orderOrderdate"
						name="orderOrderdate" value="<fmt:formatDate value="${order.orderOrderdate}" pattern="yyyy-MM-dd"/>"  /></td>
				</tr>
			</tbody>
		</table>
		<br/>
		<br/> 
		
		<input type="submit" id="modify" class="btn btn-default" value="수정하기" />
		<button type="button" id="list" class="btn btn-default">목록으로</button>
	</form>
</div>

<script src="<c:url value="/resources/js/staff/order.js"/>"></script>
<script>
	selectOrderBigtype('${order.orderBigtype}', '${order.orderSmalltype}');
</script>