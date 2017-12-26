
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"><!-- 별모양 폰트 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>불타는 샌드위치</title>
</head>
<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#diy_wrap{
   width:1170px;
   margin-left:auto;
   margin-right:auto;
   font-family:PureunJeonnam;
}
#diy_wrap th{
   font-size:15px;
   font-family:PureunJeonnam;
   text-align:center;
   background: #f5f5f5;
   
   
}
#diy_wrap table{
   font-size:15px;
   font-family:PureunJeonnam;
   text-align:center;
   font-weight:bold;
}
a{
   text-decoration:none;
   color:black;
}
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


<body>
<div id="diy_wrap">
<table class="table">
<colgroup>

   <col width="5%"/>
   <col width="10%"/>
   <col width="13%"/>
   <col width="10%"/>
   <col width="10%"/>
   <col width="10%"/>
   <col width="16%"/>
</colgroup>
<div>
   <h3 style="padding-left:20px; text-align:left;">
      <span style="color:black; font-size:30px; font-weight:bold;">내가 장바구니에 담은 상세내역</span>
   </h3>
</div>

<div>
   <hr color="#777" width="100%" size="1">
</div>

<tr>
         <td>인덱스</td>
         <td>주문번호</td> 
         <td>대분류</td>
         <td>소분류</td>
         <td>개수</td>
         <td>개당 가격</td>
         <td>날자</td>
</tr>

<c:forEach var="my" items="${list}" varStatus="stat">


   <tr>
         <td style="vertical-align:middle;">${my.PURCHASE_INDEX } </td>
         <td style="vertical-align:middle;">${my.PURCHASE_NO}</td>
         <td style="vertical-align:middle;">${my.PURCHASE_BIGTYPE }</td>
         <td style="vertical-align:middle;">${my.PURCHASE_SMALLTYPE }</td>
         <td style="vertical-align:middle;">${my.PURCHASE_AMOUNT }</td>
         <td style="vertical-align:middle;">${my.PURCHASE_PRICE}</td>
         <td style="vertical-align:middle; text-align:center;">${my.PURCHASE_ORDERDATE }</td>
         

   </tr>
      <c:url var="viewURL" value="/basketasorder.jy">   
            <c:param name="PURCHASE_NO" value="${my.PURCHASE_NO}">
            </c:param>
      
      </c:url>
      
      <input type="hidden" id="PURCHASE_NO" value="${my.PURCHASE_NO }">      
   
</c:forEach>

</table>


<div  style="clear:both; text-align:right;"> 
<h4><a href="${ viewURL}" name="PURCHASE_NO">장바구니에 있는 항목 바로 주문</a></h4>
</div>

</div>
</body>
</html>