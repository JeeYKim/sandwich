<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주문 목록</title>

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
	<h1 class="page-header">주문 목록</h1>
</div>
<div class="row">
	<div class="panel panel-default">
        <div class="panel-body">
			<div class="dataTable_wrapper">
				<div id="dataTables-example_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row" style="margin-bottom:5px;">
						<div class="col-sm-6" style="text-align:right;">
							
						</div>
						
					</div>
					<div class="row">
						<div class="col-sm-12">
							<table class="table table-bordered table-hover dataTable no-footer"
								id="dataTables-example" role="grid"	aria-describedby="dataTables-example_info">
								<thead>
									<tr role="row" style="vertical-align:middle;">
										<th style="width: 5%; text-align:center;vertical-align:middle;">구매번호</th>
										<th style="width: 8%; text-align:center;vertical-align:middle;">구매자ID</th>										
										<th style="width: 12%; text-align:center;vertical-align:middle;">구매날짜</th>		
										<th style="width: 12%; text-align:center;vertical-align:middle;">구매여부</th>									
										
									</tr>
								</thead>
								<tbody>
								<c:forEach var="list"  items="${list}" varStatus="stat">
																	
									<tr class="gradeA even" role="row">  
										<td style="text-align:center;vertical-align:middle;">
										<a href="purchaseView.jy?query=${list.PURCHASE_ID}&no=${list.PURCHASE_NO}">
										${list.PURCHASE_NO}</a></td>		
										<td style="text-align:center;vertical-align:middle;">${list.PURCHASE_ID}</td>
										<td style="text-align:center;vertical-align:middle;">${list.PURCHASE_ORDERDATE}</td>
										<td style="text-align:center;vertical-align:middle;">
										<c:if test="${list.PURCHASE_BASKET eq '0'}">장바구니</c:if>
										<c:if test="${list.PURCHASE_BASKET eq '1'}">구매완료</c:if>
										</td>
									 </tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="paging">
						${pagingHtml}
					</div>
				</div>
			</div>
			<!-- /.table-responsive -->							
		</div>
	</div>
        <!-- /.panel -->   
</div>
</body>
</html>