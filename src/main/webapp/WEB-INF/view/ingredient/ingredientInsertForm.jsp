<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재료 등록</title>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/common.js"></script>
<link href="resources/css/ui.css" rel="stylesheet">
</head>
<body>

<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">재료등록</h1>
</div>
	<form id="frm" name="frm" method="post" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>재료등록</caption>
			<tbody>
			    <tr>
					<th scope="row">카테고리</th>
					<td>
						<select id="SANDWITCH_BIGTYPE" name="SANDWITCH_BIGTYPE" size=1>
						<OPTION value=''>---재료 종류을 선택하세요---</OPTION>
						<OPTION value='빵'>빵</OPTION>
						<OPTION value='야채'>야채</OPTION>
						<OPTION value='소세지'>소세지</OPTION>
						<OPTION value='치즈'>치즈</OPTION>
						<OPTION value='소스'>소스</OPTION>
						</select>
					</td>
				</tr>

				<tr>
					<th scope="row">재료명</th>
					<td><input type="text" id="SANDWITCH_SMALLTYPE" name="SANDWITCH_SMALLTYPE" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">수량</th>
					<td><input type="text" id="SANDWITCH_AMOUNT" name="SANDWITCH_AMOUNT" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">가격</th>
					<td><input type="text" id="SANDWITCH_PRICE" name="SANDWITCH_PRICE" class="wdp_90"></input></td>
				</tr>

				<tr>
					<th scope="row">썸네일 이미지</th>
					<td><input type="file" id="SANDWITCH_THUMBNAIL" name="SANDWITCH_THUMBNAIL"></td>
				</tr>

				<tr>
					<th scope="row">발주날짜</th>
					<td><input type="text" id="SANDWITCH_ORDERDATE" name="SANDWITCH_ORDERDATE"/></td>
				</tr>
				<tr>
					<th scope="row">유통기한</th>
					<td><input type="text" id="SANDWITCH_ENDDATE" name="SANDWITCH_ENDDATE"/></td>
				</tr>
			
			</tbody>
		</table>
		<br/><br/>
	
		<a href="#this" class="btn" id="write">작성하기</a>
 		<a href="#this" class="btn" id="list">목록으로</a>
	</form>
<script type="text/javascript">   
$(document).ready(function(){
	 $("#list").on("click", function(e){ //목록 버튼
		e.preventDefault();
		fn_openIngredientList();
	}); 
		
	$("#write").on("click", function(e){ //작성하기 버튼
		e.preventDefault();
		 if($('#SANDWITCH_SALLTYPE').val()==""){
			alert("재료명을 입력해 주세요.");
			return false;
		 } else if($('#SANDWITCH_BIGTYPE').val()==""){
			 alert("재료 종류를 선택해 주세요")
		 
		 } else if($('#SANDWITCH_PRICE').val()==""){
			 alert("재료 가격을 입력해 주세요.");
				return false;
		 } else if($('#SANDWITCH_THUMBNAIL').val()==""){
			 alert("재료 썸네일이미지를 등록해 주세요.");
				return false;
		 } else if($('#SANDWITCH_AMOUNT').val()==""){
			 alert("재료 수량을 입력해 주세요.");
				return false;
		 } else if($('#SANDWITCH_ORDERDATE').val()==""){
			 alert("재료 발주 날짜를 입력해 주세요.");
				return false;
		 } else if($('#SANDWITCH_ENDDATE').val()==""){
			 alert("재료 유통기한을 입력해 주세요.");
				return false;
		 }
		 else{
		fn_insertIngredient();
		}
	});
	
});
 
function fn_openIngredientList(){
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("ingredientList.jy");
	comSubmit.submit();
}
 
function fn_insertIngredient(){
	var comSubmit = new ComSubmit("frm");
	comSubmit.setUrl('/sandwich/ingredientInsert.jy');
	comSubmit.submit();
}

</script>
</body>
</html>