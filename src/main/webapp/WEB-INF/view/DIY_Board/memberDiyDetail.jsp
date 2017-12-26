<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"><!-- 별모양 폰트 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#diy_wrap{
   width:1100px;
   margin-left:auto;
   margin-right:auto;
   margin-top:25px;
   font-family:PureunJeonnam;
   height:auto;
}
#diy_wrap table{
   text-align:center;
   line-height:20px;
}

#diy_wrap th{
   line-height:40px;
}
#diy_wrap td{
   text-align:left;
   line-height:40px;
   padding-left:20px;
}
#cmt a{
   color:#fdd66e;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script> 
<script src="resources/js/common.js"></script>
<script>
var rate=0;

$(document).ready(function(){
   
   
   

    $("#resister").click(function ajax(){ 
       
       
       var src =document.getElementById("commentContents");
       
       
       
       var commentStr = $("#commentContents").val();
       var commentNo = $("#commentDiyNo").val();
       var commentRate = rate;
       var comtUrl = "memberDiyComment.jy"
       
       $.ajax({url: "memberDiyComment.jy",  
         type : "POST", 
         data : { 
            str : commentStr,
            no : commentNo,
            rate : commentRate
         },
         success: function(result){ 
            $("#commentContents").val("");
            $("#commentList").html(result); 
         },
         error: function(result){ 
            alert("실패"); 
         }         
       });
   }); 
});


$( document ).ready(function() {

   $( ".star a" ).click(function() {
       $(this).parent().children("a").removeClass("on");
       $(this).addClass("on").prevAll("a").addClass("on");
       
       rate = $(this).attr("id");

       return false;
   });
});

$(document).ready(function () {
   //btn클릭 이벤트 처리
   $("#list").click(function () {
      document.location.href="memberDiyBoardList.jy";   
   });
   //페이지 로드시 버튼 클릭
   
   $("#modify").on("click", function(e){ //목록으로 버튼
      e.preventDefault();
      fn_openDiyBoardModify();
   });   
   
   $("#delete").on("click", function(e){ //목록으로 버튼
      e.preventDefault();
      fn_openDiyBoardDelete();
   });   
   
});

function fn_openDiyBoardModify(){
   var comSubmit = new ComSubmit('frm');
   comSubmit.setUrl('/sandwich/memberDiyBoardModifyForm.jy');
   comSubmit.submit();
}

function fn_openDiyBoardDelete(){
   var comSubmit = new ComSubmit('frm');
   comSubmit.setUrl('/sandwich/memberDiyBoardDelete.jy');
   comSubmit.submit();
}

</script>
</head>
<body>
<div id="diy_wrap">
<div style="border: 2px solid #CCC; margin-bottom:30px;">
<table class="table">
<colgroup>
   <col width="15%"/>
   <col width="35%"/>
   <col width="15%"/>
   <col width="35%"/>
</colgroup>

   <tr>
      <th colspan="4" style="font-family:PureunJeonnam; background:#f5f5f5; font-size:20px;">${diy.DIY_TITLE }</th>
        </tr>

   <tr>
      <th style="background:#f5f5f5; text-align:center;">작성자</th>
      <td>${diy.DIY_MEMBER_ID}</td>
      <th style="background:#f5f5f5; text-align:center;">작성일</th>
      <td>${diy.DIY_REGDATE}</td>
   </tr>
   
   <tr>
   		<th style="background:#f5f5f5; text-align:center;" >빵</th>
      <td colspan="3">${diy.DIY_BREAD}</td>
   </tr>
   <tr>
 	  <th style="background:#f5f5f5; text-align:center;">야채</th>
      <td colspan="3">${diy.DIY_VEGETABLE}</td>
   </tr>
   <tr>
 	  <th style="background:#f5f5f5; text-align:center;">소세지</th>
      <td colspan="3">${diy.DIY_SAUSAGE}</td>
   </tr>	  
   <tr>
  		 <th style="background:#f5f5f5; text-align:center;">치즈</th>
      <td colspan="3">${diy.DIY_CHEESE}</td>
   </tr>
   <tr>
 	  <th style="background:#f5f5f5; text-align:center;">소스</th>
      <td colspan="3">${diy.DIY_SAUCE}</td>
   </tr>
   
   <tr>
      
      <th colspan="4">
      <c:if test="${!empty diy.DIY_IMAGE}">
      <img src="resources/file/${diy.DIY_IMAGE}" class="img-rounded" style="width:500px; margin-left:300px; height:350px; both:clear; float:left;">
      </c:if>
      <span style="clear:both; float:left;margin-left:40px;">${diy.DIY_CONTENT }</span>
      
      </th>
   </tr>
   <tr>
   </tr>
</table>
</div>
 <div>
   <input type="button" value="목록으로" class="btn btn-primary" id="list" style="float:right; background:#2d2d2b; width:80px; margin-right:10px;">
</div>

<c:if test="${sessionScope.MEMBER_ID == diy.DIY_MEMBER_ID}">
<div style="margin-bottom:50px;">
   <input type="button" value="삭제" class="btn btn-primary" id="delete" style="float:right;margin-bottom:20px; margin-left:10px;background:#2d2d2b; width:80px; margin-right:10px;">
   <input type="button" value="수정" class="btn btn-primary" id="modify" style="float:right;margin-bottom:20px; background:#2d2d2b; width:80px;">
   <form    name="frm" id="frm">
   <input type="hidden" name="DIY_NO" value="${diy.DIY_NO}">
   <input type="hidden" name="DIY_IMAGE" value="${diy.DIY_IMAGE}">
   </form>
</div>
</c:if> 


<div id="cmt" style="margin-left:auto; margin-right:auto;">
<div style="width:100%;">
<c:if test="${sessionScope.MEMBER_ID == null }">
<p align="left">로그인 후 이용이 가능합니다.</p>
</c:if>
</div>

<div style="width:100%;">
<c:if test="${sessionScope.MEMBER_ID != null }">
<p align="left" style="font-family:PureunJeonnam; font-weight:bold; margin-left:15px;">후기글에 대한 댓글을 적어주세요!</p>
<input type="hidden" id="commentDiyNo" name="DIY_NO" value="${diy.DIY_NO}"/>
<p class="star" id="star" align="left" style="color:#fdd66e;margin-left:15px;">
    <a href="#" id="1"><i class="fa fa-star" aria-hidden="true"></i></a>
    <a href="#" id="2"><i class="fa fa-star" aria-hidden="true"></i></a>
    <a href="#" id="3"><i class="fa fa-star" aria-hidden="true"></i></a>
    <a href="#" id="4"><i class="fa fa-star" aria-hidden="true"></i></a>
    <a href="#" id="5"><i class="fa fa-star" aria-hidden="true"></i></a>
</p>
</c:if>
</div>
<c:if test="${sessionScope.MEMBER_ID != null }">
<div style="width:1000px; margin-left:auto; margin-right:auto;margin-bottom:20px;">

   <div style="width:80%; float:left;  padding-bottom:20px;">
      <textarea id="commentContents" class="form-control" rows="2"></textarea>
   </div>
   <div style="width:20%; float:left;">
      <button type="button" id="resister" class="btn btn-warning btn-lg btn-block" style="padding-top:10px;margin-left:10px; padding-bottom:10px; background:#2d2d2b; height:55px;">댓글작성</button>   
   </div>   
</div>
</c:if>
</div>
<div id="commentList" style="width:1100px; margin-top:30px;padding-left:auto; margin-right:auto;"><jsp:include page="memberDiyComment.jsp"></jsp:include></div>



</div> 
</body>
</html>