<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<script src="<c:url value="/resources/app/staff/notice.js"/>"></script>


<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#notice_admin_wrap {
	font-family: PureunJeonnam;
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
.notice_line {margin: 0 50px 0 50px;}

.notice_admin_table td {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #f5f5f5;
}
.notice_admin_search{
	width:"50%";
	margin-right: auto;
	margin-left: auto;
}
.notice_admin_search input[type=text]{

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
.paging{text-align:center;height:32px;margin-top:5px;margin-bottom:15px;}
.paging a,
.paging strong{display:inline-block;width:36px;height:32px;line-height:28px;font-size:14px;border:1px solid #e0e0e0;margin-left:5px;
-webkit-border-radius:3px;
   -moz-border-radius:3px;
		border-radius:3px;
-webkit-box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
	-moz-box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
		  box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
}
.paging a:first-child{margin-left:0;}
.paging strong{color:#fff;background:#337AB7;border:1px solid #337AB7;}
.paging .page_arw{font-size:11px;line-height:30px;}

</style>

<div class="notice_admin_title">
<div class="title_font1"><a href="#" style="text-decoration: none;color:black;">공지사항 관리자페이지</a></div>
<div class="title_font2">공지사항</div>
</div>

<div class="notice_line">
<hr color="#777" width="100%" size="1">
</div>
<div class="row" style="font-family: PureunJeonnam;">
	<div class="panel panel-default">
		<div class="panel-heading">
                         [공지사항 페이지] 공지사항 게시글을 검색, 수정, 삭제 기능하는 페이지입니다.
        </div>
        <div class="panel-body">
			<div class="dataTable_wrapper">
				<div id="dataTables-example_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row" style="margin-bottom:5px;">
						<div class="col-sm-6">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<table
								class="table  table-bordered table-hover dataTable no-footer"
								id="dataTables-example" role="grid"aria-describedby="dataTables-example_info">
								<thead>
									<tr role="row" style="vertical-align:middle;">
										<th style="width: 5%; text-align:center;vertical-align:middle;">번호</th>
										<th style="width: 60%; text-align:center;vertical-align:middle;">제목</th>
										<th style="width: 10%; text-align:center;vertical-align:middle;">작성자</th>
										<th style="width: 15%; text-align:center;vertical-align:middle;">등록날짜</th>
										<th style="width: 15%; text-align:center;vertical-align:middle;">관리</th>
									</tr>
								</thead>
								<tbody>
				<c:choose>
                 <c:when test="${noticeList.size() le 0}">									
						<tr>
							<td colspan="6" style="text-align:center;">등록된 게시글이 없습니다</td>
						</tr>							
                 </c:when>
                 <c:otherwise>

   				 <c:forEach var="notice"  items="${noticeList}" varStatus="stat">
                 	<tr> 
                     	<td style="text-align:center;vertical-align:middle;">${notice.noticeNo}</td>
   						<td style="text-align:center;vertical-align:middle;">
                        		<a href='<c:url value="/noticeView.jy?noticeNo=${notice.noticeNo}"/>'>${notice.noticeTitle}</a>
                        	</td>
   						<td style="text-align:center;vertical-align:middle;">${notice.memberId}</td>
                        <td style="text-align:center;vertical-align:middle;">${notice.noticeRegdate}</td>
                        <td style="text-align:center;vertical-align:middle;">
                        
                        
                        <a href='<c:url value="/noticeModify.jy"/>'>
                        <span class="glyphicon glyphicon-cog" aria-hidden="true" style="font-size:30px;"></span></a>
                        <a href="">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"style="font-size:30px;"></span></a>
          				</td>
                    </tr>
                 </c:forEach> 
                 </c:otherwise> 
                </c:choose>  
								</tbody>
							</table>
						</div>
					</div>
					<div class="paging">
					</div>
					<div style="float:right;">
						<button type="button" 
							onclick="goWrite()"
							class="btn btn-primary" id="resister">등록하기</button>
					</div>
					<div class="row">
							<div style="text-align:center;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="">
									<select class="form-control" name="searchNum" id="searchNum">
										<option value="0">제목</option>
										<option value="1">내용</option>
									</select>
										<input class="form-control" type="text" name="isSearch" id="isSearch"/>
										<span>
										<button type="submit" class="btn btn-primary">검색</button>
										</span>
									</form>
								</div>							
							</div>
							
					</div>
				</div>
			</div>
			<!-- /.table-responsive -->							
		</div>
	</div>
        <!-- /.panel -->   
</div>

<script>
	function goWrite() {
		location.href = '<c:url value="/noticeWriteForm.jy"/>';
	}
</script>
