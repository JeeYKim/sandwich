<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<style>
.title_font1 {font-family: PureunJeonnam; font-size: 40px; font-weight: bold;}
</style>

<center>
	<div class="title_font1">
		1:1게시판
	</div>

<form action="<c:url value="/boardSave.jy"/>" method="post" enctype="multipart/form-data" >
	<input type="hidden" value="${board.boardNo}" name="boardNo">
	
	
  
	<div class="form-group">
		<label for="boardTitle">Q & A 제목</label>
    		<input type="text" class="form-control" id="boardTitle" name="boardTitle" value="${board.boardTitle}" placeholder="글 제목을 입력해주세요" style="width:700px">
  	</div>
  	

	<div class="form-group">
		<label for="boardContent">Q & A 내용</label>
  		<textarea class="form-control" id="boardContent" name="boardContent"  rows="10" cols="50" placeholder="상세내용을 입력해주세요" style="width:700px">${board.boardContent}</textarea>
	</div>
  
	
  		<input type="submit" id="modify" class="btn btn-default" onclick="goList()" value="수정하기"/>
</form>
</center>

<script>
function goList() {
	location.href = '<c:url value="/boardList.jy"/>';
}
</script>