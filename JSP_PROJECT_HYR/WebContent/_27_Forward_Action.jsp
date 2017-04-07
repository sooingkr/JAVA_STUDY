<%--
	데이터 처리 부분
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String code = request.getParameter("code");
	String requestValue = null;
	String urlCode = null;
	
	if (code.equals("A") ) {
		urlCode = "./module/a.jsp";
		requestValue = "A Value 전달값";
	} else if (code.equals("B")) {
		urlCode = "./module/b.jsp";
		requestValue = "B Value 전달값";
	} else {
		urlCode = null;	
		requestValue = null;
	}
%>
<html>
	<body>
		<%
			if ( urlCode != null ){
		%>
				<jsp:forward page="<%= urlCode %>">
					<jsp:param name="requestValueName" value="<%= requestValue %>" />
				</jsp:forward>
		<%
			}else {
				response.sendRedirect("http://www.google.com");
			}
		%>
	</body>
</html>