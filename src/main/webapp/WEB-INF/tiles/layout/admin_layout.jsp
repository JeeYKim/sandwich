<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>

   <?xml version="1.0" encoding="UTF-8" ?>


   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <!-- Meta, title, CSS, favicons, etc. -->
   <meta charset="utf-8" />
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="author" content="raon">
   
   <meta name="robots" content="noindex, nofollow" />

   <title>관리자 페이지</title> 
   
   <!-- Favicon -->
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/favicon.ico" type="image/x-icon">

   
   <!-- Bootstrap core CSS -->
   <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
   <link href="resources/css/animate.min.css" rel="stylesheet" />
   
   <!-- Custom styling plus plugins -->
   <link href="resources/css/custom.css?ver=1" rel="stylesheet" />
   <link href="resources/css/pink.css" rel="stylesheet" />
   
   <!-- Font Awesome -->
   <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
   
   <!-- NProgress -->
   <link href="resources/css/nprogress.css" rel="stylesheet" />
   
   <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>   <!-- jquery cdn -->
   
   <!-- soledot -->
   <script src="resources/js/soledot.js"></script>

   
</head>

<body class="nav-md">

   <div class="container body">
      <div class="main_container">

         <?xml version="1.0" encoding="UTF-8" ?>


   <div class="col-md-3 left_col">
      <div class="left_col scroll-view">

         <div class="navbar nav_title" style="border: 0;">
            <a href="admin.jy" class="site_title">
               <i class="fa fa-cogs"></i><span>관리자 페이지</span>
            </a>
         </div>
         <div class="clearfix"></div>

         <!-- menu prile quick info -->
         <div class="profile">
            <div class="profile_pic">
               <img src="resources/images/1_.jpg" alt="..." class="img-circle profile_img" />
            </div>
            <div class="profile_info">
               <span>안녕하세요!</span>
               <h2></h2>
            </div>
         </div>
         <!-- /menu prile quick info -->

         <br />

         <!-- sidebar menu -->
         <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
               <h3>관리자님!</h3>
               <ul class="nav side-menu">
                  <li>
                     <a href="/sandwich"><i class="fa fa-cutlery"></i>불타는 샌드위치로 가기</a>
                  </li>
                  <li>
                     <a href="admin.jy"><i class="fa fa-clock-o"></i>알림</a>
                  </li>
                  
                  <li>
                     <a><i class="fa fa-archive"></i>재고 관리<span class="fa fa-chevron-down"></span></a>
                     <ul class="nav child_menu" style="display: none">
                     
                        <li><a href="ingredientList.jy">재고 목록</a></li>
                        <li><a href="ingredientInsertForm.jy">재료 등록</a></li>
                     </ul>
                  </li>
                  
                  <li>
                     <a><i class="fa fa-file-text-o"></i>발주 관리<span class="fa fa-chevron-down"></span></a>   
                        <ul class="nav child_menu" style="display: none">
                     

                        <li><a href="<c:url value = "/orderAdminList.jy"/>">발주내역</a></li>

                     </ul>               
                  </li>
                  <li>
                     <a><i class="fa fa-trash"></i>폐기 관리<span class="fa fa-chevron-down"></span></a>   
                        <ul class="nav child_menu" style="display: none">
                     
                        <li><a href="/trash">폐기 내역</a></li>
                     </ul>               
                  </li>
                  <li>
                     <a><i class="fa fa-user"></i>회원 관리<span class="fa fa-chevron-down"></span></a>
                     <ul class="nav child_menu" style="display: none">
                     
                        <li><a href="member_list">회원 리스트</a></li>   
                     </ul>
                  </li>
                  <li>
                     <a><i class="fa fa-book"></i>게시판 관리<span class="fa fa-chevron-down"></span></a>
                     <ul class="nav child_menu" style="display: none">
                     
                        <li><a href="noticeList.jy">공지사항 리스트</a></li>
                        <li><a href="recommendation_list">추천게시판 리스트</a></li>
                     </ul>
                  </li>
                  <li>
                     <a><i class="fa fa-won"></i>매출 관리<span class="fa fa-chevron-down"></span></a>
                     <ul class="nav child_menu" style="display: none">
                     
                        <li><a href="MoneyList.jy">매출 현황</a></li>
                        <li><a href="MoneyChart.jy">매출 현황 그래프</a>
                     </ul>
                  </li>
               </ul>
            </div>

         </div>
         <!-- /sidebar menu -->

         <!-- /menu footer buttons -->
         <div class="sidebar-footer hidden-small">

         </div>
         <!-- /menu footer buttons -->
      </div>
   </div>


         <!-- top navigation -->
         <?xml version="1.0" encoding="UTF-8" ?>

   <div class="top_nav">

      <div class="nav_menu">
         <nav class="" role="navigation">
            <div class="nav toggle">
               <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
               <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                      <span class=" fa fa-angle-down" ></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">

                     <li>
                        <a href="/sd_intensely/memberlogin/bo/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                     </li>
                  </ul>
               </li>
   

            </ul>
         
         </nav>
      </div>

   </div>
         <!-- /top navigation -->

         <!-- page content -->
         <div class="right_col" role="main">

            <div class="">
               
                  
                  <tiles:insertAttribute name="admin_body" />
                  
               
            </div>
         </div>
         <!-- /page content -->

         <!-- footer content -->
<!--          <?xml version="1.0" encoding="UTF-8" ?>


      </div>
   </div>

   <div id="custom_notifications" class="custom-notifications dsp_none">
      <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group"></ul>
      <div class="clearfix"></div>
      <div id="notif-group" class="tabbed_notifications"></div>
   </div> -->

   <?xml version="1.0" encoding="UTF-8" ?>

   
   <script src="resources/js/bootstrap.min.js"></script>
    <!-- bootstrap progress js -->
    <script src="resources/js/bootstrap-progressbar.min.js"></script>
    <!-- icheck -->
    <script src="resources/js/icheck.min.js"></script>
    
   <!-- pace -->
   <script src="resources/js/pace.min.js"></script>
   
   <script src="resources/js/custom.js"></script>

</body>

</html>