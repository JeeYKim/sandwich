<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row" style="padding-left: 15px; width: 900px;">
		<h1 class="page-header">매출/비용/순이익 현황 차트</h1>
	</div>
	<div>
		<table class="table table-bordered table-hover dataTable no-footer"
			role="grid" aria-describedby="dataTables-example_info">
			<!-- <tr role="row" style="vertical-align: middle;">
				<th colspan="4" style="text-align: center; vertical-align: middle;">기간을 선택해 주세요</th>
			</tr> -->
			<tr role="row" style="vertical-align: middle;">
										   
				<th style="width: 15%; text-align: center; vertical-align: middle;">시작날짜</th>
				<th style="width: 35%; text-align: center; vertical-align: middle;">
					<input type="date" id="startDate" name="startDate"></th>
				<th style="width: 15%; text-align: center; vertical-align: middle;">종료날짜</th>
				<th style="width: 35%; text-align: center; vertical-align: middle;">
					<input type="date" id="endDate" name="endDate"></th>
			</tr>
		</table>
			<button style="float:right; color:#ededed; background:#2A3F54;"id="btn-view" class="btn">조회하기</button>
	<br><br>
	</div>
	
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="dataTable_wrapper">
					<div id="dataTables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">

						<div class="row">
							<div class="col-sm-12">

								<div id="linechart_material" style="width: 900px; height: 500px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


<script src="<c:url value="/resources/js/moment.js"/>"></script>	
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="<c:url value="/resources/js/money/moneyChart.js"/>"></script>	
