<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재료수정</title>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/common.js"></script>
<link href="resources/css/ui.css" rel="stylesheet">
</head>
<body>

<div class="row" style="padding-left:15px;">    
	<h1 class="page-header">재료 수정</h1>
</div>
<div>
	<form id="frm" name="frm" method="post" enctype="multipart/form-data" >
			<input type="hidden" name="ORIGINAL_SANDWICH_THUMBNAIL" value="${ingredient.SANDWICH_THUMNAIL }">
			<input type="hidden" name="SANDWICH_THUMBNAIL" value="${ingredient.SANDWICH_THUMNAIL}">
			<input type="hidden" name="SANDWICH_NO" value="${ingredient.SANDWICH_NO }">
		<table class="board_view" >
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			
			<tbody>
			    <tr>
					<th scope="row">카테고리</th>
					<td>
						<select id="SANDWICH_BIGTYPE" name="SANDWICH_BIGTYPE" size=1>
						<OPTION value=''>---재료 종류을 선택하세요---</OPTION>
						<OPTION value='빵'>빵</OPTION>
						<OPTION value='야채'>야채</OPTION>
						<OPTION value='소세지'>소세지</OPTION>
						<OPTION value='치즈'>치즈</OPTION>
						<OPTION value='소스'>소스</OPTION>
						</select>
						<span>기존 카테고리 : ${ingredient.SANDWICH_BIGTYPE }</span>
					</td>
				</tr>

				<tr>
					<th scope="row">재료명</th>
					<td><input type="text" id="SANDWICH_SMALLTYPE" name="SANDWICH_SMALLTYPE"  value="${ingredient.SANDWICH_SMALLTYPE}" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">수량</th>
					<td><input type="text" id="SANDWICH_AMOUNT" name="SANDWICH_AMOUNT" value="${ingredient.SANDWICH_AMOUNT}" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">가격</th>
					<td><input type="text" id="SANDWICH_PRICE" name="SANDWICH_PRICE" value="${ingredient.SANDWICH_PRICE}" class="wdp_90"></input></td>
				</tr>

				<tr>
					<th scope="row">썸네일 <Br> 이미지</th>
					<td><input type="file" id="SANDWICH_THUMBNAIL" name="SANDWICH_THUMBNAIL" value="${ingredient.SANDWICH_THUMNAIL}">
					<span>기존이미지 : ${ingredient.SANDWICH_THUMNAIL}</span>	
				 	</td>
				</tr>

				<tr>
					<th scope="row">발주날짜</th>
					<td><input type="text" id="SANDWICH_ORDERDATE" name="SANDWICH_ORDERDATE" value="${ingredient.SANDWICH_ORDERDATE}" readonly/></td>
				</tr>
				<tr>
					<th scope="row">유통기한</th>
					<td><input type="date" id="SANDWICH_ENDDATE" name="SANDWICH_ENDDATE" />
					<span>기존 유통기한 : ${ingredient.SANDWICH_ENDDATE}</span>
					</td>
				</tr>
			
			</tbody>
		</table>   
		<br/><br/>
		<a href="#this" class="btn" id="modify">수정하기</a>
	</form>
	</div>
<script type="text/javascript">   
$(document).ready(function(){
	$("#modify").on("click", function(e){ //작성하기 버튼
		e.preventDefault();
		 if($('#SANDWICH_SALLTYPE').val()==""){
			alert("재료명을 입력해 주세요.");
			return false;
		 } else if($('#SANDWICH_BIGTYPE').val()==""){
			 alert("재료 종류를 선택해 주세요")
		 
		 } else if($('#SANDWICH_PRICE').val()==""){
			 alert("재료 가격을 입력해 주세요.");
				return false;
		 } else if($('#SANDWICH_THUMBNAIL').val()==""){
			 alert("재료 썸네일이미지를 등록해 주세요.");
				return false;
		 } else if($('#SANDWICH_AMOUNT').val()==""){
			 alert("재료 수량을 입력해 주세요.");
				return false;
		 } else if($('#SANDWICH_ORDERDATE').val()==""){
			 alert("재료 발주 날짜를 입력해 주세요.");
				return false;
		 } else if($('#SANDWICH_ENDDATE').val()==""){
			 alert("재료 유통기한을 입력해 주세요.");
				return false;
		 }
		 else{
		fn_modifyIngredient();
		}
	});
	
});

function fn_modifyIngredient(){
	var comSubmit = new ComSubmit("frm");
	comSubmit.setUrl('/sandwich/ingredientInsert.jy');
	comSubmit.submit();
}
</script>
</body>
</html>