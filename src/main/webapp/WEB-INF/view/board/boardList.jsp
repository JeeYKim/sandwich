<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!-- 별모양 폰트 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="resources/file/js/jquery-2.0.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>불타는 샌드위치</title>
</head>
<style>
@import
	url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css')
	;

#diy_wrap {
	width: 1170px;
	margin-left: auto;
	margin-right: auto;
	font-family: PureunJeonnam;
}

#diy_wrap th {
	font-size: 15px;
	font-family: PureunJeonnam;
	text-align: center;
	background: #f5f5f5;
}

#diy_wrap table {
	font-size: 15px;
	font-family: PureunJeonnam;
	text-align: center;
	font-weight: bold;
}

a {
	text-decoration: none;
	color: black;
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


<body>
	<div id="diy_wrap">
		<table class="table">
			<colgroup>

				<col width="10%" />
				<col width="60%" />
				<col width="10%" />
				<col width="10%" />
			</colgroup>
			<div>
				<h3 style="padding-left: 20px; text-align: left;">
					<span style="color: black; font-size: 30px; font-weight: bold;"><a
						href="memberDiyBoardList.jy">Q & A 게시판</a></span> 
						<span style="font-size: 15px; color: #777; font-weight: bold;">
						궁금한 사항 남겨주세요!</span>
				</h3>
			</div>

			<div>
				<hr color="#777" width="100%" size="1">
			</div>

			<tr>
				<th>번호</th>
				<th style="text-align: left;">제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:choose>
				<c:when test="${fn:length(boardList) le 0}">
					<tr>
						<td colspan="7" style="text-align: center;">등록된 게시글이 없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="board" items="${boardList}" varStatus="stat">
						<tr>
							<td style="vertical-align: middle;">${board.boardNo}</td>
							
							<td style="vertical-align: middle; text-align: left;">
								<a href='<c:url value="/boardView.jy?boardNo=${board.boardNo}"/>'>
							 ${board.boardTitle}</a><span
								style="color: red;">&nbsp;</span></td>
							
							<td style="vertical-align: middle;">${board.boardWriter}</td>
							
							<td style="vertical-align: middle;"><fmt:formatDate
									value="${board.boardRegdate}" pattern="YYYY.MM.dd" /></td>
								<p style="color: #fdd66e; font-size: 17px;">
									
								</p>


							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</table>
		<c:choose>
			<c:when test="${sessionScope.boardWriter != 0}">
				<div style="float:right; color:#ffffff; background-color: #000; font-family:맑은고딕;">
						<button type="button" onclick="goWrite()" class="btn btn-primary" id="resister" 
						style="float:right; color:#ffffff; background-color: #000; font-family:맑은고딕;">등록하기</button>
				</div>
			</c:when>
		</c:choose>
		


		<div class="paging" style="clear: both;">
			<!-- 페이징 관련 -->
			${pagingHtml}
		</div>


		<div class="admin_search">

			<div
				style="text-align: center; width: 500px; margin-left: auto; margin-right: auto; margin-top: 20px; padding-bottom: 70px;">
				<div id="dataTables-example_filter" class="dataTables_filter">
					<form action="/sandwich/boardList.jy">
						<select class="form-control" name="searchNum" id="searchNum"
							style="width: 100px; float: left; margin-right: 8px;">
							<option value="0">작성자</option>
							<option value="1">제목</option>
						</select> <input class="form-control" type="text" name="isSearch"
							id="isSearch" style="width: 300px; float: left;"
							placeholder="키워드를 입력해 주세요 " /> <span>
							<button type="submit" class="btn btn-primary"
								style="float: left; color:#ffffff; background-color: #000; font-family:맑은고딕;">검색</button>
						</span>
					</form>
				</div>
			</div>

		</div>
	</div>
<script>
function goWrite() {
	location.href = '<c:url value="/boardWriteForm.jy"/>';
}
</script>