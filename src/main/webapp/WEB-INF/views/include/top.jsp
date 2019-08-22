<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
		<meta charset="UTF-8">
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="${path}/resources/js/jquery.min.js"></script>
		<script src="${path}/resources/js/jquery.dropotron.min.js"></script>
		<link rel="stylesheet" href="${path}/resources/css/style.css">
		<link rel="stylesheet" href="${path}/resources/css/style-wide.css">
		<link rel="stylesheet" href="${path}/resources/css/style-normal.css">
		<script src="${path}/resources/js/skel.min.js"></script>
		<script src="${path}/resources/js/skel-layers.min.js"></script>
		<script src="${path}/resources/js/init.js"></script>
		<link rel="stylesheet" href="${path}/resources/css/skel.css" />
		<link rel="stylesheet" href="${path}/resources/css/style.css" />
		<title>For Rest : 휴양림 예약 사이트</title>
	</head>
	<body class="homepage">
		<!-- Header Wrapper -->
		<div class="wrapper style1">
			<!-- Header -->
			<div id="header">
				<div class="container">
					<!-- Logo -->
					<h1><a href="#" id="logo">FORREST</a></h1>
					<!-- Nav -->
					<nav id="nav">
						<ul>
							<li class="active"><a href="hometest">Home</a></li>
							<li><a href="${path}/forest/list">통합 예약</a></li>
							<li><a href="${path}/travelInformation">여행 정보</a>
								<ul>
									<li><a href="${path}/travelInformation">여행 정보</a></li>
								</ul>
							</li>
							<li><a href="">공지/문의</a>
								<ul>
									<li><a href="#">공지 사항</a></li>
									<li><a href="${path}/list">자주 묻는 질문</a></li>
									<li><a href="#">1 대 1 문의</a></li>								
								</ul>
							</li>
							<li><a href="#">마이 페이지</a></li>
						</ul>
					</nav>	
				</div>
			</div>
		</div>
	</body>
</html>