package com.sandwich.common;

public class Paging {

		private int currentPage; // 현재페이지
		private int totalCount; // 총 게시물 개수
		private int totalPage; // 총 페이지 수
		private int blockCount; // 한페이지에 나오게 할 게시물 개수
		private int blockPage; // 한 화면에 나오게 할 페이지 수
		private int startCount; // 한페이지에 보여줄 게시글의 시작 번호
		private int endCount; // 한 페이지에 보여줄 게시글의 끝번호
		private int startPage; // 한 화면에 보여줄 시작페이지
		private int endPage; // 한 화면에 보여줄마지막 페이지
		private String urlName; //기본 주소

		private StringBuffer pagingHtml;

		// 페이지 생성자
		public Paging(int currentPage, int totalCount, int blockCount, int blockPage, String urlName) {

			this.blockCount = blockCount;
			this.blockPage = blockPage;
			this.currentPage = currentPage;
			this.totalCount = totalCount;
			this.urlName = urlName;

			// 총 페이지 수 계산
			totalPage = (int) Math.ceil((double) totalCount / blockCount);
			if (totalPage == 0) {
				totalPage = 1;
			}

			// 현재 페이지가 총 페이지수 보다 클 때
			if (currentPage > totalPage) {
				currentPage = totalPage;
			}

			// 페이지에 보여줄 게시글 시작번호, 끝번호 계산
			startCount = (currentPage - 1) * blockCount;
			endCount = startCount + blockCount - 1;

			// 한 페이지에 보여줄 시작페이지, 마지막 페이지 계산
			startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
			endPage = startPage + blockPage - 1;

			// 마지막 페이지가 총 페이지보다 클 때
			if (endPage > totalPage) {
				endPage = totalPage;
			}

			
			pagingHtml = new StringBuffer();

			// 현재 페이지가 한 화면에서 보여줘야할 페이지수보다 클 때
			if (currentPage > blockPage) {
				pagingHtml.append("<a class='page prv' href=" + urlName + "?currentPage=" + (startPage - 1) + ">");
				pagingHtml.append("&lt;");
				pagingHtml.append("</a>");
			}

			// 페이지 번호, 현재 페이지는 빨간색으로 강조하고 링크 제거
			for (int i = startPage; i <= endPage; i++) {
				if (i > totalPage) {
					break;
				}
				if (i == currentPage) {
					pagingHtml.append("<strong>");
					pagingHtml.append(i);
					pagingHtml.append("</strong>");
				} else {
					pagingHtml.append("<a class='page' href=" + urlName + "?currentPage=");
					pagingHtml.append(i);
					pagingHtml.append(">");
					pagingHtml.append(i);
					pagingHtml.append("</a>");
				}
			}

			// 다음 블락 페이지
			if (totalPage - startPage >= blockPage) {
				pagingHtml.append("<a class='page next' href=" + urlName + "?currentPage=" + (endPage + 1) + ">");
				pagingHtml.append("&gt;");
				pagingHtml.append("</a>");
			}
		}

		// Search가 있는 페이징 생성자
		public Paging(int currentPage, int totalCount, int blockCount, int blockPage, String urlName, int searchNum,
				String isSearch) {

			this.blockCount = blockCount;
			this.blockPage = blockPage;
			this.currentPage = currentPage;
			this.totalCount = totalCount;

			totalPage = (int) Math.ceil((double) totalCount / blockCount);
			if (totalPage == 0) {
				totalPage = 1;
			}

			if (currentPage > totalPage) {
				currentPage = totalPage;
			}

			startCount = (currentPage - 1) * blockCount;
			endCount = startCount + blockCount - 1;

			startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
			endPage = startPage + blockPage - 1;

			if (endPage > totalPage) {
				endPage = totalPage;
			}

			// 이전 block페이지
			pagingHtml = new StringBuffer();
			if (currentPage > blockPage) {
				if (isSearch != "")
					pagingHtml.append("<a class='page prv' href=" + urlName + "?currentPage=" + (startPage - 1)
							+ "&searchNum=" + searchNum + "&isSearch=" + isSearch + ">");
				else
					pagingHtml.append("<a class='page prv' href=" + urlName + "?currentPage=" + (startPage - 1) + ">");
				pagingHtml.append("&lt;");
				pagingHtml.append("</a>");
			}

			// 페이지 번호, 현재 페이지는 빨간색으로  표시하고 링크 제거
			for (int i = startPage; i <= endPage; i++) {
				if (i > totalPage) {
					break;
				}
				if (i == currentPage) {
					pagingHtml.append("<strong>");
					pagingHtml.append(i);
					pagingHtml.append("</strong>");
				} else {
					pagingHtml.append("<a class='page' href=" + urlName + "?currentPage=" + i);
					if (isSearch != "")
						pagingHtml.append("&isSearch=" + isSearch + "&searchNum=" + searchNum);
					pagingHtml.append(">");
					pagingHtml.append(i);
					pagingHtml.append("</a>");
				}
			}
			// 다음 block페이지
			if (totalPage - startPage >= blockPage) {
				pagingHtml.append("<a class='page next' href=" + urlName + "?currentPage=" + (endPage + 1));
				if (isSearch != "")
					pagingHtml.append("&isSearch=" + isSearch + "&searchNum=" + searchNum);
				pagingHtml.append(">");
				pagingHtml.append("&gt;");
				pagingHtml.append("</a>");
			}

		}
		
		
		// Category있는 생성자
		public Paging(int currentPage, int totalCount, int blockCount, int blockPage, String urlName,String Category) {

			this.blockCount = blockCount;
			this.blockPage = blockPage;
			this.currentPage = currentPage;
			this.totalCount = totalCount;

			totalPage = (int) Math.ceil((double) totalCount / blockCount);
			if (totalPage == 0) {
				totalPage = 1;
			}

			if (currentPage > totalPage) {
				currentPage = totalPage;
			}

			startCount = (currentPage - 1) * blockCount;
			endCount = startCount + blockCount - 1;

			startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
			endPage = startPage + blockPage - 1;

			if (endPage > totalPage) {
				endPage = totalPage;
			}

			// 이전 block 페이지
			pagingHtml = new StringBuffer();
			if (currentPage > blockPage) {
				if (Category != "")
					pagingHtml.append("<a class='page prv' href=" + urlName + "?currentPage=" + (startPage - 1)
							 + "&category=" + Category + ">");
				else
					pagingHtml.append("<a class='page prv' href=" + urlName + "?currentPage=" + (startPage - 1) + ">");
				pagingHtml.append("&lt;");
				pagingHtml.append("</a>");
			}

			// 페이지 번호, 현재 페이지는 빨간색으로 표시하고 링크 제거
			for (int i = startPage; i <= endPage; i++) {
				if (i > totalPage) {
					break;
				}
				if (i == currentPage) {
					pagingHtml.append("<strong>");
					pagingHtml.append(i);
					pagingHtml.append("</strong>");
				} else {
					pagingHtml.append("<a class='page' href=" + urlName + "?currentPage=" + i);
					if (Category != "")
						pagingHtml.append("&category=" + Category );
					pagingHtml.append(">");
					pagingHtml.append(i);
					pagingHtml.append("</a>");
				}
			}
			// ´다음 block페이지
			if (totalPage - startPage >= blockPage) {
				pagingHtml.append("<a class='page next' href=" + urlName + "?currentPage=" + (endPage + 1));
				if (Category != "")
					pagingHtml.append("&category=" + Category);
				pagingHtml.append(">");
				pagingHtml.append("&gt;");
				pagingHtml.append("</a>");
			}

		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}

		public int getTotalPage() {
			return totalPage;
		}

		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}

		public int getBlockCount() {
			return blockCount;
		}

		public void setBlockCount(int blockCount) {
			this.blockCount = blockCount;
		}

		public int getBlockPage() {
			return blockPage;
		}

		public void setBlockPage(int blockPage) {
			this.blockPage = blockPage;
		}

		public int getStartCount() {
			return startCount;
		}

		public void setStartCount(int startCount) {
			this.startCount = startCount;
		}

		public int getEndCount() {
			return endCount;
		}

		public void setEndCount(int endCount) {
			this.endCount = endCount;
		}

		public int getStartPage() {
			return startPage;
		}

		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}

		public int getEndPage() {
			return endPage;
		}

		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}

		public StringBuffer getPagingHtml() {
			return pagingHtml;
		}

		public void setPagingHtml(StringBuffer pagingHtml) {
			this.pagingHtml = pagingHtml;
		}

		public String geturlName() {
			return urlName;
		}

		public void seturlName(String urlName) {
			this.urlName = urlName;
		}
	}

