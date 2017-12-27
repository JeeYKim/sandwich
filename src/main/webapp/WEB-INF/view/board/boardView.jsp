<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#notice_admin_wrap {
	width: 1170px;
	font-family: PureunJeonnam;
	margin-left:auto;
	margin-right:auto;
}
.notice_admin_title {text-align: left; color: #212121; padding-top: 50px;}
.notice_admin_title div {padding-bottom: 10px;}
.title_font1 {font-family: PureunJeonnam; font-size: 40px; font-weight: bold;}
.title_font2 {font-family: PureunJeonnam; font-size: 15px; font-weight: bold; color: #999;}
.notice_admin_table{
	text-align: center;
	font-family: PureunJeonnam;
	font-size:15px;
	font-weight:bold;	
}

.notice_admin_table td {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #f5f5f5;
}
.notice_admin_search{
	width: 60%;
	margin-right: auto;
	margin-left: auto;
}
.notice_admin_search input[type=text]{
	width: 300px;
	height: 25px;
}
.notice_admin_searchT {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #f5f5f5;
}
.notice_select{
	height: 25px;
}
.paging{text-align:center; padding-top: 20px;}
.paging a{text-decoration: none; color:black;}





</style>

<div id="notice_admin_wrap">
<div class="notice_admin_title">
	<div class="title_font1">
		1:1게시판
	</div>
</div>

<div class="notice_line">
	<hr color="#777" width="100%" size="1">
</div>

<table class="notice_admin_table" width="100%">
	<colgroup>
		<col width="15%" />
		<col width="35%"/>
		<col width="15%" />
		<col width="35%" />
	</colgroup>
<tr>
	<td>제목</td>
    <td colspan=3 style="background:white;">${board.boardTitle}</td>
</tr>
<tr>
	<td>작성자</td>
    <td colspan=3 style="background:white;">${board.boardWriter}</td>
</tr>
<tr>
	<td>등록일</td>
    <td style="background:white;">${board.boardRegdate}</td>
</tr>

<tr>
	<td>내용</td>
    <td colspan=3 style="background:white;">${board.boardContent}</td>
</tr>

</table>
<input type="button" class="btn btn-primary" onclick="goList()" id="list" value="목록으로" style="float:right; color: #fff; background-color: #000; font-family:맑은고딕;">
<input type="button" class="btn btn-primary" onclick="goModifyForm(${board.boardNo})" id="list" value="수정하기" style="float:right; color: #fff; background-color: #000; font-family:맑은고딕;">
<input type="button" class="btn btn-primary" onclick="goDelete(${board.boardNo})" id="list" value="삭제하기" style="float:right; color: #fff; background-color: #000; font-family:맑은고딕;">


<script>
function goList() {
	location.href = '<c:url value="/boardList.jy"/>';
}

function goModifyForm(boardNo) {
	location.href = '<c:url value="/boardModifyForm.jy?boardNo="/>'+boardNo;
	
}

function goDelete(boardNo) {
	if (confirm("정말 삭제하시겠습니까??") == true){ 
		location.href = '<c:url value="/boardDelete.jy?boardNo="/>'+boardNo;
	}
}
</script>

<!-- 관리자 댓글 달기  -->

<c:if test = "${sessionScope.MEMBER_ID eq 'staff'}">
	
	<form action="<c:url value="/boardSave.jy"/>" method="post" onsubmit="return validateForm();">
	
	<input type="hidden" name="parentNo" value="${board.boardNo}"/>
	<div style="margin-left:35px;">
	<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">답변 제목</div>
	<input type="text" class="form-control" id="boardTitle" name="boardTitle" value= "[답변]${board.boardTitle}" style="width:480px; margin-right:20px;">
	</div>
	
	<div style="margin-left:35px;">
	<div style="font-family:PureunJeonnam; width:500px; font-weight:bold; margin-bottom:10px; margin-top:10px;">답변 내용</div>
	<textarea class="form-control" name="boardContent" id="boardContent" rows="10" cols="50" style="width:85%; float:left;" ></textarea>
	</div>
	<div style="float:left; margin-top:20px;width:100%;margin-left:35px;" >
	
	<input type="submit" class="btn btn-primary" id="list" 
	value="등록" style="float:right; color:#ffffff; background-color: #000; font-family:맑은고딕;">
	</form>

</c:if>
</div>

<script>
function validateForm() {
	var content = $("#boardContent").val();
	var title = $("#boardTitle").val();
	
	if (title.length == 0){
		alert ("제목을 입력하세요"); 
		return false;
	} 
	
	if (content.length == 0) {
		alert ("내용을 입력하세요");
		return false;
	}
	
	return true;
		
}
</script> 

