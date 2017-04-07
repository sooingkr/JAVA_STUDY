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
	이름 : <%= name %>
	
	아이디 : ${param.name}<br/>
	동일방식 : ${param[name]}<br/>
	pet paramValues : 
		<c:set var="pets" value="${paramValues.pet}"/>
		<c:forEach var="temp" items="${pets}">
				${temp}<br/>
		</c:forEach>
	
	
	내장객체 접근... : <br/>
	applicationScope : ${applicationScope.application_name }<br/>
	sessionScope : ${sessionScope.session_name }<br/>
	pageScope : ${pageScope.pageContext_name }<br/>
	requestScope : ${requestScope.request_name }<br/>
	
	
	<jsp:useBean id="bookName" class="book_self.BookDTO"/>
	bookName.getTitle() : ${bookName.title}<br/>
	
	
	
	context 초기화 파라미터 : <br/>
	${initParam.errorValue }<br/>
	${initParam.fp }<br/>
</body>
</html>