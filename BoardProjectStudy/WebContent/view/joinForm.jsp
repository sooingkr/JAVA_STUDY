<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	회원가입 페이지
	<form method="POST" action="join.do">
		<p>
			아이디 : <br/> <input type="text" name="id" value="${param.id}" />
			<!-- 
				param.id 는 전송버튼 눌렀는대 잘못된 입력이 이루어져 다시 폼으로 돌아올 때 기존에 입력해둔 값이 유지되도록 하기 위함
			 -->
			 <!-- 
			 	request에 저장해 뒀던 errors 해시 맵 객체의 이름으로 바로 접근할 수 있다.(EL)
			  -->
			<c:if test="${errors.id}">
				아이디를 입력하세요.
			</c:if>			 
			<c:if test="${errors.duplicated}">
				이미 사용중인 아이디입니다.
			</c:if>
		</p>
		
		<p>
			이름:<br/><input type="text" name="name" value="${param.name}"/>
			<c:if test="${errors.name}">
				이름을 입력하세요.
			</c:if>
		</p>
		<p>
			암호:<br/><input type="password" name="password">
			<c:if test="${errors.password}">
				암호를 입력하세요.
			</c:if>
		</p>
		<p>
			확인:<br/><input type="password" name="confirmPassword"/>
			<c:if test="${errors.confirmPassword }">
				비밀번호 확인을 입력하세요.
			</c:if>
			<c:if test="${errors.noMatchPWD }">
				암호와 확인이 일치하지 않습니다.
			</c:if>
		</p>
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>