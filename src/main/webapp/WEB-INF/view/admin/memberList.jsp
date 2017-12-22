<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<head>
<script type="text/javascript">
function delchk(){
	if(confirm("삭제하시겠습니까?")){
		return true;
	} else {
		return false;
	}
}
</script>
<style type="text/css">
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
</head>

<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">회원목록</h1>
</div>
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
                         회원목록페이지 검색, 수정, 삭제 기능하는 페이지입니다.
        </div>
        <div class="panel-body">
			<div class="dataTable_wrapper">
				<div id="dataTables-example_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row" style="margin-bottom:5px;">
						<div class="col-sm-6">
						<a href="/sandwich/adminMember.jy"><button type="button" name="searchNum" id="searchNum" class="btn btn-outline btn-default">가입한회원</button></a>	
							<!-- <a href="/sandwich/adminMember.jy"><button type="button" class="btn btn-outline btn-default">전체</button></a> -->		
							</div>
							
						<div class="col-sm-6" style="text-align:right;">
							<div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">불타는샌드위치 회원수 : ${totalCount}</div>
						</div>
						
					</div>
					<div class="row">
						<div class="col-sm-12">
							<table
								class="table table-striped table-bordered table-hover dataTable no-footer"
								id="dataTables-example" role="grid"
								aria-describedby="dataTables-example_info">
								<thead>
									<tr role="row">
										<th style="width: 8%; text-align:center;">아이디</th>
										<th style="width: 7%; text-align:center;">이름</th>
										<th style="width: 7%; text-align:center;">등급</th>										
										<th style="width: 10%; text-align:center;">이메일</th>
										<th style="width: 13%; text-align:center;">관리</th>
									</tr>
								</thead>
								<tbody>
								
								<c:forEach var="memberList"  items="${member}" varStatus="stat">
								<%-- <c:url var="viewURL" value="adminMemberModifyForm.jy" >
									<c:param name="MEMBER_ID" value="${memberList.MEMBER_ID }" />
								</c:url> --%>			
								<c:url var="UpdateURL" value="/adminMemberModifyForm.jy" >
				             	<c:param name="MEMBER_ID" value="${memberList.MEMBER_ID}" />
				                </c:url>
			  	                <c:url var="DeleteURL" value="/adminMemberDelete.jy" >
				              	<c:param name="MEMBER_ID" value="${memberList.MEMBER_ID}" />
			                 	</c:url>
														
									<tr class="gradeA even" role="row">
										<td style="text-align:center;vertical-align:middle;">${memberList.MEMBER_ID}</td>
										<td style="text-align:center;vertical-align:middle;">${memberList.MEMBER_NAME}</td>
										<td style="text-align:center;vertical-align:middle;">
										       
			                           <c:choose>
            
                                        <c:when test="${(memberList.MEMBER_LEVEL)==0}">
         
                                          <span style="margin-left:5px;">               
                                          <img id="level" style="height:60px;" src="./resources/file/img/level/0.PNG"/>
                                          </span>
                                       </c:when>
            
                                       <c:when test="${(memberList.MEMBER_LEVEL)==1}">
            
                                          <span style="margin-left:3px;">
                                          <img id="level" style="height:60px;" src="./resources/file/img/level/1.PNG"/>
                                          </span> 
                                          </c:when>
            
                                      <c:when test="${(memberList.MEMBER_LEVEL)==2}">
            
                                          <span style="margin-left:5px;">
                                          <img id="level" style="height:60px;"src="./resources/file/img/level/2.PNG"/>
                                          </span>
                                      </c:when>
                               
                                    </c:choose>
										       
										<td style="text-align:center;vertical-align:middle;">${memberList.MEMBER_EMAIL}</td>
										<td style="text-align:center;vertical-align:middle;">
										
										<a href="${UpdateURL}"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Cog_font_awesome.svg/32px-Cog_font_awesome.svg.png"></a>&nbsp;&nbsp;
		                             	<a href="${DeleteURL}"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Trash_font_awesome.svg/32px-Trash_font_awesome.svg.png" onclick="delchk()"></a></td>	
		                             	
											
								</c:forEach>
								<!-- 회원이 없을때 -->
									<c:if test="${fn:length(member) le 0}">
										<tr><td colspan="9" style="text-align:center;">회원이 없습니다.</td></tr>
									</c:if> 
									
								</tbody>
							</table>
						</div>
					</div>
					<div class="paging">
						${pagingHtml}
					</div>
					<div class="row">
							<div style="text-align:center;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="">
								    <select class="form-control" name="searchNum" id="searchNum">
										<option value="0">아이디</option>
										<option value="1">이름</option>
										<option value="2">이메일</option>
									</select>
										<input class="form-control" type="text" name="isSearch" id="isSearch"/>
										<span>
										<button type="submit" class="btn btn-default">검색</button>
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
