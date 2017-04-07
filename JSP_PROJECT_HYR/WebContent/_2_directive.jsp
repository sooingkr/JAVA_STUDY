<!-- 
	[	디렉티브(directive)	]
		: JSP 페이지에 대한 설정 정보를 지정할 때 사용된다.
		형식 )
			%@디렉티브 속성1="값1" 속성2="값2" ... %
		종류)
		1. page 디렉티브 : JSP 페이지에 대한 정보를 지정한다. JSP가 생성하는 문서의 타입, 출력버퍼크기, 에러페이지 등
								(JSP 페이지에서 필요로 하는 정보를 설정)한다.
					주요속성)
						1. contentType : JSP페이지가 생성할 문서의 타입과 생성할 때의 char encoding을 지정한다.
						=>여기서의 charset은 html문서 등을 생성할 때 표현할 인코딩 방식이다.
							contentType="text/html;charset=UTF-8" or "text/xml" or "application/json" ...
						2. import : class import 
							%page import="java.util.Calendar, java.util.Date" %
						3. pageEncoding 속성 : 
								contentType에서 반환할 페이지의 인코딩을 지정한다면,
								여기서는, JSP페이지 자체에서 사용할 인코딩 방식을 지정한다.
							=> JSP는 내부적으로 pageEncoding을 먼저 조회하고 없다면 contentType을 조회하게 된다.
							=> 둘 다 없을 경우 ISO~~로 지정한다.
						4. buffer = "4kb" (생략시 default 크기 : 4kb)
								: 사용할 버퍼의 크기를 지정한다.
								[ 버퍼 사용의 이점?	] : JSP페이지를 통해 생성된 응답 데이터는 버퍼에 쌓았다가 모은다음에 전송하는데 이에는 이점이 있다.
										: - 네트워크 특성상 매번 전송할 때마다 한번에 모아 전송시 효율이 좋다.
										  - JSP 실행도중 에러가 발생시 해당 오류 발생 전까지 생성되어 버퍼에 데이터를 쌓아놓기 때문에
										  	에러 발생 전까지 생성한 데이터를 출력하지 않고 바로 에러 페이지를 출력시킬 수 있다.
						5. autoFlush = true or false 
								: Buffer가 가득찼을 때, 리프래쉬하고 계속 진행할지(true) / 익셉션을 발생시킬지(false)를 지정한다.
								
		2. include 디렉티브 : JSP 페이지의 특정 영역에 다른 문서를 포함시킨다.
		
		3. taglib 디렉티브 : JSP 페이지에서 사용할 태그 라이브러리를 지정한다.
 
 		[	스크립트 요소		] : JSP에서 문서의 내용을 동적으로 생성하기 위해 사용되는 것
 		
 		종류)
 			1. 표현식 : <%=%> : 값을 출력한다.
 			2. 스크립트릿 : <%%> : 자바 코드를 실행한다.
 			3. 선언부 : 자바 메서드, 변수 등을 선언한다.
 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.Calendar" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

	<%
		Calendar cal = Calendar.getInstance();
		
	%>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/JSP/WebContent/_2_directive.jsp">
	오늘은 ::
		<%= cal.get(Calendar.YEAR) %>년<br data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/JSP/WebContent/_2_directive.jsp"/>
		<%= cal.get(Calendar.MONTH) + 1 %>월<br/>
		<%= cal.get(Calendar.DATE) %>일 
		입니다.
</body>
</html>