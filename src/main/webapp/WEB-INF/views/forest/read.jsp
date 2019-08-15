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
</body>
</html>