<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attraction Info</title>
<%@ include file="/common/head.jsp" %>
<link rel="stylesheet" href="${root}/assets/css/attraction.css">
</head>
<body>
	<!-- NAV -->
	<%@ include file="/common/nav.jsp" %>
	
	<div class="content-container">
		<!--====== SEARCH PART START ======-->
		<div class="search-area">
			<div class="container bg-primary bg-gradient">
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
										class="lni lni-search-alt theme-color"></i></label> <input type="text"
										name="keyword" id="keyword" class="form-control" placeholder="키워드를 입력하세요." />
								</div>
							</div>
							<div class="col-lg-2 col-sm-5 col-10">
								<div class="search-btn">
									<button id='search-btn' class="main-btn btn btn-info btn-hover">
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
		
		<div class="row container-fluid">
			<!--====== MAP START ======-->
			<div class="map-box col col-md-5 mx-auto">
				<div class="map-container">
					<div id="map"></div>
				</div>
			</div>
			
		
			<!--====== MAP END ======-->
			<!--====== TABLE START ======-->
			<div class="col col-md-7 row">
			
				<c:if test="${searchFromHome ne null}">
					<table class="table table-striped">
				</c:if>
				<c:if test="${searchFromHome eq null}">
					<table class="table table-striped" style="display: none">
				</c:if>
					<thead>
						<tr>
							<th>대표이미지</th>
							<th>관광지명</th>
							<th>관광지 분류</th>
							<th>주소</th>
							<th>전화번호</th>
							<th>조회수</th>
						</tr>
					</thead>
					<!-- js에서 관광지 정보 넣어줌 -->
					<tbody id="trip-list"></tbody>
				</table>

				<!-- 페이지네이션 -->
				<nav id="page-nav" aria-label="...">
					<ul class="pagination">
						<li class="page-item disabled">
							<a class="page-link">Previous</a>
						</li>
						<!-- <li class="page-item"><a class="page-link" href="#">5</a></li> -->
						<li class="page-item">
							<a class="page-link" href="#">Next</a>
						</li>
					</ul>
				</nav>
			</div>
			<!--====== TABLE END ======-->
		</div>
	</div>
	
	
	



	
	
	<!-- FOOTER -->
	<%@ include file="/common/footer.jsp" %> 
	
	


	<!--====== JAVASCRIPT IMPORT START ======-->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=493decc2eeb806790cc421e8e9a902e2"></script>
	<script type="text/javascript">

		// ================ Sido, Gugun Option START ================
		// index page 로딩 후 전국의 시도 설정.
		let areaUrl = "${root}/attraction?action=sido";
		
		fetch(areaUrl, { method: "GET" })
		    .then((response) => response.json())
		    .then((data) => makeOption(data, "category"));
		
		
		const areaSelect = document.querySelector("#category")
// 		console.log(areaSelect);

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
// 		    console.log(data);
		    let sel = document.getElementById(id);
		    data.forEach((data) => {
		        let opt = document.createElement("option");
// 		        console.log(data.sidoCode + " " + data.sidoName);
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
			
		// ================ Search Button Start ================
		
		
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
// 		    console.log(areaCode, gugunCode, content, keyword);

		    let searchUrl = "${root}/attraction?action=search&pageNo=1";

		    searchUrl += "&sidoCode=" + sidoCode;
		    searchUrl += "&gugunCode=" + gugunCode;
		    searchUrl += "&contentTypeId=" + contentTypeId;
		    searchUrl += "&keyword=" + keyword;
		    event.preventDefault();

		    fetch(searchUrl)
		        .then((response) => response.json())
		        .then((data) => {
					// console.log(data)
					makeList(data.attractions)
					const pageNav = document.querySelector("#page-nav");
					pageNav.style.display = "block";
				});
		});

		// ================ Search Button End ================
		
		const mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		const map = new kakao.maps.Map(mapContainer, mapOption);
		
		// ================ Search From Home Start ================
		let attractions = '${searchFromHome}';
		if (attractions !== '') {
			attractions = JSON.parse(attractions);
			const pageNavInfo = JSON.parse('${pageNavInfo}');
			// console.log(pageNavInfo);
			const positions = [];
			makeList(attractions);
			const pageNav = document.querySelector("#page-nav");
			pageNav.style.display = "block";
		}

		// ================ Search From Home End ================


		
		function makeList(data) {
// 		    console.log(data);
		    document.querySelector("table").setAttribute("style", "display: ;");
		    let tripList = "";
		    const positions = [];
		    data.forEach((attraction) => {
		    	
		    	tripList += "<tr onclick=\"moveCenter(" + attraction.latitude + ", " + attraction.longitude + ");\">"
		    		+ "<td><img src=\"" + attraction.firstImage + "\" width=\"100px\"></td>"
		    		+ "<td>" + attraction.title + "</td>"
		    		+ "<td>" + attraction.contentTypeId + "</td>"
		    		+ "<td>" + attraction.addr + "</td>"
		    		+ "<td>" + attraction.tel + "</td>"
		    		+ "<td>" + attraction.readCount + "</td>"
		    		+ "</tr>";

		        let markerInfo = {
		        title: attraction.title,
		        latlng: new kakao.maps.LatLng(attraction.latitude, attraction.longitude),
		        };
		        positions.push(markerInfo);
		    });
		    document.getElementById("trip-list").innerHTML = tripList;
		    displayMarker(positions);
		}
		
		function displayMarker(positions) {
		    // 마커 이미지의 이미지 주소입니다
		    let imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

		    for (var i = 0; i < positions.length; i++) {
		        // 마커 이미지의 이미지 크기 입니다
		        var imageSize = new kakao.maps.Size(24, 35);

		        // 마커 이미지를 생성합니다
		        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

		        // 마커를 생성합니다
		        var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng, // 마커를 표시할 위치
		        title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image: markerImage, // 마커 이미지
		        });
		    }

		    // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
		    map.setCenter(positions[0].latlng);
		}

		
		function moveCenter(lat, lng) {
		    map.setCenter(new kakao.maps.LatLng(lat, lng));
		}

		
		</script>
	<!--====== JAVASCRIPT IMPORT START ======-->
</body>
</html>