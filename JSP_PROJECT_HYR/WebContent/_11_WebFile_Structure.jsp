<%--
		[	Web Project 파일 구조 & URL 관계	 ]
		
		톰캣폴더/webapps/JSP 일 때 JSP가 "웹어플리케이션" 폴더가 되고
			webapps/JSP == contextPath 경로가 된다.
			
			이 웹어플리케이션 폴더 경로(contextPath)는 : request.getcontextPath() 를 통해서 얻어올 수 있다.
			
			그리고, 웹어플리케이션 폴더 내에는 WEB-INF 폴더가 위치한다.
				webapps/JSP/WEB-INF 폴더는 "웹어플리케이션 설정"을 담당하는데 이 곳에는
						웹 어플리케이션 설정을 할 수 있는 [[web.xml]] 파일이 위치한다.
			
			http://localhost:80/JSP
			까지가 웹어플리케이션 경로이며
			- request.getcontextPath()를 통해 실행해 보면, /JSP 라는 경로가 출력된다.
			- action="/JSP/~.jsp" 등처럼 기재할 수 있다.
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/JSP/WebContent/_11_WebFile_Structure.jsp">
	이 파일의 웹어플리케이션 폴더 위치 : <%= request.getContextPath() %>
	<!-- 
		/JSP
	 -->
</body>
</html>