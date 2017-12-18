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
	<div class="title_font1"><a href="/SG/memberNoticeList" style="text-decoration: none;color:black; font-size:30px;">공지사항</a></div>
	<div class="title_font2">공지사항</div>
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
    <td colspan=3 style="background:white;">${notice.noticeTitle}</td>
</tr>
<tr>
	<td>작성자</td>
    <td colspan=3 style="background:white;">${notice.memberId}</td>
</tr>

<tr>
	<td>등록일</td>
    <td style="background:white;">${notice.noticeRegdate}</td>
</tr>

<tr>
	<td colspan=4 style="background:white;">
	<img style="width:350px;height:250px;" src="<c:url value = "/upload/notice/${notice.noticeFile}"/>"></td>
</tr>

<tr>
	<td colspan=4 style="background:white;">${notice.noticeContents}</td>
</tr> 
</table>
<input type="button" class="btn btn-primary" onclick="goList()" id="list" value="목록으로" style="float:right;">

</div>

<script>
	function goList() {
		
		location.href = '<c:url value="/memberNoticeList.jy"/>';
	}
</script>

