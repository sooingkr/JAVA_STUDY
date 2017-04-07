<!-- 
		[	JSP	동작 원리	 ]
		==> "Client로부터 웹브라우저를 통해 JSP 페이지 요청"
		1. 요청한 JSP페이지에 대한 Servlet class가 존재하는 경우
			1) 웹 컨테이너는 요청한 JSP에 해당하는 Servlet class에 요청을 전달한다.
			2) 요청을 처리해 만들어진 html과 같은 결과물을 웹브라우저로 전송해 응답한다.
			
		2. 요청한 JSP페이지에 대한 Servlet class가 존재하지 않는 경우
			1) 요청한 JSP페이지를 Java 파일로 변환한다.(Jsp file -> Java file)
			2) Java file을 Servlet class로 컴파일한다. (Java file -> Servlet class)
			3) Servlet class에 요청을 전달한다.
			4) 요청을 처리해 html과 같은 결과물을 웹브라우저에 전달한다.
			
			==> JSP를 통해 생성되는 이와같은 Java파일과 Servlet class는
			
				==> /톰캣폴더/"[ work  폴더 ]"에 위치하고 있다.
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/JSP/WebContent/_10_JSP_Environment.jsp">

</body>
</html>