<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>tab example</title>
<!-- <style>
 #goodsBasket {
	float:right
}
#ingreInfo{
	float:left
} 
</style> -->
<link rel="stylesheet" type="text/css"	href="/sandwich/resources/css/DIY.css?ver=1" />
<script src="http://code.jquery.com/jquery-latest.min.js">
	
</script>
<script>


	function addIngre(img) {
		var no = img.getAttribute("id");
		
		
		$.ajax({
			url : "addIngre.jy",
			type : "POST",
			data : {
				no : no
			},
			success : function(result) {
				$("#goodsBasket").html(result);
				calculate();
			},
			error : function(result) {
				alert("실패");
			}

		});
	}

	function delIngre(test) {
		var no = test.getAttribute("id");
		console.log("인덱스 : "+no);

		$.ajax({
			url : "delIngre.jy",
			type : "POST",
			data : {
				no : no
			},
			success : function(result) { 
				$("#goodsBasket").html(result); 
				calculate();
				
			},
			error : function(result) {
				alert("삭제실패");
			}   

		});
	}
	
	
</script>


</head>
<body style="height:100%;">
<div id="container">
<div id="content" class="main">
<section class="sec_recommend">
<div class="inner">
	<h2>원하는 재료를 선택하세요</h2>
	<p>원하는 재료를 선택해 나만의 샌드위치를 만들어 보세요</p>
	<form id="totalForm" method="POST">
<fieldset class="field1">
	 <ul class="big_sort">  
	 <li><a>대분류</a></li>
	</ul> 
	<ul class="small_sort">  

	<c:forEach var="all" items="${AllIngre}" varStatus="stat">
	<li>
		<a id="ingreInfo">
			<img src="resources/images/sandwich/${all.SANDWICH_THUMNAIL}" id="${all.NO}" onclick="addIngre(this)" alt="20">
	
				<strong>${all.SANDWICH_SMALLTYPE}<br>
				${all.SANDWICH_PRICE}원</strong>
		</a>
	</li>
	</c:forEach>
</ul>
</fieldset>
<fieldset class="field2">
<dl>
<dt>
<input type="text" id="totalPrice" name="totalPrice" value="0" style="height:30px;">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</dt>   
<dd>

		<jsp:include page="diy2.jsp"></jsp:include>

</dd>
</dl>
</fieldset>
</form>
</div>
</section>
</div>
</div>
</body>
</html>





































