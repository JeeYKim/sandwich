<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">

	
    <!-- Mobile Specific Metas
	================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <!-- CSS-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  	<link rel="stylesheet" href="resources/css/zerogrid.css?ver=1" type="text/css" />
	<link rel="stylesheet" href="resources/css/style.css?ver=1" type="text/css"/>
	
	<!-- Custom Fonts -->
    <link href="resources/font-awesome/css/font-awesome.min.css?ver=1" rel="stylesheet" type="text/css"/>
	
	
	<link rel="stylesheet" href="resources/css/menu.css?ver=1" />
	<script src="resources/js/jquery1111.min.js" type="text/javascript"></script>
	<script src="resources/js/script.js"></script>
	
	<!-- Owl Carousel Assets -->
    <link href="resources/owl-carousel/owl.carousel.css?ver=1" rel="stylesheet"/>
<style>
html,body{
	height:100%; 
	margin:0;
	padding:0;
	}
	

</style>
<title>불타는 샌드위치</title>
</head>
<body style="overflower-x:hidden;">



<div>
<tiles:insertAttribute name="header" />
</div>


<div style="height:90%;">
<tiles:insertAttribute name="body" />
</div>

<%-- <div style="height:50px;">
<tiles:insertAttribute name="footer" />
</div> --%>
</body>
</html>