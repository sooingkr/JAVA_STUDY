<!-- 
		[	스크립트 요소	  ] : JSP에서 로직을 수행하는데 필요.
		1. 스크립트릿 : 자바코드를 쓸 대 사용.
		2. 표현식 : 출력
		3. 선언부 : 
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1~10까지의 합</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<%!// 선언부 : 변수, 메서드 등의 선언을 하는데 사용 됨.
	int sum = 0;

	public int multiply(int a, int b) {
		int c = a * b;
		return c;
	}%>
<%
	// 스크립트릿 : 자바 로직 수행
	for (int i = 1; i <= 10; i++) {
		sum += i;
	}

	int result = multiply(10,20);
%>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-9" data-genuitec-path="/JSP/WebContent/_4_ScriptElementjsp.jsp">
	1~10까지의 합은 :
	<%=sum%>
	입니다.
	<!--  표현식  -->
	
	10 * 25 = <%= multiply(10,25) %>
	10 * 20 = <%= result %>
</body>
</html>