<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="./js/jquery-1.11.3.js"></script> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var checkResultId="";		
	$("#regForm").submit(function(){			
		if($("#regForm :input[name=userId]").val().trim()==""){
			alert("아이디를 입력하세요");				
			return false;
		}
		if($("#regForm :input[name=userPwd]").val().trim()==""){
			alert("패스워드를 입력하세요");				
			return false;
		}
		if($("#regForm :input[name=userName]").val().trim()==""){
			alert("이름을 입력하세요");				
			return false;
		}
		if($("#regForm :input[name=userAddr]").val().trim()==""){
			alert("주소를 입력하세요");				
			return false;
		}	
		if(checkResultId==""){
			alert("아이디 중복확인을 하세요");
			return false;
		}		
	});//submit
	
	
	//아이디 체크...
	$("#regForm :input[name=userId]").keyup(function(){
		var id=$(this).val().trim();
		//alert(id);
		if(id.length<4 || id.length>10){
			$("#idCheckView").html("4>id length OR id length>10").css("background","pink");
			checkResultId="";
			return;
		}
		
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/idcheckAjax",				
			data:"${_csrf.parameterName}=${_csrf.token}&id="+id,	
			success:function(result){						
				if(result=="fail"){
				$("#idCheckView").html("  "+id+" ID Can't Use!! ").css("background","red");
					checkResultId="";
				}else{						
					$("#idCheckView").html("  "+id+" ID Can Use!! ").css("background","yellow");		
					checkResultId=id;
				}					
			}//callback			
		});//ajax
	});//keyup
});//ready
</script>
</head>
<body>
<h2>Member Register Form</h2><p>
<form method="post" action="${pageContext.request.contextPath}/registerSuccess" id="regForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
ID <input type="text" name="userId" id="id"><span id="idCheckView"></span><br><br>
PASSWORD <input type="password" name="userPwd"><br><br>
NAME <input type="text" name="userName"><br><br>
ADDRESS <input type="text" name="userAddr"><br><br>
UERT TYPE <input type="radio" value="0" name="userType">ROLE_MEMBER
		  <input type="radio" value="1" name="userType">ROLE_ADMIN<br><br>
<input type="submit" value="Register Member">
</form>
</body>
</html>













