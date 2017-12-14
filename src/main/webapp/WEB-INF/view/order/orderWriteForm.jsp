<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/common.js"></script>
<link href="resources/css/ui.css" rel="stylesheet">


<form action="<c:url value="/orderSave.jy"/>" method="post"/>
<div class="row" style="padding-left:15px;width:100%;">    
	<h1 class="page-header">발주등록</h1>
</div>
	<form id="frm" name="frm" method="post" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>발주등록</caption>
			<tbody>
			    <tr>
					<th scope="row">카테고리</th>
					<td>
						<select id="orderBigtype" name="orderBigtype" size=1>
						<OPTION value=''>---카테고리를 선택하세요---</OPTION>
						<!-- 
						<OPTION value='빵'>빵</OPTION>
						<OPTION value='야채'>야채</OPTION>
						<OPTION value='소세지'>소세지</OPTION>
						<OPTION value='치즈'>치즈</OPTION>
						<OPTION value='소스'>소스</OPTION>
						 -->
						</select>
					</td>
				</tr>
				
				<tr>
					<th scope="row">종류</th>
					<td>
						<select id="orderSmalltype" name="orderSmalltype" size=1>
							<OPTION value=''>---카테고리를 선택하세요---</OPTION>
						</select>
					</td>
				</tr>
				
				<tr>
					<th scope="row">수량</th>
					<td><input type="text" id="orderAmount" name="orderAmount" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">가격</th>
					<td><input type="text" id="orderPrice" name="orderPrice" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">발주날짜</th>
					<td><input type="date" id="orderOrderdate" name="orderOrderdate" /></td>
				</tr>	
			</tbody>
		</table>   
		<br/><br/>
		<input type="submit" value="등록하기"/>
	</form>

<script>
	var sandwichJsonStr = '${sandwichList}';
</script>

<script src="<c:url value="/resources/js/staff/order.js"/>"></script>
