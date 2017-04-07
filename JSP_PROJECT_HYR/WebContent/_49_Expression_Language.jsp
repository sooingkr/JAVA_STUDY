<%--
		[	 표현언어(Expression Language)	]
 	: JSP 페이지에서 스크립틀릿과 같은 자바 코드를 대체하는 방법
 		특징)
 			- 값이 null이어도 예외가 발생하지 않음(빈값으로 인식)
 			- 항상 ${ 로 시작해서 }로 끝남
 			 ex) ${num}
 			- 표현식 안에 연산도 쓸 수 있다.
 			 ex) ${num+1}
 			 
 		[	EL 변수의 사용 방법	]
 		[	내장 객체의 표현	]
 		: 내장 객체는 ${내장객체.변수명}과 같이 사용됨
 		
 		- 변수의 사용 범위
 			- 현재 페이지에서만 사용 가능
 				pageContext
 				${pageScope.변수} 
 			- 요청페이지 + 응답페이지
 				request
 				${requestScope.변수} == request.getAttribute("변수")
 			- 사용자 단위(로그인 ~ 로그아웃)
 				session
 				${sessionScope.세션변수명}  // sessionScope : 세션 변수를 조회할 때 사용
 				== session.getAttribute("세션변수명")
 			- 서버 단위(모든 사용자)
 				application
 				${ applicationScope.변수 } == application.getAttribute("변수")
 			- get방식이나 post 방식으로 넘어가는 변수
 				request.getParameter
 				== ${param.변수}	
 				request.getParameterValues("변수명") == ${paramValues.배열변수명}
 				
 		
 		
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
	${2+5}<br/>
	${4 / 5 }<br/>
	${7 mod 5 }<br/>
	${2<3}<br/>
	3.1 le 3.2 = ${3.1 le 3.2 }<br/> <!--  le : 작다. -->
	3.1 <= 3.2 = ${3.1 <= 3.2 }<br/> <!--  -->
	
	${ (5>3) ? 5 : 3 }<br/>
	
	
</body>
</html>