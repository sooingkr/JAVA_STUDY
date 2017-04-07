<%--
	jsp:param의 단점)
			: jsp:param의 경우 value 값이 문자열(String)만 올 수 있다. 따라서, 객체나 문자열 이외의 것을 전달할 때는
			  전달하기 어렵다는 단점이 있다.
			  
			  이를 해결하려면, 일반 공유 객체(page, request, application, session) 등에 담아서 전달하는 방식을 취해야 한다.
			  
			  예를들면)
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		java.util.Date now = new java.util.Date();
		request.setAttribute("DateName", now);
	
	%>
	<jsp:forward page="./_29_Forward_Action_Parameter.jsp" />
	<!-- 
		request 객체에 담아서 페이지 요청시 request 객체가 같이 넘어간다!
		일반 공유 객체의 setAttribute, getAttribute의 value값은 Object이기 때문에 모든 타입을 저장할 수 있다.!
		setAttribute(String name, Object value);
	 -->
</body>
</html>