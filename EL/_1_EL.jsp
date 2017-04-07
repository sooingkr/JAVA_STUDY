<%--
		[	EL(Expression Language)	]
		: 표현식, 스크립트릿의 사용을 줄이기 위해 나옴(스크립트릿의 가독성 저하 방지)
	
		사용되는 객체)
			
			- pageScope
			- requestScope.name
			- sessionScope.name
			- applicationScope.name
			- cookie.ID.value	
			- member.title => member 객체의 getTitle() 호출
			- param : 요청파라미터를 참조하는 객체
			- paramValues : 요청 파라미터(배열)을 참조하는 객체
 			- initParam : 초기화 파라미터를 참조하는 객체
 			
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
	${10 }<br/>
	${10.5 }<br/>
	${"ABC"}<br/>
	${true}<br/>
	
	<!--  연산자 자바랑 same -->
	${10 > 3}<br/>
	${4%2}<br/>
	${((3+5)==8) ? true : false }<br/>
	
	
</body>
</html>