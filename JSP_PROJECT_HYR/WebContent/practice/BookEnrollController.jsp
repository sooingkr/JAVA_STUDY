<%--
	책 등록 처리
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bookPrac.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bookInfo" class="bookPrac.BookDO"/>
	<jsp:setProperty property="*" name="bookInfo"/>
	
	<%
		BookDAO bookDAO = new BookDAO();
		bookDAO.insertBook(bookInfo);
		out.println(bookInfo.getTitle() + "이 추가되었다.");
		response.sendRedirect("./BookList.jsp");
	%>
</body>
</html>