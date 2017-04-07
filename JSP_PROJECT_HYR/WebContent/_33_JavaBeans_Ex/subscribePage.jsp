<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	회원 가입 : <br/>
	<form action="./process.jsp">
		이름 : <input type="text" name="name" /><br/>
		나이 : <input type="number" name="age" /><br/>
		주소 : <input type="text" name="addr" /><br/>
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>