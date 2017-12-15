<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="./resources/css/main.min.css">
<link rel="stylesheet" href="./resources/css/joinForm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
    
  //비밀번호 일치 확인
  function checkpw()
  {
      var f = document.frm;
      var mem_id = f.MEMBER_ID.value;
      var mem_pw = f.MEMBER_PW.value;
      var mem_email1 = f.MEMBER_EMAIL1.value;
      var mem_email2 = f.MEMBER_EMAIL2.value;
      
      
      if(mem_pw != f.password_confirm.value)
      {
    	 alert("비밀번호가 일치하지 않습니다.");
    	 
    	 f.MEMBER_PW.value = "";
    	 f.password_confirm.value = "";
    	 
    	 return false;
      }
      
      else if(mem_pw == "" || f.password_confirm.value == "")
      {
    	  confirm("비밀번호를 입력해주세요.");
    	  
      }
      
      else
      {
    	 var update = 
    		 ({
    		   "MEMBER_ID":mem_id,	
    		   "MEMBER_PW":mem_pw,
    		   "MEMBER_EMAIL1":mem_email1,
    		   "MEMBER_EMAIL2":mem_email2, 		 
    		 });
   
    	 $.ajax
    	 ({
    		 type : "POST",
    		 url : "/sandwich/memberUpdateAction.jy",
    		 data : update,
    		 success : function(data)
    		 {
    			 confirm("회원정보가 수정되었습니다.");
    			 self.close();
    		 },
    		 
    		 error : function()
		     {
		    	 alert("수정이 되지 않았습니다." + e);
		     }
    	 });
    	 
      }
      return true;
      
    }
    </script>

  

</head>

<body>
<div class="body_center">
<form name="frm" method="post" >
<section class="input-horizontal list-horizontal section box-shadow">
            <div class="main_subject">
               <h2>회원정보 수정</h2>
            </div>

<ul class="section-body" style="list-style:none;">
   <li class="id">
      <div class="item-label col-lg-3 col-md-4">
         <label for="mi">
            <strong>아이디</strong>
         </label>
      </div>
      <div class="col-lg-21 col-md-20">
         <input type="text" name="MEMBER_ID" id="MEMBER_ID" value="${myInfo.MEMBER_ID}" class="xx-control" label="아이디" readOnly>
         
      
   </li>
   
   <li class="password">
      <div class="item-label col-lg-3 col-md-4">
         <label for="input-password">
            <strong>비밀번호</strong>
         </label>
      </div>
      <div class="col-lg-21 col-md-20">
         <input type="password" id="input-password" class="xx-control" value="" name="MEMBER_PW" required="required" label="비밀번호">
      </div>
   </li>
   <li class="password check">
      <div class="item-label col-lg-3 col-md-4">
         <label for="input-password-check">
            <strong>비밀번호 확인</strong>
         </label>
      </div>
      <div class="col-lg-21 col-md-20">
         <input type="password" id="input-password-check" class="xx-control" value="" name="password_confirm" label="비밀번호" onkeyup="checkPwd()" required="">
      </div>
   </li>
   <li class="name">
      <div class="item-label col-lg-3 col-md-4">
         <label for="input-name">
            <strong> 이름</strong>
         </label>
      </div>
      <div class="col-lg-21 col-md-20">
         <input type="text" id="input-name" class="xx-control" name="MEMBER_NAME" value="${myInfo.MEMBER_NAME}" readOnly label="이름">
      </div>
   </li>
   
  <li class="mail">
      <div class="item-label col-lg-3 col-md-4">
         <label for="input-mail">
            <strong>이메일</strong>
         </label>
      </div>
      <div class="col-lg-21 col-md-20">
        <div class="input-box">
            <input type="text" name="MEMBER_EMAIL1" class="xx-control x01" label="이메일" required="required" value="${sessionScope.email1}" size="10" >
            <span>@</span>
            <input type="text" name="MEMBER_EMAIL2" id="email2" class="xx-control x02" label="이메일" required="required" value="${sessionScope.email2}" size="20" >
            
         </div>
         
      </div>
   </li>
   
</ul>
 <div class="btnArea">
  <input class="effect effect-5" type="submit" onclick="checkpw();" value="회원정보 수정하기"/>
 </div>
</section>
</form>
</div>
</body>
</html>