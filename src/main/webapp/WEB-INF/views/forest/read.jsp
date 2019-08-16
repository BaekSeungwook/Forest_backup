<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>

<style type="text/css">
th {
	background-color: #FAEBD7;
}
td {
	background-color: white;
}
.table{
	display: inline-block;
}
#map{
	height : "100%";
	display: inline-block;
}
</style>

<script type="text/javascript">
$(function(){
	
	$("#updateBtn").click(function(){
		var forestNo=$(this).prev().val();
		location="${pageContext.request.contextPath}/forest/updateForm?forestNo="+forestNo;
	})	
	
	
	$("#deleteBtn").click(function(){
		if(confirm("정말로 삭제하시겠습니까?")){
			var forestNo=$(this).prev().prev().val();
			//alert(forestNo);
			location="${pageContext.request.contextPath}/forest/delete?forestNo="+forestNo;
		}		
	});
	
	$("#listBtn").click(function(){
		history.back();
	})
})
</script>

</head>
<body>
<div class="panel-heading" align="center"><h1><strong>${dto.forestName}</strong> 상세 정보</h1></div>
    <div><!-- 테이블과 지도 묶기 -->
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
	      <td colspan="3">
	      <img src="${pageContext.request.contextPath}/resources/images/rest.jpg" style="width: 600px; height: 400px;"/><br/>
	      
		  <%-- ${dto.forestFilename } --%>
	  	  </td>
	      </tr>
	      <tr>
	      	<th >휴양림 이름</th>
	        <td>${dto.forestName }</td>
	        
	      	<th >휴양림 운영 유형</th>
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
	    	<tr>
	    		<td colspan="4">
	    			<input type="hidden" name="forestNo" value="${dto.forestNo}" id="no">
	    			<button id="updateBtn">수정</button>
	    			<button id="deleteBtn">삭제</button>
	    			<button id="listBtn">리스트</button>
	    		</td>
	    	</tr>
	    </tfoot>
	  </table>
	  <div id="map" style="width:500px;height:400px;"></div>
	  <input type="hidden" id="forestLatitude" name="forestLatitude" value="${dto.forestLatitude}">
	  <input type="hidden" id="forestLongitude" name="forestLongitude" value="${dto.forestLongitude}">
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e826b64479600b9534daecd6858732f0"></script>
	<script>
		var container = document.getElementById('map');
		
		var forestLatitude = document.getElementById('forestLatitude');
		var forestLongitude = document.getElementById('forestLongitude');
		
		console.log(forestLatitude);
		console.log(forestLongitude);
		var options = {
			center: new kakao.maps.LatLng(forestLatitude, forestLongitude),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
		var zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
		
		var imageSrc = '${pageContext.request.contextPath}/resources/images/travelInformation/greenHouse.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(35, 46), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	      
		// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
		    markerPosition = new kakao.maps.LatLng(forestLatitude, forestLongitude); // 마커가 표시될 위치입니다
	
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition, 
		    image: markerImage // 마커이미지 설정 
		});
	
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
	</script>
	</div><!-- 테이블과 지도 묶기 끝-->
</body>
</html>