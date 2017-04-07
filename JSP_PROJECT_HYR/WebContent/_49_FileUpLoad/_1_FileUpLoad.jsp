<%--
		[	FileUpLoad	  ]
		1. 파일 업로드 라이브러리 다운로드 및 설치
		http://www.servlets.com 접속 후 좌측의 com.oreilly.servlet 킬릭해 다운
 		압축을 해제하고 lib 폴더 안에 있는 cos.jar 파일을
 		WEB-INF/lib 위치에다가 넣어준다.
 		
 		2. 업로드시 파일이 저장될 디렉토리를 만들고 설정한다. _49_UploadFileStorage 라고 만들었다.
 		
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./fileFormOk.jsp" enctype="multipart/form-data">
		<!-- fileupload할려면 enctype을 multipart/form-data로 줘야함. -->
		파일 : <input type="file" name-"file" /><br/>
		<input type="submit" value="File Upload" />
	</form>
</body>
</html>