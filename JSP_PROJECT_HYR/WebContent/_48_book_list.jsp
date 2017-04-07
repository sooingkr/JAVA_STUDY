<%--
	book 목록 출력 View
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="book_self.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book_self.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="책등록하기:버튼" 
			   onclick="location.href='./_48_enrollBook.jsp'"/>
	<a href="./_48_enrollBook.jsp">책등록하기:a태그</a>
	<!-- 
		이동 관련
			- JavaScript에서 이동 : location 객체의 href 속성
			- JSP 에서 이동 : - 포워드 액션, response.sendRedirect
	 -->
	<table>
		<tr>
			<th>ID</th>
			<th>제목</th>
			<th>저자</th>
			<th>가격</th>
			<th>수량</th>
		</tr>
		<%
			BookDAO dao = new BookDAO();
			
			ArrayList<BookDTO> list = dao.bookList();
			for( BookDTO dto : list ){
		%>
			<tr>
				<td><%= dto.getId() %></td>
				<td><%= dto.getTitle() %></td>
				<td><%= dto.getAuthor() %></td>
				<td><%= dto.getPrice() %></td>
				<td><%= dto.getQty() %></td>
			</tr>
		<%
			}
		%>
		
	</table>
	
</body>
</html>