
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description"
	content="Creative Button Styles  - Modern and subtle styles &amp; effects for buttons" />
<meta name="keywords"
	content="button styles, css3, modern, flat button, subtle, effects, hover, web design" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/default.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/component.css" />
<script
	src="${pageContext.request.contextPath}/resources/js/modernizr.custom.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>

<style type="text/css">
.table th {
	background-color: #FAEBD7;
}

.table td {
	background-color: white;
}

.table {
	display: inline-block;
}

#map {
	height: "100%";
	display: inline-block;
}

#listTable tr:hover {
	background: lightgray !important;
	cursor: pointer;
}

.btn btn-7 btn-7a {
	width: 150px;
}
</style>

<script type="text/javascript">
	$(function() {
		printLodge();

		function printLodge() {
			$.ajax({url : "${pageContext.request.contextPath}/forest/lodgeAll",
					type : "post",
					data : "${_csrf.parameterName}=${_csrf.token}&forestNo="
							+ $("#no").val(),
					dataType : "json",
					success : function(result) {
						$('#listTable tr:gt(0)').empty();

						var str = "";
						$.each(result,function(index, item) {
								str += '<tr>';
								str += '<td><img src="${pageContext.request.contextPath}/resources/images/'+item.lodgeFilename+'.jpg"'+
									' style="width: 250px; height: 200px;border-radius: 50px;"/></td>';
								str += '<td>' + item.lodgeName
										+ '</td>';
								str += '<td>' + item.lodgePrice
										+ '</td>';
								str += '<td>'
										+ item.lodgeDetail
										+ '</td>';
								str += '<td>' + item.lodgeAddr
										+ '</td>';
								str += '<td>' + item.lodgeTel
										+ '</td>';
								str += '<td><input type="button" class="btn btn-7 btn-7a icon-cog" value="예약하기" name="booking"></td>';
								str += '<td><input type="button" class="btn btn-2 btn-2i" value="삭제" name='+item.lodgeCode+' id="deleteBtn2"></td>';
								str += '</tr>';
							});
						$('#listTable').append(str);

						$("#listTable tr:even").css("background", "#f2f2f2");
						$("th").css("background", "black").css("color","white");
					},
					error : function(err) {
						alert("숙박정보 오류 : " + err);
					}
				})
		}

		$("#updateBtn").click(function() {
			var forestNo = $(this).prev().val();
			location = "${pageContext.request.contextPath}/forest/updateForm?forestNo="
					+ forestNo;
		})

		$("#deleteBtn").click(function() {
					if (confirm("정말로 삭제하시겠습니까?")) {
						var forestNo = $(this).prev().prev().val();
						//alert(forestNo);
						location = "${pageContext.request.contextPath}/forest/delete?forestNo="
								+ forestNo;
					}
				});

		$("#listBtn").click(function() {
			history.back();
		})
	})
</script>
<script src="${pageContext.request.contextPath}/resources/js/classie.js"></script>
<script>
	var buttons7Click = Array.prototype.slice.call(document
			.querySelectorAll('#btn-click button')), totalButtons7Click = buttons7Click.length;
	buttons7Click.forEach(function(el, i) {
		el.addEventListener('click', activate, false);
	});

	function activate() {
		var self = this, activatedClass = 'btn-activated';
		if (!classie.has(this, activatedClass)) {
			classie.add(this, activatedClass);
			setTimeout(function() {
				classie.remove(self, activatedClass)
			}, 1000);
		}
	}
</script>
</head>
<body>
	<div class="panel-heading" align="center"
		style="background-color: #f2ffe6;">
		<section id="btn-click" style="text-align: right;">
			<span
				style="float: left; vertical-align: middle; font-size: 50px; padding-top: 25px; padding-left: 50px;">${dto.forestName}
				상세 정보</span> <input type="hidden" name="forestNo" value="${dto.forestNo}"
				id="no">
			<button class="btn btn-2 btn-2i icon-cog" id="updateBtn">UPDATE</button>
			<button class="btn btn-2 btn-2i icon-remove" id="deleteBtn">DELETE</button>
			<button class="btn btn-2 btn-2i" id="listBtn">LIST</button>
		</section>
	</div>
	<div>
		<!-- 테이블과 지도 묶기 -->
		<table class="table" border="1">
			<colgroup>
				<col width="100px">
				<col width="150px">
				<col width="100px">
				<col width="150px">
			</colgroup>
			<tbody>

				<tr>
					<th>이미지</th>
					<td colspan="3"><img
						src="${pageContext.request.contextPath}/resources/images/rest.jpg"
						style="width: 600px; height: 400px;" /><br /> <%-- ${dto.forestFilename } --%>
					</td>
				</tr>
				<tr>
					<th>휴양림 이름</th>
					<td>${dto.forestName }</td>

					<th>휴양림 운영 유형</th>
					<td>${dto.forestType }</td>
				</tr>
				<tr>
					<th>주요시설</th>
					<td colspan="3">${dto.forestFacil}</td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="3">${dto.forestAddr}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${dto.forestWriter }</td>

					<th>전화번호</th>
					<td>${dto.forestTel }</td>
				</tr>
			</tbody>
			<tfoot>
			</tfoot>
		</table>

		<div id="map" style="width: 600px; height: 520px;"></div>
		<input type="hidden" id="forestLatitude" name="forestLatitude"
			value="${dto.forestLatitude}"> <input type="hidden"
			id="forestLongitude" name="forestLongitude"
			value="${dto.forestLongitude}">
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e826b64479600b9534daecd6858732f0"></script>
		<script>
			var container = document.getElementById('map');

			var forestLatitude = document.getElementById('forestLatitude').value;
			var forestLongitude = document.getElementById('forestLongitude').value;

			console.log(forestLatitude);
			console.log(forestLongitude);
			var options = {
				center : new kakao.maps.LatLng(forestLatitude, forestLongitude),
				level : 3
			};

			var map = new kakao.maps.Map(container, options);

			// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
			var zoomControl = new kakao.maps.ZoomControl();
			map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

			var imageSrc = '${pageContext.request.contextPath}/resources/images/travelInformation/greenHouse.png', // 마커이미지의 주소입니다    
			imageSize = new kakao.maps.Size(35, 46), // 마커이미지의 크기입니다
			imageOption = {
				offset : new kakao.maps.Point(27, 69)
			}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

			// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,
					imageOption), markerPosition = new kakao.maps.LatLng(
					forestLatitude, forestLongitude); // 마커가 표시될 위치입니다

			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				position : markerPosition,
				image : markerImage
			// 마커이미지 설정 
			});

			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
		</script>
	</div>
	<!-- 테이블과 지도 묶기 끝-->


	<table id="listTable" cellspacing="0" border="0">
		<div style="background-color: #ccffcc;"><h1>이용가능 숙박</h1></div>
		<tr>
			<th>숙박이미지</th>
			<th>숙박이름</th>
			<th>1박가격</th>
			<th>숙박 이용정보</th>
			<th>숙박주소</th>
			<th>전화번호</th>
			<th></th>
			<th></th>
		</tr>



	</table>
</body>
</html>