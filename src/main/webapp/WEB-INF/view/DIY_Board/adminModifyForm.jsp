<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

	<div class="NOTICE_resWrap">
	<h2>DIY페이지입니다</h2>
	<h5>수정</h5>
	</div>
<form action="<c:url value="/adminDiyBoardModify.jy"/>" method="post" enctype="multipart/form-data" >
	<input type="hidden" value="${diy.DIY_IMAGE}" name="DIY_IMAGE"> 
	<input type="hidden" value="${diy.DIY_NO}" name="DIY_NO">
	
  
	<div class="form-group">
		<label for="noticeTitle">DIY&추천게시판 제목</label>
    		<input type="text" class="form-control" id="DIY_TITLE" name="DIY_TITLE" value="${diy.DIY_TITLE}" placeholder="글 제목을 입력해주세요" style="width:700px">
  	</div>
  	

	<div class="form-group">
		<label for="noticeContents">DIY&추천게시판 상세내용</label>
  		<textarea class="form-control" id="DIY_CONTENT" name="DIY_CONTENT"  rows="10" cols="50" placeholder="상세내용을 입력해주세요" style="width:700px">${diy.DIY_CONTENT}</textarea>
	</div>
  
	<div class="form-group"> 
		<img style="width:350px;height:250px;" src="resources/file/${diy.DIY_IMAGE}"/>">	
    		<label for="exampleInputFile">이미지 첨부</label>
    		<label for="exampleInputFile">기존 파일:${diy.DIY_IMAGE}</label>
    		<input type="file" id="DIY_IMAGE" name="DIY_IMAGE">
    		<p class="help-block">첨부할 이미지를 선택해주세요.</p>
	</div>

  		<input type="submit" id="modify" class="btn btn-default" value="수정하기"/>
</form>
  		<button type="button" id="list"class="btn btn-default"><a href="<c:url value="/admindiyboardlist.jy"/>">목록으로</a></button>
