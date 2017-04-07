<%@page import="javaBean.memberEx"%>
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
		memberEx m = (memberEx)session.getAttribute("MEMBERSESSION");
		
		
	%>
	
	회원가입한 회원 정보 : <br/>
	
<%-- 	ID : <jsp:getProperty property="id" name="m"/> <br/> --%>
<%-- 	PWD : <jsp:getProperty property="pwd" name="m"/> <br/> --%>
<%-- 	EMAIL : <jsp:getProperty property="email" name="m"/> <br/> --%>
<%-- 	ADDRESS : <jsp:getProperty property="address" name="m"/> <br/> --%>

	<%
		out.println("ID : " + m.getId() + "<br/>");
		out.println("PWD : " + m.getPwd() + "<br/>");
		out.println("EMAIL : " + m.getEmail() + "<br/>");
		out.println("ADDRESS : " + m.getAddress() + "<br/>");
	%>
</body>
</html>