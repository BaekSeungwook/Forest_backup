<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ForRest</title>

<style type="text/css">
	a{text-decoration:  none;}
</style>
<script type="text/javascript">
	function logout() {
		document.getElementById("logoutFrm").submit();
	}
</script>

</head>
<body>
<h2>Spring Security를 이용한 Register Member</h2>
<sec:authorize access="isAnonymous()">
<ul>
	<li><a href="${pageContext.request.contextPath}/registerForm">회원 가입 하기</a></li>
	<li><a href="${pageContext.request.contextPath}/loginForm">로그인 하기</a></li>
	<li><a href="${pageContext.request.contextPath}/findMemberByIdForm">회원 검색 하기</a></li>
</ul>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="mvo" property="principal" /> 
	<b>${mvo.name}님 환영합니다.</b><p>
	
	<!-- 
		authentication의 getPrincipal().getName() ::
		Principal은 Provider 에서 Authentication에 넣어준 VO(생성자의 첫 매개변수)
	 -->		
</sec:authorize>
<p></p>
<!-- 인증됬으면 -->
	<sec:authorize access="isAuthenticated()">
		<!-- 관리자인 경우 -->
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="${pageContext.request.contextPath }/admin/enterCafe">ADMIN Cafe Enterance</a></li>
		</sec:authorize>
		
		<!--  일반 회원이거나 관리자인 두 경우. 두개 이상의 role을 비교할때 hasAnyRole()-->
		<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')">
			<li><a href="${pageContext.request.contextPath }/member/updateForm">정보 수정 폼</a></li>
			<li><a href="${pageContext.request.contextPath }/member/addressList">주소별 검색 하기</a></li>
		</sec:authorize>
		<li><a href="javascript:logout();">로그아웃</a></li>
	</sec:authorize>
<p>

<!--  
1. 로그아웃은 스프링 시큐러티 4부터는 로그아웃시 post 방식으로 이동하며 
  /logout url로 요청한다(따로 정의하지 않으면...)
2. _csrf 를 요청 파라미터로 보내야 한다.
-->
<form id="logoutFrm" action="${pageContext.request.contextPath}/member/logout" method="post" style:"display:none">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
</form>
</body>
</html>