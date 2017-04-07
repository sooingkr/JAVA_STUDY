<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인 화면입니다.<br/>
	
	<c:if test="${errors.noMatch}">
		아이디와 암호가 일치하지 않습니다.
	</c:if>
	
	<form action="login.do" method="post">
		ID : <input type="text" name="id" value="${param.id}" />
		<c:if test="${errors.id}">
			아이디를 입력해 주세요.
		</c:if>
		Pwd : <input type="password" name="password" />
		<c:if test="${errors.pwd}">
			비밀번호를 입력해 주세요.
		</c:if>
		<br/>
		<input type="submit" value="로그인" />
	
	</form>
</body>
</html>