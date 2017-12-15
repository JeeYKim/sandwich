<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row" style="padding-left: 15px; width: 900px;">
		<h1 class="page-header">매출/비용/순이익 현황 차트</h1>
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
	<div>
		<input type="date" id="startDate" name="startDate"> ~ 
		<input type="date" id="endDate" name="endDate" >
		<input type="button" id="btn-view" value="조회">
	</div>

<script src="<c:url value="/resources/js/moment.js"/>"></script>	
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="<c:url value="/resources/js/money/moneyChart.js"/>"></script>	
