<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<SCRIPT type="text/javascript">
$(function(){
	$("#cancleBtn").click(function(){
		history.back();
	})
}) 	
</SCRIPT>


</HEAD>
<BODY>
<form name="writeForm" method="post" action="${pageContext.request.contextPath}/forest/insert?${_csrf.parameterName}=${_csrf.token}" 
 enctype="multipart/form-data" style="margin-top: 100px;">

<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >
  	<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="black">
            <p align="center"><font color="white" size="3"><b>휴양림 정보등록</b></font></p>
        </td>
    </tr>
    <tr>
        <th width="150" height="20" >
            <p align="right"><b><span style="font-size:12pt;">휴양림이름</span></b></p>
        </th>
        <td width="450" height="20"><b><span style="font-size:12pt;">
		<input type=text name="forestName" size="30"></span></b></td>
    </tr>
    <tr>
        <th width="150" height="20" >
            <p align="right"><b><span style="font-size:12pt;">휴양림유형</span></b></p>
        </th>
        <td width="450" height="20"><b><span style="font-size:12pt;">
		<input type=text name="forestType" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">주요 시설</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:12pt;">
		<input type=text name="forestFacil" size="30" style="height: 100px"></span></b></td>
    </tr>

    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">휴양림 주소</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:12pt;">
		<input type=text name="forestAddr" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">휴양림전화번호</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:12pt;">
		<input type=text name="forestTel" size="30"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">지역</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:12pt;">
		<input type=text name="city" size="30"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">휴양림이미지 파일</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="forestFile" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:12pt;">작성자</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:12pt;">
		<input type=text name="forestWriter" size="30"></span></b></td>
    </tr>
    
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=등록하기> 
        <input type=reset value=초기화>
        <input type="button" value="취소" id="cancleBtn"></span></b></td>
    </tr>
</table>

</form>

<hr>

</BODY>