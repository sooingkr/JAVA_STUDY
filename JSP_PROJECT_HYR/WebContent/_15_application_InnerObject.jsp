<%--
		[	application 내장 객체	]
		: 웹 프로젝트 내의 모든 JSP 페이지에서 "공유"되는 객체이다.
		  - 웹 어플리케이션과 생명주기가 동일하다.
		  - 웹 어플리케이션 전반에 걸쳐 사용되는 정보를 담고 있다.
		  
		  용도)
		  	1. 초기 설정 정보를 읽어올 수 있다.
		  	2. 서버 정보를 읽어올 수 있다.
		  	3. 웹 어플리케이션이 제공하는 자원(파일)을 읽어올 수 있다. 
		  	
		  설명)
		  	1. 웹 어플리케이션 전체에서 사용할 수 있는 초기화파라미터는 WEB-INF/web.xml에 선언할 수 있다.
		  			in web.xml)
		  				<context-param>
		  					<description>파라미터 설명(필수아님)</description>
		  					<param-name>파라미터이름</param-name>
		  					<param-value>파라미터값</param-value>
		  				</context-param>
		  		(초기화 파라미터를 읽어오는 application 메서드)
		  			: - application.getInitParameter("logEnabled");
		  			  - application.getInitParameterNames();
 --%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-5" data-genuitec-path="/JSP/WebContent/_15_application_InnerObject.jsp">
	초기화 파라미터 목록:
	<ul data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-5" data-genuitec-path="/JSP/WebContent/_15_application_InnerObject.jsp">
		<%
			Enumeration e = application.getInitParameterNames();
			while( e.hasMoreElements() ){
				String name = (String)e.nextElement();
				
		%>
				<li><%= name %> = <%= application.getInitParameter(name) %>
		<%
			}
		%>
		
		<%
			application.log("application 객체로 log 남기기");
		%>
	</ul>
</body>
</html>