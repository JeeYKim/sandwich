<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<form action="<c:url value="/noticeSave.jy"/>" method="post" enctype="multipart/form-data" 
	onsubmit="return validateForm();">
	
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
		<label for="noticeFile">이미지 첨부</label>
		<input type="file" id="noticeFile" name="noticeFile">
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
	
	function validateForm() {
		var title = $("#noticeTitle").val();
		var contents = $("#noticeContents").val();
		
		if( !(title.length > 0 && title.length <= 100) ) {
			alert("제목은 100자 이내로 입력해 주세요.");
			return false;
		}
		
		if( !(contents.length > 0 && contents.length <= 500) ) {
			alert("내용은 500자 이내로 입력해 주세요.");
			return false;
		}
		return true;
	}
</script>