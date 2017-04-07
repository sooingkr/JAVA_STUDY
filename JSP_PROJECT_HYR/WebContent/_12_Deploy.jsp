<%--
		[	JSP 배포(Deploy)	 ]
		: JSP를 배포하는 방법은 2가지가 있다.
		1. 웹어플리케이션 폴더를 직접 webapps에 복사해 넣는 방법.
		
		2. war file로 배포하는 방법(*)
			
			이클립스에서는 메뉴-export에서 war file 선택을해서 이 war file을 webapps 폴더에 위치시키면 된다.
			그러면, Client 요청시 war file이 풀려 웹어플리케이션 폴더가 나타난다.
			
			만약) 콘솔에서 war 파일을 만들려고 한다면 cmd에서 웹어플리케이션 폴더 경로로 이동한 뒤,
			: jar cvf JSP.war * 를 입력해 주면 war 파일이 생성된다.
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/JSP/WebContent/_12_Deploy.jsp">

</body>
</html>