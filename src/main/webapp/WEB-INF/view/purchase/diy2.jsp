<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
function calculate(){
   
   var totalPrice = document.getElementById('totalPrice').value;
   totalPrice = Number(totalPrice);
   document.getElementById('totalPrice').value = totalPrice;
   
}


function deletePrice(test){
   var price1 = test.parentElement.previousElementSibling.firstElementChild;
   
   var result = test.parentElement.parentElement.nextElementSibling.firstElementChild.firstElementChild;
   price1 = Number(price1.value);
   result = Number(result.value);
   var totalPrice = document.getElementById('totalPrice');
   totalPrice.value = Number(totalPrice.value) - price1 * result;
}



function del(minus){
   
   var result = minus.parentElement.previousElementSibling.firstElementChild;
   var resultV = Number(result.value);
   
   
   
   var check = 2;
   
   if(resultV>1){
   resultV--;
   result.setAttribute('value', resultV);
   calculate2(result, resultV, check);
   }
}

function calculate2(result, resultV, check){
   
   var totalPrice = document.getElementById('totalPrice');
   var price1 = Number(result.parentElement.parentElement.previousElementSibling.firstElementChild.firstElementChild.value);
   console.log(price1);
   
   /*console.log("개당가격 : "+price1);
    console.log("resultV : "+ resultV);
   console.log("가격*갯수 : "+price1 * resultV); */
   
   if(check == 1){
   totalPrice.value=Number(totalPrice.value) + price1; 
   }
   if(check == 2){
      totalPrice.value =Number(totalPrice.value) - price1;
   }
   
   
   
}
function add(plus){
   
   
   var result = plus.parentElement.parentElement.nextElementSibling.nextElementSibling.firstElementChild.firstElementChild;
   console.log(result);
   
   var resultV = result.value;
   
   console.log("ajax통신전");
   var acfal = leftCheck(result);
   console.log("ajax통신후");
   console.log("통신 후의 acfal : "+acfal);
   
   var check = 1;
   
   
   
   if(acfal == 1 || acfal == 2){
   resultV++;
   result.setAttribute('value', resultV);
   calculate2(result, resultV, check);
   } if(acfal == 3){
      alert("재고가 부족합니다 관리자에게 문의하세요.");
   }

}
   
function leftCheck(result){
   
      var s_amount = result.value;
      var sandwich_no = result.parentElement.parentElement.previousElementSibling.firstElementChild.lastElementChild.value;
      var acfal;
         
      
      console.log("샌드위치넘버 : " + sandwich_no);
   
      $.ajax({
         url : "check.jy",
         type : "POST",
         data :{s_amount:s_amount, sandwich_no:sandwich_no},
         async: false,
         success : function(data){
            acfal = data;
            console.log("ajax성공");
            console.log("ajax_acfal : "+acfal);
            
            
         },
         error : function(){
            alert("실패");
         }
      });
      return acfal;
      
      
   }

function loginChk(index){
   var index = index;
   //세션체크
}


function submit(index){
   var totalForm = document.getElementById('totalForm');
   var totalPrice = document.getElementById('totalPrice').value;
   
   console.log(totalForm);
   if(index ==1){
      var confirmChk = confirm("결제하실 금액은"+totalPrice+"원입니다. 결제하시겠습니까?")
      if(confirmChk == true){
      totalForm.action="gopurchase.jy"
      } 
   }
   if(index ==2){
      totalForm.action="basketlist.jy"
   } 
   totalForm.submit();
   
}

</script>
</head>
<body style="height: auto;" onload="calculate();" >


<input type="hidden" value="0" name ="totalPrice" id="totalPrice" style="width:200px; height:50px;">
<ul id="goodsBasket" class="selected-ingre">

<form id="totalForm" method="POST">
   <c:forEach var="ingreList" items="${ingreList}" varStatus="stat">
<li>
   

      <table>
         <tr >
            <td rowspan="3">
                  <img class="img-circle" style="width: 80px; height: 80px;" alt=""
                     src="resources/images/sandwich/${ingreList.SANDWICH_THUMNAIL}" />
            </td>
            <td >&nbsp;&nbsp;${ingreList.SANDWICH_SMALLTYPE}&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td ><img src="resources/images/up.png" onclick="add(this);"></td>
         </tr>
         <tr>
            
            <td>
               <input type="hidden" value="${ingreList.SANDWICH_PRICE}">
               &nbsp;${ingreList.SANDWICH_PRICE}원 &nbsp;&nbsp;
               <input type="hidden" value="${ingreList.SANDWICH_PRICE}">
               <input type="hidden" value="${sessionScope.MEMBER_ID}">
               <input type="hidden" name="SANDWICH_NO" value="${ingreList.SANDWICH_NO}">
            </td>
            <td>
               <img src="resources/images/delete_.png"   id="${stat.index}" onclick="delIngre(this);" >
            </td>      
         </tr>
         <tr>   
            <td>   
               <input id="amount${stat.index}" type="text" size="1" name="amountEA" value="0" readonly>
            </td>
            <td>      
                  <img src="resources/images/down.png" onclick="del(this);">
            </td>      
                  
         </tr>

                
            
      </table>
      
   </li>
   </c:forEach>
</form>   
</ul>
<input type="hidden" id="acfal" value="${acfal}">
<div class="btn">
   <button type="submit" onclick="submit(2)">장바구니</button>
</div>

<div class="btn_">
   <button type="submit"  onclick="submit(1)">결제</button>
</div>

</body>
</html>