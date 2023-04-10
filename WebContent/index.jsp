<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link href="assets/css/indexStyle.css" rel="stylesheet" />
<link href="assets/css/customIndexStyle.css" rel="stylesheet" />
<title>Enjoy Trip</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<meta charset="utf-8">
<%@ include file="/common/head.jsp"%>
</head>
<body>
	<%@ include file="/common/nav.jsp" %>

	<!-- Masthead-->
	<header class="masthead">
		<div class="container position-relative">
			<div class="row justify-content-center">
				<div class="col-xl-6">
					<div class="text-center text-white">
						<!-- Page heading-->
						<h1 class="mb-5">가고 싶은 여행지를 검색해 보세요!</h1>
						<form class="form-subscribe" id="contactForm"
							data-sb-form-api-token="API_TOKEN">
							<!--====== SEARCH PART START ======-->
							<div>
								<div class="container">
									<div class="search-wrapper">
										<form action="#">
											<div class="row justify-content-center">
												<div class="col-lg-3 col-sm-5 col-10">
													<div class="search-input">
														<label for="category"><i
															class="lni lni-grid-alt theme-color"></i></label> <select
															name="category" id="category" class="form-select">
															<option value="none" selected disabled>지역</option>
														</select>
													</div>
												</div>
												<div class="col-lg-4 col-sm-5 col-10">
													<div class="search-input">
														<label for="location"><i
															class="lni lni-map-marker theme-color"></i></label> <select
															name="location" id="location" class="form-select">
															<option value="0" selected disabled>시/군/구</option>
														</select>
													</div>
												</div>
												<div class="col-lg-3 col-sm-5 col-10">
													<div class="search-input">
														<label for="contents"><i
															class="lni lni-map-marker theme-color"></i></label> <select
															name="contents" id="contents" class="form-select">
															<option value="0" selected disabled>관광지 유형</option>
															<option value="12">관광지</option>
															<option value="14">문화시설</option>
															<option value="15">축제공연행사</option>
															<option value="25">여행코스</option>
															<option value="28">레포츠</option>
															<option value="32">숙박</option>
															<option value="38">쇼핑</option>
															<option value="39">음식점</option>
														</select>
													</div>
												</div>
												<div class="col-lg-6 col-sm-5 col-10">
													<div class="search-input">
														<label for="keyword"><i
															class="lni lni-search-alt theme-color"></i></label> <input
															type="text" name="keyword" id="keyword" class="form-control"
															placeholder="키워드를 입력하세요." />
													</div>
												</div>
												<div class="col-lg-2 col-sm-5 col-10">
													<div class="search-btn">
														<button id='search-btn' class="btn btn-info btn-hover">
															Search <i class="lni lni-search-alt"></i>
														</button>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
							<!--====== SEARCH PART END ======-->
						</form>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- FOOTER -->
	<%@ include file="/common/footer.jsp" %> 
	<script src="assets/js/indexJs.js"></script>
	<script type="text/javascript">
	
		// ================ Sido, Gugun Option START ================
		// index page 로딩 후 전국의 시도 설정.
		let areaUrl = "${root}/attraction?action=sido"
		
		fetch(areaUrl, { method: "GET" })
		    .then((response) => response.json())
		    .then((data) => makeOption(data, "category"));
		
		
		const areaSelect = document.querySelector("#category")
	//		console.log(areaSelect);
	
		// 소지역 설정
		areaSelect.addEventListener("change", setSmallArea)
	
		function setSmallArea() {
		    removeSmallArea();
		    const smallAreaOption = document.querySelector("#location");
	
		    const sidoCode = document.querySelector("#category").value;
		    let smallAreaUrl = "${root}/attraction?action=gugun&sidoCode="+sidoCode;
		    
		    fetch(smallAreaUrl, { method: "GET" })
		        .then((response) => response.json())
		        .then((data) => makeOption(data, "location"));
		    
		}
		
		function makeOption(data, id) {
	//		    console.log(data);
		    let sel = document.getElementById(id);
		    data.forEach((data) => {
		        let opt = document.createElement("option");
	//		        console.log(data.sidoCode + " " + data.sidoName);
		        opt.setAttribute("value", data.code);
		        opt.appendChild(document.createTextNode(data.name));
				
		        sel.appendChild(opt);
		    });
		}
	
		function removeSmallArea() {
		    console.log("remove");
		    const smallAreaOptionList = document.querySelectorAll("#location option");
		    console.log("smallAreaOptionList");
		    for (let i = 1; i < smallAreaOptionList.length; i++) {
		        // console.log(smallAreaOptionList[i]);
		        smallAreaOptionList[i].remove();
		    }
		}
		
		// ================ Sido, Gugun Option END ================
		
		const searchBtn = document.querySelector("#search-btn");
		searchBtn.addEventListener("click", (event) => {
		    let sidoCode = document.getElementById("category").value;
		    if (sidoCode === "none") {
		    	alert("지역을 선택해주세요!");
		    	return;
		    }
		    
		    let gugunCode = document.getElementById("location").value;
		    let contentTypeId = document.getElementById("contents").value;
		    let keyword = document.getElementById("keyword").value;
	//		    console.log(areaCode, gugunCode, content, keyword);
	
		    let searchUrl = "${root}/attraction?action=searchInHome&pageNo=1";
	
		    searchUrl += "&sidoCode=" + sidoCode;
		    searchUrl += "&gugunCode=" + gugunCode;
		    searchUrl += "&contentTypeId=" + contentTypeId;
		    searchUrl += "&keyword=" + keyword;
		    event.preventDefault();
	
		    location.href = searchUrl;
		});
	</script>
</body>
</html>
