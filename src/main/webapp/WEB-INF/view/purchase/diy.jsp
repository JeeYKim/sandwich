<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>tab example</title>
<link rel="stylesheet" type="text/css"
   href="/sandwich/resources/css/DIY.css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script>
   function addIngre(img) {
      var no = img.getAttribute("id");

      $.ajax({
         url : "addIngre.jy",
         type : "POST",
         data : {
            no : no
         },  
         success : function(result) {
            $("#goodsBasket").html(result);   
            /* calculate(); */
         },
         error : function(result) {
            alert("실패");
         }

      });
   }

   function delIngre(test) {
      var no = test.getAttribute("id");
      console.log("인덱스 : " + no);

      $.ajax({
         url : "delIngre.jy",
         type : "POST",
         data : {
            no : no
         },
         success : function(result) {
            $("#goodsBasket").html(result);
            deletePrice(test);

         },
         error : function(result) {
            alert("삭제실패");
         }

      });
   }
</script>


</head>
<body style="height: 100%;">
   <div id="container">
      <div id="content" class="main">
         <section class="sec_recommend">
         <div class="inner">
            <h2>원하는 재료를 선택하세요</h2>
            <p>원하는 재료를 선택해 나만의 샌드위치를 만들어 보세요</p>
            
         <!--    <form id="totalForm" method="POST"> -->
         <div id="fieldset">
               <div class="field1">
                  
                  <ul class="big_sort">
                     <li class="current" data-tab="tab1"><a href="#">빵</a></li>
                     <li data-tab="tab2"><a href="#">야채</a></li>
                     <li data-tab="tab3"><a href="#">고기</a></li>
                     <li data-tab="tab4"><a href="#">소스</a></li>
                  </ul>
                  
                  <ul class="small_sort">
                     

                        <li>
                           <div id="tab1" class="tabcontent current">
                           <c:forEach var="all" items="${AllIngre}" varStatus="stat">
                              <c:if test="${all.SANDWICH_BIGTYPE == '빵'}">
                                 <a id="ingreInfo"> <img
                                    src="resources/images/sandwich/${all.SANDWICH_THUMNAIL}"
                                    id="${all.NO}" onclick="addIngre(this)" alt="20"> <strong>${all.SANDWICH_SMALLTYPE}<br>
                                       ${all.SANDWICH_PRICE}원
                                 </strong>
                                 </a>
                              </c:if>
                              </c:forEach>
                           </div>
                        
                        <div id="tab2" class="tabcontent">
                        <c:forEach var="all" items="${AllIngre}" varStatus="stat">
                              <c:if test="${all.SANDWICH_BIGTYPE == '야채'}">
                        <a id="ingreInfo"> 
                        <img src="resources/images/sandwich/${all.SANDWICH_THUMNAIL}"
                                    id="${all.NO}" onclick="addIngre(this)" alt="20"> 
                           <strong>${all.SANDWICH_SMALLTYPE}<br>
                                 ${all.SANDWICH_PRICE}원
                           </strong>
                        </a>
                              </c:if>
                              </c:forEach>
                           </div>
                        
                        <div id="tab3" class="tabcontent">
                        <c:forEach var="all" items="${AllIngre}" varStatus="stat">
                              <c:if test="${all.SANDWICH_BIGTYPE == '고기'}">
                        <a id="ingreInfo"> 
                        <img src="resources/images/sandwich/${all.SANDWICH_THUMNAIL}"
                                    id="${all.NO}" onclick="addIngre(this)" alt="20"> 
                           <strong>${all.SANDWICH_SMALLTYPE}<br>
                                 ${all.SANDWICH_PRICE}원
                           </strong>
                        </a>
                              </c:if>
                              </c:forEach>
                           </div>
                           
                        <div id="tab4" class="tabcontent">
                        <c:forEach var="all" items="${AllIngre}" varStatus="stat">
                              <c:if test="${all.SANDWICH_BIGTYPE == '소스'}">
                        <a id="ingreInfo"> 
                        <img src="resources/images/sandwich/${all.SANDWICH_THUMNAIL}"
                                    id="${all.NO}" onclick="addIngre(this)" alt="20"> 
                           <strong>${all.SANDWICH_SMALLTYPE}<br>
                                 ${all.SANDWICH_PRICE}원
                           </strong>
                        </a>
                              </c:if>
                              </c:forEach>
                           </div>   
                        </li>
                        
                     
                     
                  </ul>
               </div>
               
               <div class="field2" style="margin-left:10px;">
                  <dl>
                     <dt>
                        <input type="text" id="totalPrice" name="totalPrice" value="0"
                           style="width:200px; height:40px"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     </dt>
                     <dd>
    
                        <jsp:include page="diy2.jsp"></jsp:include>

                     </dd>
                  </dl>
               </div>
               </div>
         <!--    </form> -->
         </div>
         </section>
      </div>
   </div>
   <script>
      $(function() {
         $('ul.big_sort li').click(function() {
            var activeTab = $(this).attr('data-tab');
            $('ul.big_sort li').removeClass('current');
            $('.tabcontent').removeClass('current');
            $(this).addClass('current');
            $('#' + activeTab).addClass('current');
            console.log("펑션실행");

         })
      });
   </script>
</body>
</html>