<%--
		[	Session	vs	Cookie	]
		: 세션과 쿠키의 차이점
		
		공통사항)
			- 사용자의 상태를 저장할 수 있는 수단
			- 둘 다 사용자 인증 등에 이용될 수 있다.
		차이점)
			- 1) 세션은 서버에 저장하고 쿠키는 Client 측에 저장된다.
					: 따라서, 세션이 보안에 더 유리하다.
			- 2) 쿠키는 setDomain() 을 통해서 여러 서버로 전송이 가능하지만,
					세션은 "웹브라우저" 기준이기 때문에 여러 서버에서 공유가 불가능하다.
		
		특징)
			- 세션은 웹브라우저가 단위이다.
			  따라서, 브라우저를 새로 키면 서로 다른 세션이 존재하는 것이되서 두 세션은 다른 세션이다.
			  session.getId() 을 통해 가져오면 서로 다른 id임을 알 수 있다.
			  
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		1. [ 세션 생성하기 ]
		: - page 디렉티브의 session 속성을 true로 해주는 방법(default가 true임으로 건들필요없음...)
				false로하면 세션 사용안하겠다는 것...
		  - <%@page session = "true"
		  
		  생성 메카니즘)
		  	: 서버로 client에서 최초 요청시 서버에서 "session"이 생성하고 그 이후 또 요청이 오면 기존에 있던
		  	  session이 사용된다.
		2. **[ 세션 객체의 속성 사용 ]**
			- session.setAttribute(String name, Object obj) : 데이터 저장
			- session.getAttribute(String name) : 데이터 꺼내기
			=> 여기서 저장하는 데이터가 Object obj임에 주목! : 문자열뿐아니라 모두 올 수 있다.!!!
		
		3. [ session 기본 설정 사항 가져오기 ]
			- session.getId() : 현재 살아있는 세션객체의 id를 가지고 온다.
				: 브라우저가 기본 단위이기 때문에 두개의 브라우저를 띄운 뒤 확인해보면 그 값이 다르게 나온다.
			- session.getCreationTime() : 세션이 생성된 시간 가져옴
			- session.getLastAccessedTime() : 마지막 세션 접근 시간 가져옴 : page디렉티브 true나 session 설정 생략시
																해당 jsp 페이지에 마지막 요청이 온 시점 값이 나옴
 			- session.getMaxInactiveInterval() : 세션도 쿠키처럼 유지시간이 있음(초 기준)
 		
 		4. [ 세션 종료 ]
 			: session.invalidate(); 를 사용해서 세션을 종료한다.
 			=> 세션은 쿠키와 달리 유효시간을 0으로 설정하거나 생략하면 브라우저는 종료하지 않는한 세션이 사라지지않고
 				쌓이기 때문에 메모리 문제가 발생할 수 있다.
 				따라서, 세션을 더이상 사용하지 않을 경우 세션을 종료하거나, 유효시간을 설정해 둠으로써 메모리 문제가 생기지 않도록 주의해야 한다.
 		
 		5. [ 세션 유효시간 설정 ]
 			: 세션의 유효시간을 설정하는 방법은 크게 2가지가 있다.
 			1) web.xml 파일에 <session-config>
 											<session-timeout>50(분단위)</session-timeoue>
 										</session-config>
 				를 작성하는 방법
 			2) session.setMaxInactiveInterval(60*60); 를 사용하는 방법(초단위)
 			
		=> 세션은 쿠키와 달리 유효시간을 0으로 설정하거나 생략하면 브라우저는 종료하지 않는한 세션이 사라지지않고
 				쌓이기 때문에 메모리 문제가 발생할 수 있다.
 				따라서, 세션을 더이상 사용하지 않을 경우 세션을 종료하거나, 유효시간을 설정해 둠으로써 메모리 문제가 생기지 않도록 주의해야 한다.
 		
 		
 		[	세션의 공유	 ]
 		: 쿠키의 JSESSIONID를 통해 공유할 수 있다.
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>