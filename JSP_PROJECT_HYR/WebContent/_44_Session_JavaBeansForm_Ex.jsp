<%--
		[	Session과 자바빈즈를 활용한 로그인 인증 예제  ]
		
		: 회원가입할 경우 회원과 관련된 데이터 즉, 비슷한 데이터는 하나의 자바빈즈 클래스를 만들어서 관리하는 것이
		  관리의 효용성이 높을 것이다. (자바빈즈 : DO)
		  따라서, 세션과 자바빈즈를 이용해 데이터를 저장하고 가져오는 간단한 예제를 만들어 보자.
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
	회원가입 폼 : <br/>
	<form action="./_44_Session_JavaBeans2.jsp">
		ID : <input type="text" name="id" />
		PWD : <input type="password" name="pwd" />
		email : <input type="text" name="email" />
		address : <input type="text" name="address" />
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>