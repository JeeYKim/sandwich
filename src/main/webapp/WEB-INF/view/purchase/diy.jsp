<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>tab example</title>

<script src="http://code.jquery.com/jquery-latest.min.js">
   
</script>
<script>
   
   function addIngre(img) {
      var no = img.getAttribute("id");
      var addUrl = "addIngre.jy";
      
      $.ajax({url: addUrl,  
            type : "POST", 
            data : { 
               no:no
            },
            success: function(result){ 
               $("#goodsBasket").html(result); 
               calcurate();
            },
            error: function(result){ 
               alert("실패"); 
            }   
          
       });
   }
   
   
   function delIngre(img){
      var no =  test.getAttribute("id");
      var theUrl = "delIngre.jy";
      
          $.ajax({url: theUrl,  
            type : "POST", 
            data : { 
               no:no
            },
            success: function(result){             //리절트값 = goodsTopping.jsp
               $("#goodsBasket").html(result);      //goodsTopping.jsp를 #goodsBasket에 삽입
               calcurate();

            },
            error: function(result){ 
               alert("실패"); 
            }   
          
       });
   }

   
</script>


</head>
<body>

<c:forEach var="all" items="${AllIngre}" varStatus="stat">

<div id="ingreInfo">
<img src="resources/images/sandwich/${all.SANDWICH_THUMBNAIL}" id="${all.NO}" onclick="addIngre(this)">
<div class="caption">

<div><h5>${all.SANDWICH_SMALLTYPE} </h5></div>
<div><h5>${all.SANDWICH_PRICE}원</h5></div>

</div>
</div>
</c:forEach>







    

   
</body>
</html>