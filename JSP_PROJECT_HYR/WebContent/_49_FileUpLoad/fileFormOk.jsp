<%@page import="java.util.Enumeration"%>
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
		String path = application.getRealPath("/JSP_PROJECT_HYR/_49_UploadFileStorage");
		//파일이 저장되는 장소경로
		int size = 1024 * 1024 * 10; // 10M까지 업로드 가능하도록... 용량 지정
		String file = ""; // 파일이름
		String oriFile = ""; // 올렸는데 기존 데이터중에 이름이 같은게 있을 때
		// 다른 파일인데 이름이 동일할 경우 본래 이름뒤에 + (2)이런식으로 붙여서 저장하는데
		// 이때 (2) 부분 제외한 본래 파일명을 저장해 놓기 위한 변수
		
		try{
		MultipartRequest multi = new MultipartRequest(request, path, size, "EUC-KR", new DefaultFileRenamePolicy());
		// DefaultFileRenamePolicy() : 동일이름일 때 (2) 같은 문구 추가해주는 기능
		Enumeration files = multi.getFileNames();
		String str = (String)files.nextElement();
		
		file = multi.getFilesystemName(str);
		oriFile = multi.getOriginalFileName(str); // 실제 파일 이름
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	
	file upload success!
</body>
</html>