<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기타 비용</title>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/common.js"></script>
<link href="resources/css/ui.css" rel="stylesheet">

<script type="text/javascript">   
$(document).ready(function(){
	$("#insert").on("click", function(e){ //작성하기 버튼
		e.preventDefault();
		 if($('#COST_TITLE').val()==""){
			alert("지출항목을 입력해 주세요.");
			return false;
		 } else if($('#ECT_COST').val()==""){
			 alert("지출 금액을 입력해 주세요")
		 
		 } else if($('#COST_DATE').val()==""){
			 alert("지출 일자를 입력해 주세요.");
				return false;
		 }else{
		fn_insertCost();
		}
	});
	
});

function fn_insertCost(){
	var comSubmit = new ComSubmit("frm");
	comSubmit.setUrl('/sandwich/costInsert.jy');
	comSubmit.submit();
}

</script>
<script type="text/javascript">
function delchk(){
    return confirm("삭제하시겠습니까?");
}
</script>
<style type="text/css">
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

</head>
<body>

<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">기타 비용</h1>
</div>
<div class="row">
	<div class="panel panel-default">
        <div class="panel-body">
			<div class="dataTable_wrapper">
				<div id="dataTables-example_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap no-footer">
						<form id="frm" name="frm" method="post"	enctype="multipart/form-data">
							<input type="hidden" id="MEMBER_ID" name="MEMBER_ID" value="${MEMBER_ID}">
							<table class="board_view" style="width:100%">
								
								<tbody>
									<tr>
										<th scope="row">항목</th>
										<td><input type="text" name="COST_TITLE" id="COST_TITLE" class="wdp_90"></td>
										
										<th scope="row">금액</th>
										<td><input type="text" name="ECT_COST" id="ECT_COST" class="wdp_90"></td>
										
										<th scope="row">지출날짜</th>
										<td><input type="date" name="COST_DATE" id="COST_DATE" class="wdp_90"></td>
									</tr>
								</tbody>
							</table>
							<br><br>
							<a href="#this" class="btn" id="insert" style="float:right">지출</a>
						</form>
						<div class="row">
						<div class="col-sm-12">
							<table class="table table-bordered table-hover dataTable no-footer"
								id="dataTables-example" role="grid"	aria-describedby="dataTables-example_info">
								<thead>
									<tr role="row" style="vertical-align:middle;">
										<th style="width: 5%; text-align:center;vertical-align:middle;">번호</th>
										<th style="width: 25%; text-align:center;vertical-align:middle;">항목</th>
										<th style="width: 15%; text-align:center;vertical-align:middle;">작성자</th>
										<th style="width: 20%; text-align:center;vertical-align:middle;">금액</th>
										<th style="width: 20%; text-align:center;vertical-align:middle;">지출 날짜</th>									
										<th style="width: 15%; text-align:center;vertical-align:middle;">관리</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="cost"  items="${cost}" varStatus="stat">
							 		<c:url var="CostDelete" value="/costDelete.jy" >
									<c:param name="COST_NO" value="${cost.COST_NO}" />
								</c:url> 
																	
									<tr class="gradeA even" role="row">
										<td style="text-align:center;vertical-align:middle;">${cost.COST_NO}</td>
										<td style="text-align:center;vertical-align:middle;">${cost.COST_TITLE}</td>
										<td style="text-align:center;vertical-align:middle;">${cost.MEMBER_ID}</td>				
										<td style="text-align:center;vertical-align:middle;"><fmt:formatNumber value="${cost.ECT_COST}" type="number"/>원</td>							
										<td style="text-align:center;vertical-align:middle;"><fmt:formatDate value="${cost.COST_DATE}" pattern="YY.MM.dd" /></td>								
										<td style="text-align:center;vertical-align:middle;">
										
										 <a href="${CostDelete}"><input type="image" src="resources/images/delete.png" onclick="return delchk()"></a></td>									
									 </tr>
								</c:forEach>
								<!--  등록된 상품이 없을때 -->
									<c:if test="${cost}==0">
										<tr><td colspan="11" style="text-align:center;">기타비용의 지출이 없습니다.</td></tr>
									</c:if> 
								</tbody>
							</table>
						</div>
					</div>
					<div class="paging">
						${pagingHtml}
					</div>
				<!-- 	<div class="row">
							<div style="text-align:center;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="">
									<select class="form-control" name="searchNum" id="searchNum">
										<option value="0">항목</option>
										<option value="1">작성자</option>
										<option value="2">지출 날짜</option>
									</select>
										<input class="form-control" type="text" name="isSearch" id="isSearch"/>
										<span>
										<button type="submit" class="btn btn-primary">검색</button>
										</span>
									</form>
								</div>							
							</div>
							
					</div> -->
				</div>
			</div>
			<!-- /.table-responsive -->							
		</div>
	</div>
        <!-- /.panel -->   
</div>
</body>
</html>