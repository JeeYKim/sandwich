<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script type="text/javascript"
	src="resources/file/js/jquery-2.0.0.min.js">
</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style type="text/css">
@import
	url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css')
	;

#faq_member_wrap {
	width: 1170px;
	font-family: PureunJeonnam;
	margin-left: auto;
	margin-right: auto;
}

.faq_member_title {
	color: #212121;
	padding-top: 50px;
}

.faq_member_title div {
	padding-bottom: 10px;
}

.title_font1 {
	font-family: PureunJeonnam;
	font-size: 30px;
	font-weight: bold;
}

.title_font2 {
	font-family: PureunJeonnam;
	font-size: 20px;
	color: #999;
}

.faq_member_table {
	text-align: center;
	font-family: PureunJeonnam;
	font-size: 15px;
	font-weight: bold;
}

.faq_member_table th {
	text-align: center;
	border-top: 1px solid #e5e5e5;
	border-bottom: 1px solid #e5e5e5;
	padding: 8px 0;
	font-size: 15px;
	background: #f5f5f5;
	font-family: PureunJeonnam;
}

.faq_member_table td {
	text-align: center;
	border-top: 1px solid #e5e5e5;
	border-bottom: 1px solid #e5e5e5;
	font-family: PureunJeonnam;
	line-height: 40px;
}

.faq_member_search {
	width: 60%;
	margin-right: auto;
	margin-left: auto;
	font-family: PureunJeonnam;
}

.faq_member_search input[type=text] {
	width: 300px;
	height: 25px;
}

.faq_member_searchT {
	text-align: center;
	border-top: 1px solid #e5e5e5;
	border-bottom: 1px solid #e5e5e5;
	padding: 8px 0;
	background: #f5f5f5;
}

.faq_select {
	height: 25px;
}

.category {
	float: right;
}

.category ul {
	margin-left: 10px;
	list-style-type: none;
}

.category ul li {
	color: black;
	float: left;
	margin-right: 20px;
	font-size: 20px;
	font-weight: bold;
	font-family: PureunJeonnam;
	line-height: 30px;
}

.category ul li a {
	text-decoration: none;
	color: black;
	font-family: PureunJeonnam;
}

.paging {
	text-align: center;
	height: 32px;
	margin-top: 5px;
	margin-bottom: 15px;
}

.paging a, .paging strong {
	display: inline-block;
	width: 36px;
	height: 32px;
	line-height: 28px;
	font-size: 14px;
	border: 1px solid #e0e0e0;
	margin-left: 5px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	-webkit-box-shadow: 1px 1px 1px 0px rgba(235, 235, 235, 1);
	-moz-box-shadow: 1px 1px 1px 0px rgba(235, 235, 235, 1);
	box-shadow: 1px 1px 1px 0px rgba(235, 235, 235, 1);
}

.paging a:first-child {
	margin-left: 0;
}

.paging strong {
	color: #fff;
	background: #337AB7;
	border: 1px solid #337AB7;
}

.paging .page_arw {
	font-size: 11px;
	line-height: 30px;
}
</style>

<script type="text/javascript">
$(document).ready(function () {
	//btn클릭 이벤트 처리
	$("#resister").click(function () {
		document.location.href="memberFaqForm";	
	});
	//페이지 로드시 버튼 클릭

});
</script>

	<div id="faq_member_wrap">
		<div class="faq_member_title">
			<div class="title_font1"> <a href="/sandwich/noticeList"
					style="text-decoration: none; color: black;">공지사항</a>
			</div>
			<div class="title_font2">공지사항</div>
			<div class="category">
				
			</div>


		</div>

		<div class="faq_line">
			<hr color="#777" width="100%" size="1">
		</div>

		<table class="faq_member_table" width="100%">
			<colgroup>
				<col width="7%" />
				<col width="40%" />
				<col width="13%" />
				<col width="15%" />
			</colgroup>
			<tr>
				<th>NO</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>등록일자</th>
			</tr>

			<c:choose>
				<c:when test="${fn:length(memberNoticeList) le 0}">
					<tr>
						<td colspan="6" style="text-align: center;">등록된 게시글이 없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>

					<c:forEach var="notice" items="${memberNoticeList}" varStatus="stat">
						<tr>
							<td>${stat.count}</td>
							

							<td>
							<a href='<c:url value="/memberNoticeView.jy?noticeNo=${notice.noticeNo}"/>'>${notice.noticeTitle}</a></td>
							<td>불타는운영자</td>
							<td>${notice.noticeRegdate}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</table>

		<div class="paging"
			style="text-align: center; both: clear; margin-top: 20px;">
			${pagingHtml}</div>
		<!-- <div class="member_search">

			<div
				style="text-align: center; width: 500px; margin-left: auto; margin-right: auto; margin-top: 20px; padding-bottom: 70px;">
				<div id="dataTables-example_filter" class="dataTables_filter">
					<form action="/SG/memberNoticeList">
						<select class="form-control" name="searchNum" id="searchNum"
							style="width: 100px; float: left; margin-right: 8px;">
							<option value="0">제목</option>
							<option value="1">내용</option>
						</select> <input class="form-control" type="text" name="isSearch"
							id="isSearch" style="width: 300px; float: left;" /> <span>
							<button type="submit" class="btn btn-primary"
								style="float: left;">검색</button>
						</span>
					</form>
				</div>
			</div>
		</div> -->

	</div>
</body>
</html>
