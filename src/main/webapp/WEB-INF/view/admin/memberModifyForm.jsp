<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<head>
<script type="text/javascript">
/* function adjustlv(){
	var adjust = document.getElementById('adjust');
	console.log(adjust);
	var staff = document.getElementById('staff');
	console.log(staff);
	var customer = document.getElementById('customer');
	console.log(customer);
	console.log(staff.value);
	console.log(customer.value);
	
	
	
	
	
} */

function joinValidation(updateMember){

	
	if(updateMember.MEMBER_PW.value==""){
		alert("비밀번호를 입력해 주세요.");
		return false;
	}
	else if(updateMember.MEMBER_NAME.value==""){
		alert("이름을 입력해 주세요.");
		return false;
	}
	else if(updateMember.MEMBER_EMAIL.value==""){
		alert("이메일을 입력해 주세요.");
		return false;
	}
		alert("작성이 완료되었습니다.");
}

</script>
</head>

<!-- 메뉴 시작 -->

<div class="row" style="padding-left:15px;width:700px;">    
	<h1 class="page-header">회원수정</h1>
</div>

<div class="row" style="padding-left:15px;width:700px;">
	<div class="panel panel-default">
		<div class="panel-heading" >회원수정 페이지입니다.</div>
			<div class="panel-body">
				<form:form id="updateMember" name="updateMember" action="adminUpdateMember.jy" method="post" onsubmit="return joinValidation(this)">	
				<input type="hidden" id="MEMBER_ID" name="MEMBER_ID" value="${member.MEMBER_ID}">	
                        <div class="form-group">
                            <label>아이디</label>                            
                            <input type="text" class="form-control" value="${member.MEMBER_ID}" style="width:initial;" readonly/>                            
                        </div>
                       <%-- 
                        <div class="form-group">
                            <label>비밀번호</label>
                            <input type="password" class="form-control" id="MEMBER_PASSWORD" name="MEMBER_PASSWORD" value="${member.MEMBER_PW}" style="width:initial;"/>
                        </div> --%>
                        <div class="form-group">
                            <label>이름</label>
                            <input type="text" class="form-control" id="MEMBER_NAME" name="MEMBER_NAME" value="${member.MEMBER_NAME}" style="width:100px;"/>
                        </div>
                        <div class="form-group" style="width:100px" >
                            <label>등급</label>
                            <select class="level" name="MEMBER_LEVEL" style="width:100px" >
                            <option value=0 <c:if test="${member.MEMBER_LEVEL == 0}">selected</c:if>>소비자</option>
                            <option value=1 <c:if test="${member.MEMBER_LEVEL == 1}">selected</c:if>>직원</option>
							</select>
                           
                        </div>
                        <div class="form-group">
                            <label>이메일</label>
                            <input type="text" class="form-control" id="MEMBER_EMAIL" name="MEMBER_EMAIL" value="${member.MEMBER_EMAIL}" style="width:250px;" />
                        </div>
						<button type="submit" class="btn btn-success">회원수정</button>
						<a href="/sandwich/adminMember.jy"><button type="button" name="searchNum" id="searchNum" class="btn btn-outline btn-default">목록으로</button></a>		
						<p />
				</form:form>
			</div>
	</div>
</div>
