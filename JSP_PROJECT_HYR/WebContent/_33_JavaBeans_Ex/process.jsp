<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="_33_JavaBeans_DTO.Member"/>
	<jsp:setProperty name="member" property="*"/>
	
	<%
		request.setAttribute("Mem", member);
		String pass = "안녕하세요";
		
	%>
	<jsp:forward page="./view.jsp">
		<jsp:param value="<%= pass %>" name="hello"/>
	</jsp:forward>
</body>
</html>