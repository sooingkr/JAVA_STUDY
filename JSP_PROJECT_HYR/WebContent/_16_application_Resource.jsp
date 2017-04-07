<%--
	application 객체를 이용해 웹어플리케이션 자원에 접근하기.
 --%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	request.setCharacterEncoding("EUC-KR");
    	response.setCharacterEncoding("EUC-KR");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//String filePath = "./resourceFile/applicationTestFile.txt";
		String filePath = "/resourceFile/applicationTestFile.txt";
		filePath = application.getRealPath(filePath);
		out.println(filePath + "<br/>");
		out.println(request.getContextPath()+"<br/><br/>");
		
		FileInputStream f = new FileInputStream(filePath);
		//InputStreamReader in = new InputStreamReader(application.getResourceAsStream("./resourceFile/applicationTestFile.txt"),"EUC-KR");
		InputStreamReader in = new InputStreamReader(f,"EUC-KR");
		BufferedReader b = new BufferedReader(in);
		
		while(true){
			String str = b.readLine();
			if ( str == null ){
				break;
			}
			out.println(str + " ");
		}
	%>
</body>
</html>