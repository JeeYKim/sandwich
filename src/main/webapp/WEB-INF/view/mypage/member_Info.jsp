<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/main.min.css">
<link rel="stylesheet" href="./resources/css/joinForm.css">
<script>

//회원탈퇴
function deleteMember()
{
    var f = document.frm;
   var mem_id = f.MEMBER_ID.value;
   
   if(!confirm("탈퇴하시겠습니까?"))
      {
      return;
      }
   
   else{
      var total = ({"MEMBER_ID":mem_id});
      $.ajax
      ({
         
         type: "POST",
         url: "/sandwich/memberDeleteAction.jy",
         data : total,
         
         success: function(data)
         {
            console.log("로그 내용1");
            
            if(data != 0)
               {
               alert("그동안 이용해 주셔서 감사합니다.");
               self.close();
               opener.location.replace("main.jy"); //부모창 새로고침
                            
               }   
            else
               {
                alert("탈퇴에 실패 함");
                self.close();
               } 
         
           },
      error: function(e)
      {
         alert('error'+e);
      }
   });
}
   
} 
          
</script>
</head>

<body>
<div class="body_center">
<form action="/sandwich/memberUpdateForm.jy" name="frm">
<section class="input-horizontal list-horizontal section box-shadow">
            <div class="main_subject">
               <h2>회원정보</h2>
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
      </div>   
      
   </li>
   
   <li class="password">
      <div class="item-label col-lg-3 col-md-4">
         <label for="input-password">
            <strong>비밀번호</strong>
         </label>
      </div>
      <div class="col-lg-21 col-md-20">
         <input type="password" id="input-password" class="xx-control" value="${myInfo.MEMBER_PW}" name="MEMBER_PW" label="비밀번호" readOnly>
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
            <input type="text" name="MEMBER_EMAIL" id="MEMBER_EMAIL" label="이메일" value="${myInfo.MEMBER_EMAIL}" readOnly class="xx-control">
         </div>
         
      </div>
   </li>
   
</ul>
 <div class="btnArea">
  <input class="effect effect-5" style="background:#2d2d2b;" type="button" value="탈퇴하기" onclick="javascript:deleteMember();">
  <input class="effect effect-5" style="background:#2d2d2b;" type="submit" value="회원정보 수정하기"/>
 </div>
</section>
</form>
</div>
</body>
</html>