<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

   /* function checkDiy(){
      if(${(sessionScope.toppingList) ==null}  || ${(sessionScope.toppingList)==""} ){
         alert("양배추만 먹고 살순 없잖아");
         return false;
      }else{
         return true;
      }
   }

   function payment(){
      if(checkDiy()){
      location.href="PaymentDiy?form_price="+document.getElementById('form_price').value+"&form_kcal="+document.getElementById('form_kcal').value;
      }
   } */

   /* function calcurate(){
      var price = document.getElementById("form_price").value;
      var kcal = document.getElementById("form_kcal").value;
      price *=1;
      kcal *=1;
      
      <c:forEach items="${toppingList}" var="toppingList">
      
      price = price + ${toppingList.TOPPING_PRICE};
      kcal = kcal + ${toppingList.TOPPING_KCAL};
      </c:forEach>
      var aKcal = ${sessionScope.MyKcal};
      
      var myKcal = Number(kcal-aKcal);
      var element = document.getElementById("kcal");
      if(myKcal<0){
         
         element.style.color = "#23A41A";
         element.style.fontWeight = "bold";
      }else if( myKcal >50 && myKcal<300){
         element.style.color = "#FF7012";
         element.style.fontWeight = "bold";
      }else{
         element.style.color = "#DB0000";
         element.style.fontWeight = "bold";
      }
      
      document.getElementById("form_price").setAttribute("value",price);
      document.getElementById("form_kcal").setAttribute("value",kcal);

      document.getElementById("price").innerHTML =price;
      document.getElementById("kcal").innerHTML=kcal;
      document.getElementById("point").innerHTML = price/100;
      
   } */
   

</script>
</head>
<body style="height: auto;" onload="calcurate();"  >

<div class="bkform" id="bkform" style="height: auto;">
   <center>

<div  style=" padding-top: 20px;margin-top: 20px; height: 300px; overflow-y:scroll;"> 
      
            
                  <c:forEach var="ingreList" items="${ingreList}" varStatus="stat">
                                         
                          
                     <table class="table table-hover">
                     <tr>
                        <td width="80px">                         
                           <div style="margin-top: 20px;">
                           <img  class="img-circle" style=" width: 70px;height: 70px;" alt="" src="resources/file/goodsFile/${ingreList.SANDWICH_THUMNAIL}"/>
                           </div>
                        </td> 
                        <td><h5>&nbsp;&nbsp;${ingreList.SANDWICH_SMALLTYPE}&nbsp;&nbsp;<span class="glyphicon glyphicon-remove" aria-hidden="true" id="${stat.index}"  onclick="delIngre(this);" style="margin-top: 20px;"></span></h5>
                        
                              
                              <br/>
                              &nbsp;${ingreList.SANDWICH_PRICE}원  &nbsp;&nbsp;
                              </td>       
                               
                        </tr>
                     
                     </table>

                  </c:forEach>
            

               
         </div>
         
         
         <div style="background-color: #F9F9F9;border-radius: 10px;  height: auto;">
            <div  style="height: 300px; border-radius:10px; ">
               <br/>
            <center>
               <table border="0" width="70%" style="margin-bottom: 20px;margin-top: 20px; padding-left: 10px;padding-right: 10px;" class="table">
                  <tr>
                     <td width="30%"><h4><strong>총 결제 금액</strong></h4></td><td><center><span id="price">0</span>원</center></td>
                  </tr>
                  <tr>
                  수량 : <input type="text" id="amount" value=""/>
                  </tr>
               </table>
               </center>
               
               <button type="button" class="btn btn-default btn-lg" style="margin-left: 10px;margin-right: 10px;" onclick="javascript:if(checkDiy()){alert('장바구니에 담았습니다');document.getElementById('basketForm').submit();}">
                 <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>BASKET
               </button>
               
               <button type="button" class="btn btn-default btn-lg" style="margin-left: 10px;margin-right: 10px;" onclick="payment()">
                 <span class="   glyphicon glyphicon-credit-card" aria-hidden="true"></span>PAYMENT
               </button>
         
               <form id="basketForm" action="BasketDiy" >
                  <input type="hidden" id="form_price" name="form_price" value="0"/>
                  
               </form>
            
            </div>
         </div>
      </center>


</div>
</body>
</html>