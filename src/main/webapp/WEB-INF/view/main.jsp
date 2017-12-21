<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>불타는 샌드위치</title>
	
</head>
<body>
<div class="wrap-body">
<div id="owl-slide" class="owl-carousel">
				<div class="item">
					<img src="resources/images/slide_1.jpg" />
				</div>
				<div class="item">
					<img src="resources/images/slide_2.jpg" />
				</div>
				<div class="item">
					<img src="resources/images/slide_3.jpg" />
					
				</div>
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
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="resources/images/11_.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															제가 해먹어 봤는데 정말 맛있어요
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">추천추천</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="resources/images/12_.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															제가 해먹어 봤는데 정말 맛있어요2
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">추천추천2</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
							</div>
							<div class="row">
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="resources/images/13_.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															제가 해먹어 봤는데 정말 맛있어요3
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">추천추천3</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="resources/images/14_.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															제가 해먹어 봤는데 정말 맛있어요4
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">추천추천4</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
							</div>
							<div class="row">
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="resources/images/1_.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															제가 해먹어 봤는데 정말 맛있어요5
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">추천추천5</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="resources/images/2_.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															제가 해먹어 봤는데 정말 맛있어요6
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">추천추천6</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
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