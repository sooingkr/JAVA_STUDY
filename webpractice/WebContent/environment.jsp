<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileInputStream"%>
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
 	
 	ResourceBundle bundle = ResourceBundle.getBundle("information");
	Enumeration e = bundle.getKeys();
	while ( e.hasMoreElements() ) {
		String key = (String)e.nextElement();
		String value = bundle.getString(key);
		out.println("key : " + key + " value : " + value);
	}
 %>
</body>
</html>