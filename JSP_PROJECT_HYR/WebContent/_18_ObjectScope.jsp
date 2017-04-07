<%--
		속성 관련 메서드)
			- setAttribute(String name,Object value)
			- getAttribute(~~)
			- getAttributeNames(); return Enumeration
			- removeAttribute(~~)
			
		** 이때, name의 type은 String이지만 읽어올 수 있는 value는 모든 타입이 가능하도록 Object이다.
 --%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	다른 페이지에서 application에 저장한 데이터들이 전체 웹프로젝트에서 공유하는 것을 테스트한다. :
	<br />
	<%
		Enumeration e = application.getAttributeNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			Object value = application.getAttribute(name);
			out.println("application 속성 : " + "<b>" + name + "</b> = " + value + "<br/>");
		}
	%>
</body>
</html>