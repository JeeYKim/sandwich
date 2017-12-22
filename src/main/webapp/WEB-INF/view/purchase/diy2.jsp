<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
function calculate(){
	
	var totalPrice = document.getElementById('totalPrice').value;
	totalPrice = Number(totalPrice);
	<c:forEach var="ingreList" items="${ingreList}">
	totalPrice = totalPrice + ${ingreList.SANDWICH_PRICE}
	</c:forEach>
	
	document.getElementById('totalPrice').value = totalPrice;
	
}



function add(plus){
	
	
	var result = plus.previousSibling.previousSibling;
	var resultV = Number(result.value);
	var check = 1;
	console.log(result);
	
	resultV++;
	result.setAttribute('value', resultV);
	calculate2(result, resultV, check);
	

}

function del(minus){
	
	var result = minus.previousSibling.previousSibling.previousSibling.previousSibling;
	console.log(result);
	var resultV = Number(result.value);
	var check = 2;
	
	if(resultV>1){
	resultV--;
	}
	result.setAttribute('value', resultV);
	calculate2(result, resultV, check);
}

function calculate2(result, resultV, check){
	
	var totalPrice = document.getElementById('totalPrice');
	var price1 = Number(result.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.value);
	console.log(price1);
	
	
	console.log("개당가격 : "+price1);
	console.log("resultV : "+ resultV);
	console.log("가격*갯수 : "+price1 * resultV);
	
	if(check == 1){
	totalPrice.value=Number(totalPrice.value) + price1; 
	}
	if(check == 2){
		totalPrice.value =Number(totalPrice.value) - price1;
	}
	
	
	
}


/* function test123(){
	var purchaseList="";
	var amountList="";
	<c:forEach var="ingreList" items="${ingreList}">
	
	purchaseList = purchaseList +  ${ingreList.NO} + ", ";
	amountList = 
	
	</c:forEach>
	
	console.log(resultV);
	
	
	console.log(purchaseList);
} */

function submit(index){
	var totalForm = document.getElementById('totalForm');
	console.log(totalForm);
	if(index ==1){
		totalForm.action="gopurchase.jy"
	}
	if(index ==2){
		totalForm.action="gobasket.jy"
	} 
	totalForm.submit();
	
}

</script>
</head>
<body style="height: auto;" onload="calculate();" >


<input type="hidden" value="0" name ="totalPrice" id="totalPrice" style="width:200px; height:50px;">
<ul id="goodsBasket" class="selected-ingre">


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
					&nbsp;${ingreList.SANDWICH_PRICE}원 &nbsp;&nbsp;
					<input type="hidden" value="${ingreList.SANDWICH_PRICE}">
					<input type="hidden" value="${stat.index}">
					<input type="hidden" value="${ingreList.SANDWICH_NO}">
				</td>
				<td>
					<img src="resources/images/delete_.png"	id="${stat.index}" onclick="delIngre(this);" >
				</td>		
			</tr>
			<tr>	
				<td>	
					<input id="amount${stat.index}" type="text" size="1" name="amountEA" value="1" readonly>
				</td>
				<td>		
						<img src="resources/images/down.png" onclick="del(this);">
				</td>		
						
			</tr>

					 
				
		</table>
		
   </li>
	</c:forEach>
	
</ul>

<div class="btn">
	<button type="submit" onclick="submit(2)">장바구니</button>
</div>

<div class="btn_">
	<button type="submit"  onclick="submit(1)">결제</button>
</div>

</body>
</html>