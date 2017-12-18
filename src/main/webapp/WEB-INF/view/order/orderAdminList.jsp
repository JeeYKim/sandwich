<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   



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

<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">발주 목록</h1>
</div>
<div class="row">
	<div class="panel panel-default">
        <div class="panel-body">
			<div class="dataTable_wrapper">
				<div id="dataTables-example_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row" style="margin-bottom:5px;">
						
					</div>
					
					<div class="row">
						<div class="col-sm-12">
							<table class="table table-bordered table-hover dataTable no-footer"
								id="dataTables-example" role="grid"	aria-describedby="dataTables-example_info">
								<thead>
									<tr role="row" style="vertical-align:middle;">
										<th style="width: 2%; text-align:center;vertical-align:middle;">발주번호</th>
										<th style="width: 5%; text-align:center;vertical-align:middle;">카테고리</th>
										<th style="width: 10%; text-align:center;vertical-align:middle;">재료명</th>
										<th style="width: 6%; text-align:center;vertical-align:middle;">수량</th>
										<th style="width: 7%; text-align:center;vertical-align:middle;">가격</th>
										<th style="width: 12%; text-align:center;vertical-align:middle;">발주날짜</th>	
										<th style="width: 5%; text-align:center;vertical-align:middle;">총금액</th>
										<th style="width: 12%; text-align:center;vertical-align:middle;">관리</th>									
									</tr>
								</thead>
								
								<c:forEach var="order"  items="${orderList}" varStatus="stat">
							 	
							 	<%-- <c:url var="orderModifyForm" value="/orderModifyForm.jy" >
									<c:param name="orderNo" value="${order.orderNo}" />
								</c:url>
								
								<c:url var="orderDelete" value="/orderDelete.jy" >
									<c:param name="orderNo" value="${order.orderNo}" />
								</c:url>  --%>
								<tbody>
									<tr class="gradeA even" role="row">
										<td style="text-align:center;vertical-align:middle;">${order.orderNo}</td>										
										
										<td style="text-align:center;vertical-align:middle;">${order.orderBigtype}</td>
										<td style="text-align:center;vertical-align:middle;">${order.orderSmalltype}</td>
										<td style="text-align:center;vertical-align:middle;">${order.orderAmount}개</td>
										
										<td style="text-align:center;vertical-align:middle;">
										<fmt:formatNumber value="${order.orderPrice}" type="number"/>원</td>							
										
										<td style="text-align:center;vertical-align:middle;">
										<fmt:formatDate value="${order.orderOrderdate}" pattern="yyyy-MM-dd" /></td>			
										
										<td style="text-align:center;vertical-align:middle;">
										<fmt:formatNumber value="${order.totalPrice}" type="number"/>원</td>
										
										<td style="text-align:center;vertical-align:middle;"> 
										<c:choose>
											<c:when test="${order.orderYes == 0}"> 
												<button type="button" onclick="goApproval(${order.orderNo})" class="btn btn-primary" id="resister">승인</button>
												<button type="button" onclick="goNoapproval(${order.orderNo})" class="btn btn-primary" id="resister">비승인</button>
											</c:when>
											
											<c:when test="${order.orderYes == 1}">
												<span>승인</span> 
											</c:when>
											
											<c:when test="${order.orderYes == 2}">
												<span>비승인</span>
											</c:when>
										</c:choose>
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
		</div>
	</div>
</div>

<script>
	function goApproval(orderNo) {
		location.href = '<c:url value="/orderApproval.jy"/>'+"?orderNo="+orderNo;
	}
	
	function goNoapproval(orderNo) {
		location.href = '<c:url value="/orderNoapproval.jy"/>'+"?orderNo="+orderNo;
	}
</script>
