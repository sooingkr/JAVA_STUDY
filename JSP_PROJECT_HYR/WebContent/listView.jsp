<%@page import="_50_Board_Module_Study_package.MessageListObject"%>
<%@page import="_50_Board_Module_Study_package.GetMessageListService"%>
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
	<form action="./writeMessage.jsp" method="post">
		이름 : <input type="text" name="guestName" /><br/>
		암호 : <input type="password" name="password" /><br/>
		메시지 : <textarea name="message" cols="30" rows="3"></textarea><br/>
		<input type="submit" value="메시지 남기기" />
	</form>
	<hr/>
	
	<%
		String pageNumberStr = request.getParameter("page");
		int pageNumber = 1;
		if ( pageNumberStr != null ){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		GetMessageListService messageListService = GetMessageListService.getInstance();
		MessageListObject viewData = messageListService.getMessageList(pageNumber);
		
	%>
	<c:set var="viewData" value="<%= viewData %>"/>
	<c:if test="${viewData.messageList == null }">
		등록된 메시지가 없습니다.
	</c:if>
	
	<c:if test="${viewData.messageList != null }">
		<table border="1">
			<c:forEach var="message" items="${viewData.messageList}">
				<tr>
					<td>
						메시지 번호 : ${message.id}<br/>
						손님 이름 : ${message.guestName}<br/>
						메시지 : ${message.message}<br/>
						<a href="/confirmDeletion.jsp?messageId=${message.id}">[삭제하기]</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>