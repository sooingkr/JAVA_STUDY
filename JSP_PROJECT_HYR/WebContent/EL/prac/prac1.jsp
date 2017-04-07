<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./prac2.jsp" >
		name : <input type="text" name="name" />
		pet : <input type="checkbox" name="pet" value="고양이" />고양이
		pet : <input type="checkbox" name="pet" value="개" />개
		pet : <input type="checkbox" name="pet" value="토끼" />토끼
		<input type="submit" value="제출" />
	</form>
	<%
		request.setAttribute("requestName", "requestValue");
		session.setAttribute("sessionName","sessionValue");
		application.setAttribute("applicationName","applicationValue");
	%>
</body>
</html>