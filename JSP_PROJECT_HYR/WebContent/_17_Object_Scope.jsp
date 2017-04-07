<%--
		[	객체들의 Scope	]
		1. page 객체(pageContext) : 하나의 JSP 페이지에서 공유할 변수 등을 지정할 때 사용된다.(단위 : 페이지)
				=> 주로, 커스텀 태그의 변수를 추가할 때 사용된다.
		2. request 객체(request) : 단위) 하나의 요청 => 모든 JSP 페이지에 대해서 "한번의 요청"이 단위가 된다.
				=> 요청을 하고 요청을 받고나면 소멸된다. 매 요청시마다 새로운 request 객체가 생성된다.
				즉, 요청하는page + 요청받는 page 에서 공유
		3. session 객체(session) : 단위) "하나의 웹 브라우저" => 같은 JSP페이지를 서로 다른 웹브라우저에 띄워도 브라우저가 다르기
													때문에 서로 다른 session 객체가 생성된다.
				=> 주로, 사용자의 로그인 정보를 저장할 때 사용된다. (브라우저를 종료시키기 전까지 공유될 변수가 필요할 때)
		4. application 객체(applicaion) : 웹프로젝트 전체에서 공유된다. 따라서, 자원의 경로등을 지정해 해당 웹프로젝트를 사용하는
													전체 사용자에게 공유되어야 하는 변수 등을 지정할 때 사용된다.

		
		속성 관련 메서드)
			- setAttribute(String name,Object value)
			- getAttribute(~~)
			- getAttributeNames(); return Enumeration
			- removeAttribute(~~)
			
		** 이때, name의 type은 String이지만 읽어올 수 있는 value는 모든 타입이 가능하도록 Object이다.
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
	name과 value를 URL에 GET방식으로 붙여 요청한 뒤, 해당 값들을 application 객체에 저장한다. : <br/>
	요청 : http://localhost:80/JSP_HYR_PROJECT/_17_Object_Scope.jsp?name=attrl&value=value1
	<hr/>
	<%
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		
		if ( name != null && value != null ){
			application.setAttribute(name, value);
		}
	%>
	<%
		if ( name != null && value != null ){
			
	%>
		application 기본 객체의 속성 설정 :
			<%= name %> = <%= value %>
	<%
		}else {
			
	%>
		application 기본 객체의 속성 설정 안 함
		<%
		}
		%>
</body>
</html>