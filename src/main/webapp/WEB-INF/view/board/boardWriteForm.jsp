<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>   

<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="resources/file/js/common.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#qna_wrap{
   width:850px;
   margin-left:auto;
   margin-right:auto;
   font-family:PureunJeonnam;
   height:600px;
}


.qna_line {margin: 0 50px 0 50px;}
</style>


<div id="qna_wrap"style="border:2px Solid #CCCCCC ;">
<div>
<h3 style="text-align:center;">
<span style="color:black; font-size:30px; font-weight:bold;">불타는 샌드위치에게 묻는다</span> 
</h3>
</div>

<div class="qna_line">
   <hr color="#777" width="100%" size="1">
</div>

<form action="<c:url value="/boardSave.jy"/>" method="post" onsubmit="return validateForm();">
   

<div style="margin-left:35px;">
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">문의 제목</div>
<input type="text" class="form-control" id="boardTitle" name="boardTitle" value= "" style="width:480px; margin-right:20px;">
</div>

<div style="margin-left:35px;">
<div style="font-family:PureunJeonnam; width:500px; font-weight:bold; margin-bottom:10px; margin-top:10px;">문의 내용</div>
<textarea class="form-control" name="boardContent" id="boardContent" rows="10" cols="50" style="width:85%; float:left;" ></textarea>
</div>
<div style="float:left; margin-top:20px;width:100%;margin-left:35px;" >

<button type="button" id="list" class="btn btn-info" style="margin-left:62%; color: #fff; background-color: #000;">목록으로</button>
<button type="submit" id="resister" class="btn btn-info" style="color: #fff; background-color: #000;">등록하기</button>
</div>

</form>
<div>

   
</div>
</div>

<script>
function validateForm() {
	var content = $("#boardContent").val();
	var title = $("#boardTitle").val();
	
	if (title.length == 0){
		alert ("제목을 입력하세요"); 
		return false;
	} 
	
	if (content.length == 0) {
		alert ("내용을 입력하세요");
		return false;
	}
	
	return true;
		
}
</script>


