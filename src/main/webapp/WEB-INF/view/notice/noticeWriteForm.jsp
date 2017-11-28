<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<form action="<c:url value="/noticeSave.jy"/>" method="post" enctype="multipart/form-data" >
	
	<div class="form-group">
	    <label for="noticeTitle">공지사항 제목</label>
		<input type="text" class="form-control" id="noticeTitle" name="noticeTitle" 
	    		placeholder="글 제목을 입력해주세요" style="width:700px">
	</div>
	<div class="form-group">
		<label for="noticeContents">공지사항 상세내용</label>
		<textarea class="form-control" id="noticeContents" name="noticeContents" rows="10" cols="50" placeholder="상세내용을 입력해주세요" style="width:700px"></textarea>
	</div>
 
	<div class="form-group">
		<label for="nodticeFile">이미지 첨부</label>
		<input type="file" id="nodticeFile" name="nodticeFile">
		<p class="help-block">첨부할 이미지를 선택해주세요.</p>
	</div>
 
	<input type="submit" value="등록하기"/>
	<button type="button" onclick="goList()" class="btn btn-default">목록으로</button>
</form>
	

<script src="<c:url value="/resources/app/staff/notice.js"/>"></script>
<script>
	function goList() {
		location.href='<c:url value = "/noticeList.jy"/>';
	}
</script>