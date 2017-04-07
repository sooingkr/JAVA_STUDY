<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<%
	// response.sendRedirect("/JSP/_7_indexjsp.jsp?name=황영롱");
	// 이런식으로 sendRedirect 상에서 쿼리문자열을 이용해 파라미터를 넘겨줄 때 그냥 황영롱 써버리면
	// 안됨==> 올바르게 인코딩해서 보내야한다.!
	String value = "황영롱";
	String encodedValue = URLEncoder.encode(value,"UTF-8");
	// 왜 UTF-8로 해야만 가능? => EUC-KR로 하고 싶으면 이경우 URI에다가 쿼리문자를 붙여보내는 Get방식임으로
			// Get방식의 한글처리는 setCharacterEncoding이 불가능하기 때문에, 
			// conf/server.xml에 들어가서 Connector태그에 URIEncoding="EUC-KR" 속성을 추가해 주어야 함.
	response.sendRedirect("/JSP/_7_indexjsp.jsp?name=" + encodedValue);
	//response.sendRedirect("http://www.google.com");
%>



<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-15" data-genuitec-path="/JSP/WebContent/_8_SendRedirectjsp.jsp">

</body>
</html>