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
<%
	request.setCharacterEncoding("UTF-8");
// post에만 적용됨.
// server.xml에 Connector 태그에서 URIEncoding="UTF-8"로 지정

	 out.println("요청 URI : " + request.getRequestURI());
	 out.println("요청자 IP : " + request.getRemoteAddr());
	 out.println("웹프로젝트 파일 경로 : " + request.getContextPath() + "\n");
	 String name = request.getParameter("name");
	out.println("전달받은 값 : " + name);
	
	// checkbox 등을 통해 같은 이름으로 여러 값을 보내는 경우
	String[] values = request.getParameterValues("name");
	Enumeration e = request.getParameterNames();
	while(e.hasMoreElements()){
		out.println(request.getParameter((String)e.nextElement()));
	}
%>
</body>
</html>