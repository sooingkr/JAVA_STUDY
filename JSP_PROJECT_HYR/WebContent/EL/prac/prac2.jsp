<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
	%>
	param name : ${param.name}<br/>
	requestScope name : ${requestScope.name}<br/>
	sessionScope name : ${sessionScope.sessionName}<br/>
	applicationScope name : ${applicationScope.applicationName }<br/>
	requestScope name : ${requestScope.requestName}<br/>
	
	pet params values :
		<c:set var="pets" value="${paramValues.pet}"/>
		<c:forEach var="show" items="${ pets }">
			${show} ,
		</c:forEach>
	
</body>
</html>