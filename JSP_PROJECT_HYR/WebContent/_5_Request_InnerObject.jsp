<!-- 
		[	request 내장 객체   ]
		: Client의 서버로의 "요청"에 관한 데이터 처리를 담당하는 역할을 하는 객체이다.
		
		- Client로부터 서버로 요청시 Client의 IP, Client가 요청한 서버주소, 프로토콜, 
		- 요청한 JSP가 속한 컨택스트 경로를 구할 수 있다.
		- 또한, form에서 요청시 보낸 value값을 받아올 수 있다.
		
		
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>클라이언트 및 서버 정보</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-10" data-genuitec-path="/JSP/WebContent/_5_Request_InnerObject.jsp">

	요청한 JSP 파일 위치 : <%= request.getContextPath() %><br data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-10" data-genuitec-path="/JSP/WebContent/_5_Request_InnerObject.jsp"/>
	요청 URI : <%= request.getRequestURI() %><br>
	클라이언트 IP : <%= request.getRemoteAddr() %><br/>
	서버 이름 : <%= request.getServerName() %><br/>
	<%
		application.getContextPath();
	%>
	
</body>
</html>