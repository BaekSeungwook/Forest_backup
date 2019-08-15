<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.data:hover {
	background: #f0f0f0;
	cursor: pointer;
}

ul li {
	width: 50%;
	float: left;
	list-style: none;
	padding: 10px;
}

ol li {
	color: black;
}
a {
	text-decoration: none !important;
}

ul:after {
	content: '';
	display:block;
	clear:both;
}

ul {
    width: 100%;
    height: auto;
    padding: 0;
}

.list_img {
    width: 55%;
    display: inline-block;
}

.list_content {
    width: 44%;
    display: inline-block;
    vertical-align: middle;
    padding:0 10px;
}

div.data{
	padding:15px;	
}

div.data:after {
	content:'';
	display:block;
	clear:both;
}
</style>
<script type="text/javascript">
$(function(){
	$(".data").click(function(){
		var forestNo=$(this).find("[name=forestNo]").val();
		location="${pageContext.request.contextPath}/forest/read/"+forestNo;
	})
})
</script>


</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<table align="center" border="0" class="w3-main w3-content w3-padding">

<div style="margin-bottom: 10px">
	<div align="center">
		<button type="button" class="btn btn-info">
			<a href="${path}/forest/write" style="font-size:large; color: white">휴양림정보 등록</a>
		</button>
	</div>

	<div align="center" style="padding: 10px 0px;">
		<select name="keyField"
			style="height: 32px; display: inline-block; vertical-align: middle;">
			<option value="0">--선택--</option>
			<option value="searchName">휴양림 이름</option>
			<option value="searchLocation">지역</option>
		</select> <input type="text" name="keyWord"
			style="height: 32px; display: inline-block; vertical-align: middle;">
		<button type="button" class="btn btn-default" id="searchBtn">
			<i class="glyphicon glyphicon-search"></i>
		</button>
	</div>
</div>

<ul>
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td>
					<p align="center">
						<b><span style="font-size: 12pt;">등록된 글이 없습니다.</span></b>
					</p>
				</td>
			</tr>
		</c:when>
		<c:otherwise>

			<c:forEach items="${list}" var="forestDTO">
				<li>
				<div class="data" style="width: 100%;border-radius: 50px;" align="center">
					<input type="hidden" name="forestNo" value="${forestDTO.forestNo}" id="no">
					<div class = "list_img">
					
					<c:if test="${!empty forestDTO.forestFilename }" >
              		<img class="image" style="width: 100%; height: 100%;border-radius: 50px;"
              			src="${pageContext.request.contextPath}/resources/images/rest.jpg">
              		</c:if>
	          		<c:if test="${empty forestDTO.forestFilename }" >
			          <img class="imagenone" src="https://upload.wikimedia.org/wikipedia/commons/6/6c/No_image_3x4.svg">
			        </c:if>
						
					</div>
					
				<div class = "list_content">
						<%-- <img src="${path}/views/forest/save/${forestDTO.forestFileName}"> --%>
						<h1>${forestDTO.forestName}</h1>
					<h3>${forestDTO.forestType}</h3>
					<br>
					<div style="font-weight: bold">${forestDTO.forestAddr}</div>
					<br>
					<div style="font-weight: bold">${forestDTO.forestTel}</div>
					<br>
					<div style="font-weight: bold; width: 100px;">
					  <a href="${forestDTO.forestUrl}">
					    <i class='fas fa-home' style="color: red;"></i> 홈페이지로이동
					  </a>
					</div>
					
				</div>
				<br>
				</div>
				</li>
			</c:forEach>
			
		</c:otherwise>
	</c:choose>
</ul>
</table>

</body>
</html>