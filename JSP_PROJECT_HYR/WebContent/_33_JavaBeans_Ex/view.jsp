<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${requestScope.Mem.name}<br/>
	나이 : ${requestScope.Mem.age }<br/>
	주소 : ${requestScope.Mem.addr}<br/>
	입니다.
	
	전달받은 값 : ${param.hello}
	<%
		
	%>
</body>
</html>