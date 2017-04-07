<%--
	[	Session 이용한 로그인 처리 예제	]
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if ( "sooingkr".equals(id) && "dudfhd13".equals(pwd) ){
			// 로그인에 성공하면, 세션에 값을 저장한다.(생성)
			session.setAttribute("LOGINID", id);
			session.setAttribute("LOGINPWD",pwd);
		}else {
			
			
	%>
		<script type="text/javascript">
			alert("로그인에 실패했습니다.");
			history.go(-1);
		</script>
	<%
		}
	%>
</body>
</html>