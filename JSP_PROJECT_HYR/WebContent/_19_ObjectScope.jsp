<%--
	속성 관련 메서드)
			- setAttribute(String name,Object value)
			- getAttribute(~~)
			- getAttributeNames(); return Enumeration
			- removeAttribute(~~)
			
		** 이때, name의 type은 String이지만 읽어올 수 있는 value는 모든 타입이 가능하도록 Object이다.
 --%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
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
		session.setAttribute("session_start", new java.util.Date());
		session.setAttribute("memberid", "madvirus");
		application.setAttribute("application_temp", new File("c:\\temp"));

		Date date = (Date) session.getAttribute("session_start");
		String memberID = (String) session.getAttribute("memberid");
		File tempDir = (File) application.getAttribute("application_temp");

		request.setAttribute("age", new Integer(20)); // 원래 참조타입을 넣도록되어있어서
		// 기본 데이터 타입의 경우 래퍼클래스를 사용해서 넣어야하지만,
		// 요즘 자바는 오토박싱과 오토 언박싱을 제공하기 때문에
		request.setAttribute("age2", 20); // 처럼 넣어도 된다.
		int age = (int)request.getAttribute("age2"); // 오토 언박싱
		Integer ageAttr = (Integer)request.getAttribute("age");
		int ageAttrVal = ageAttr.intValue();
		
	%>
</body>
</html>