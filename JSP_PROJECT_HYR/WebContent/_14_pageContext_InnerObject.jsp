<%--
		[	pagecontext 내장 객체	]
		: 현재 JSP 페이지 자체 객체를 가지고 온다.
		
		=> 해당 객체를 통해 해당 JSP 페이지에서 사용 중인 다른 내장객체들을 가지고 올 수 있다.
		 
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<% 
	pageContext.getOut().println("pageContext 내장객체를 통한 out 객체 사용<br/>");

	HttpServletRequest res = (HttpServletRequest)pageContext.getRequest();
	if ( res == request ){
		out.println("res와 request 내장객체가 같습니다.<br/>");
	}
	HttpServletResponse respon = (HttpServletResponse)pageContext.getResponse();
	if ( respon == response ){
		out.println("respon과 response 객체가 같습니다.<br/>");
	}
%>


<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-4" data-genuitec-path="/JSP/WebContent/_14_pageContext_InnerObject.jsp">

</body>
</html>