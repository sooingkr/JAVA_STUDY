<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	String savePath = request.getServletContext().getRealPath("/fileDown");
	 
	// 파일 크기 15MB로 제한
	int sizeLimit = 1024*1024*15;
	 
	MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
	
	out.println("파일이름 : " + multi.getFilesystemName("m_file"));
	out.println("파일저장 풀 경로 : " + (savePath + "/" + multi.getFilesystemName("m_file")));
	
	%>

	파일용량 :

</body>
</html>