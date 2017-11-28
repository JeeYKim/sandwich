<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
function change(num)
{
var x  = document.getElementById("amount");
var y = Number(x.value) + num;

document.getElementById("amount_ch").setAttribute("value",y);
if(y < 1) y = 1;

x.value = y;


cal();
}
</script>
</head>
<body>
 	<div>
      		     <img src='resources/images/left.png' style="width: 20px; float: left" onclick="change(-1);">
       			 <input type='text' id="amount" name='amount' value='1' size='3' readonly style="float: left">
       			 <img src='resources/images/right.png' style="width: 20px; float: left" onclick="change(1);">
       			 이건 practice다...
       </div>
</body>
</html>