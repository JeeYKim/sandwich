<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

	<div class="NOTICE_resWrap">
	<h2>공지사항페이지입니다</h2>
	<h5>수정</h5>
	</div>
<form action="<c:url value="/noticeSave.jy"/>" method="post" enctype="multipart/form-data" >
	<input type="hidden" value="${notice.noticeFile}" name="orgNoticeFile"> 
	<input type="hidden" value="${notice.noticeNo}" name="noticeNo">
	
  
	<div class="form-group">
		<label for="noticeTitle">공지사항&이벤트 제목</label>
    		<input type="text" class="form-control" id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle}" placeholder="글 제목을 입력해주세요" style="width:700px">
  	</div>
  	

	<div class="form-group">
		<label for="noticeContents">공지사항&이벤트 상세내용</label>
  		<textarea class="form-control" id="noticeContents" name="noticeContents"  rows="10" cols="50" placeholder="상세내용을 입력해주세요" style="width:700px">${notice.noticeContents}</textarea>
	</div>
  
	<div class="form-group"> 
		<img style="width:350px;height:250px;" src="<c:url value = "/upload/notice/${notice.noticeFile}"/>">	
    		<label for="exampleInputFile">이미지 첨부</label>
    		<label for="exampleInputFile">기존 파일:${notice.noticeFile}</label>
    		<input type="file" id="exampleInputFile" name="noticeFile">
    		<p class="help-block">첨부할 이미지를 선택해주세요.</p>
	</div>

  		<input type="submit" id="modify" class="btn btn-default" value="수정하기"/>
  		<button type="button" id="list"class="btn btn-default">목록으로</button>
</form>