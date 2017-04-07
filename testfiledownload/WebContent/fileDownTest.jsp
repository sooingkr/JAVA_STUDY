<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/uploadPro.jsp"
		method="post" enctype="multipart/form-data">

		<회원가입 양식>
		<br>
		이름: <input type="text" name="m_name">
		<br>
		별명: <input type="text" name="m_nickname">
		<br>
		사진: <input type="file" name="m_file">
		<br>
		<br>

		<input type="submit" value="전송~">
	</form>
</body>
</html>