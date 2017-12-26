<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>불타는 샌드위치</title>

</head>
<body>
<div class="wrap-body">
<div id="owl-slide" class="owl-carousel">

		<c:forEach var="notice" items="${notice}" begin="0" end="2" step="1" varStatus="status">
		<c:url var="ViewNOTICE" value="/memberNoticeView.jy" >
			<c:param name="noticeNo" value="${notice.NOTICE_NO}" />
		</c:url>
			
			<div class="item">
			<p style="text-align:center;">
			<a href="${ViewNOTICE}">   
				<img src="upload/notice/${notice.NOTICE_FILE}" style="align:center; width:auto; height:500px;">
			</a>
			</p>
			</div>
			
		</c:forEach>
				
	</div>
		
		<a href="diy.jy" id="order_btn">주문</a>
		<!--////////////////////////////////////Container-->
		<section id="container">
			<div class="wrap-container">  
				<div id="main-content">
					<div class="wrap-content">
						<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;고갱님들의 추천조합<br><br></h3>
						<div class="zerogrid">
							<div class="row">
							
								<c:forEach var="DIYboard" items="${DIYboard}" begin="0" end="5" step="1" varStatus="status">
								
									<c:url var="ViewURL" value="/memberDiyBoardDetail.jy" >
										<c:param name="DIY_NO" value="${DIYboard.DIY_NO}" />
									</c:url>
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="${ViewURL}" class="portfolio-box">
											<c:if test="${!empty DIYboard.DIY_IMAGE}">
												<img src="resources/file/${DIYboard.DIY_IMAGE}" alt="">
											</c:if>
											<c:if test="${empty DIYboard.DIY_IMAGE }">
												<img src="resources/images/11_.jpg" alt="">
											</c:if>
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															${DIYboard.DIY_CONTENT}
														</div>
													</div>
												</div>
											</a>   
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">${DIYboard.DIY_TITLE}</h3>
										</div>
									</article>
								</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<!-- carousel -->
		<script src="resources/owl-carousel/owl.carousel.js"></script>
		<script>
		$(document).ready(function() {
		  $("#owl-slide").owlCarousel({
			autoPlay: 3000,
			items : 1,
			itemsDesktop : [1199,1],
			itemsDesktopSmall : [979,1],
			itemsTablet : [768, 1],
			itemsMobile : [479, 1],
			navigation: true,
			navigationText: ['<i class="fa fa-chevron-left fa-5x"></i>', '<i class="fa fa-chevron-right fa-5x"></i>'],
			pagination: false
		  });
		});
		</script>
	</div>
	</body>
	</html>