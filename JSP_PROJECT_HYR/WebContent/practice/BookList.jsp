<%--
	책 목록을 출력
 --%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
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
	<%
	BookDAO bookDAO = new BookDAO();
	ArrayList<BookDO> al = null;
	al = bookDAO.getBookList();
	
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>AUTHOR</th>
			<th>PRICE</th>
			<th>QTY</th>
		</tr>
		<%
			for(BookDO b : al){			
		%>
				<tr>
					<td>
						<%= b.getId()%>
					</td>
					<td>
						<%=b.getTitle()%>
					</td>
					<td>
						<%=b.getAuthor() %>
					</td>
					<td>
						<%=b.getPrice() %>
					</td>
					<td>
						<%=b.getQty() %>
					</td>
				</tr>
		<%
			}	
		%>
	</table>
	
	<input type="button" value="책등록하기" onclick="location.href='./EnrollBook.jsp'"/>
</body>
</html>