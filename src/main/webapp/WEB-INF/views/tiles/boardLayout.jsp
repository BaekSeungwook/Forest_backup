<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForRest: 휴양림 예약 사이트</title>

</head>
<body>
	<div>
	 	<tiles:insertAttribute name="top"/>
	 </div>
	 <br><hr>
	 <div>
	 	<tiles:insertAttribute name="content"/>
	 </div>
	 <br><hr><br>
	 <div>
	 	<tiles:insertAttribute name="footer"/>
	 </div>
</body>
</html>