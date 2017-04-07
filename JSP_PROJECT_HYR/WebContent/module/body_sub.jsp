<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	name 파라미터 값 목록 :
	<ul>
		<%
			String[] names = request.getParameterValues("name");
			for(String name : names){
				out.println("<li>" + name + "</li>");
			}
		%>
		<!-- 
			황영롱, cbk 두개의 값이 출력됨을 알 수 있음.
		 -->
	</ul>
</body>
</html>