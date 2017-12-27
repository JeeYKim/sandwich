<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매출 현황</title>
</head>
<body>
	<div class="row" style="padding-left: 15px; width: 900px;">
		<h1 class="page-header">매입/매출 현황</h1>
	</div>
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="dataTable_wrapper">
					<div id="dataTables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">
						
						<div class="row">
							<div class="col-sm-12">
								<form action="MoneyList.jy">
									<table
										class="table table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dataTables-example_info">
										 
										 
										 
										<tr role="row" style="vertical-align: middle;">
										
											<th colspan="4" style="text-align: center; vertical-align: middle;">기간을 선택해 주세요</th>
										</tr>
										<tr role="row" style="vertical-align: middle;">
										   
											<th style="width: 15%; text-align: center; vertical-align: middle;">시작날짜</th>
											<th style="width: 35%; text-align: center; vertical-align: middle;">
												<input type="date" id="DATE1" name="DATE1"></th>
											<th style="width: 15%; text-align: center; vertical-align: middle;">종료날짜</th>
											<th style="width: 35%; text-align: center; vertical-align: middle;">
												<input type="date" id="DATE2" name="DATE2"></th>
										</tr>
									</table>
									<button type="submit" style="float:right; color:#ededed; background:#2A3F54;" class="btn">조회하기</button>
									   
								</form>    
								   
								<table   
									class="table table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dataTables-example_info">
									<thead>      
									    
										 <tr role="row" style="vertical-align: middle;">
										 	<c:if test="${!empty DATE1}">
											<th colspan="3" style="text-align: center; vertical-align: middle;">${DATE1.DATE1}~${DATE1.DATE2} 기간의 현황입니다.</th>
											</c:if>
											<c:if test="${empty DATE1}">
											<th colspan="3" style="text-align: center; vertical-align: middle;">모든 기간의 현황입니다.</th>
											</c:if>
										</tr>
										   
										<tr role="row" style="vertical-align: middle;">
											<th style="width: 5%; text-align: center; vertical-align: middle;">계산</th>
											<th style="width: 35%; text-align: center; vertical-align: middle;">항목</th>
											<th style="width: 65%; text-align: center; vertical-align: middle;">금액</th>
										</tr> 
										   
										<tr role="row" style="vertical-align: middle;">
											
											<th colspan="3" style="text-align: center; vertical-align: middle;background:#ededed; color:#2A3F54;;">자산</th>
											
										</tr>  
										
										<tr role="row" style="vertical-align: middle;">
											<td style="text-align: center; vertical-align: middle;">+</td>
											<td style="text-align: center; vertical-align: middle;">매출(주문)</td>
											<td style="text-align: center; vertical-align: middle;">
											<c:if test="${empty moneyList[0].AA}">
												<fmt:formatNumber value="0"/>
											</c:if>
											<c:if test="${!empty moneyList[0].AA}">
												<fmt:formatNumber value="${moneyList[0].AA}" pattern="#,###"/>
											</c:if>
											</td>
										</tr>
										
										<tr role="row" style="vertical-align: middle;">
											<th colspan="3" style= "text-align: center; vertical-align: middle; background:#ededed; color:#2A3F54; ">비용</th>
										</tr>
										
										<tr role="row" style="vertical-align: middle;">
											<td rowspan="4" style="text-align: center; vertical-align: middle;">-</td>
											<td style="text-align: center; vertical-align: middle;">매입(발주)</td>
											<td style="text-align: center; vertical-align: middle;">
											<c:if test="${empty moneyList[1].AA}">
												<fmt:formatNumber value="0"/>
											</c:if>
											<c:if test="${!empty moneyList[1].AA}">
												<fmt:formatNumber value="${moneyList[1].AA}" pattern="#,###"/>
											</c:if>	
											</td>
										</tr>
										
										<tr role="row" style="vertical-align: middle;">
											
											<td style="text-align: center; vertical-align: middle;">직원 급여</td>
											<td style="text-align: center; vertical-align: middle;">
											<c:if test="${empty moneyList[2].AA}">
												<fmt:formatNumber value="0"/>
											</c:if>
											<c:if test="${!empty moneyList[2].AA}">
												<fmt:formatNumber value="${moneyList[2].AA}" pattern="#,###"/>
											</c:if>
											</td>
										</tr>
										<tr role="row" style="vertical-align: middle;">
											
											<td style="text-align: center; vertical-align: middle;">기타 비용</td>   
											<td style="text-align: center; vertical-align: middle;">
											<c:if test="${empty moneyList[3].AA}">
												<fmt:formatNumber value="0"/>
											</c:if>
											<c:if test="${!empty moneyList[3].AA}">
												<fmt:formatNumber value="${moneyList[3].AA}" pattern="#,###"/>
											</c:if>
											</td>
										</tr>
										<tr role="row" style="vertical-align: middle;">
											
											<td style="text-align: center; vertical-align: middle;">폐기 비용</td>
											<td style="text-align: center; vertical-align: middle;">
											<c:if test="${empty moneyList[4].AA}">
												<fmt:formatNumber value="0"/>
											</c:if>
											<c:if test="${!empty moneyList[4].AA}">
												<fmt:formatNumber value="${moneyList[4].AA}" pattern="#,###"/>
											</c:if>
											</td>
										</tr>
										
										<tr role="row" style="vertical-align: middle;">
											<th colspan="3" style= "text-align: center; vertical-align: middle; background:#ededed; color:#2A3F54;">자본(자산-비용)</th>
										</tr>
										
										<tr role="row" style="vertical-align: middle;">
											<td style="text-align: center; vertical-align: middle;">=</td>
											<td style="text-align: center; vertical-align: middle;">순이익</td>
											<c:if test="${moneyList[0].AA-moneyList[1].AA-moneyList[2].AA-moneyList[3].AA-moneyList[4].AA lt 0}">
											<td style="text-align: center; vertical-align: middle; background:#ffb8b8;"><fmt:formatNumber value="${moneyList[0].AA-moneyList[1].AA-moneyList[2].AA-moneyList[3].AA-moneyList[4].AA}" pattern="#,###"/></td>
											</c:if>
											<c:if test="${moneyList[0].AA-moneyList[1].AA-moneyList[2].AA-moneyList[3].AA-moneyList[4].AA ge 0}">
											<td style="text-align: center; vertical-align: middle;background:#87c2ff;"><fmt:formatNumber value="${moneyList[0].AA-moneyList[1].AA-moneyList[2].AA-moneyList[3].AA-moneyList[4].AA}" pattern="#,###"/></td>
											</c:if>
										</tr> 
										
									</tbody>
								</table>

							</div>

							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
</body>
</html>