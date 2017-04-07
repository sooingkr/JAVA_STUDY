<!-- 
		[	  response 내장 객체		]
		: 웹 브라우저로 응답할 것에 대한 응답 정보를 담고 있는 내장 객체이다.
		
		기능)
			- 1) 헤더 정보 입력 : 주로 헤더에서 "캐시" 설정과 관련해 사용된다.
			- 2) ** 리다이렉트 하기 : 웹서버가 웹 브라우저에게 다른 페이지로 이동하라고 응답하는 기능
				: response.sendRedirect("이동할페이지");
				==> 이것은 페이지는 내부적으로 이동하지만 주소자체가 이동하지는 않는다.!!!
					하지만, forward액션은 주소까지 이동함!!
			- 3) Cookie 설정 적용하기 : response.addCookie(cookie); // 쿠키 파트에서 자세히...
			
			캐시란??
				: 웹 브라우저는 첫 번째 요청 시 응답 결과를 로컬 PC의 임시 보관소인 캐시에 저장한다. 이후, 동일한
				  URL에 대한 요청이 있으면 WAS에 접근하지 않고 로컬 PC에 저장된 응답 결과를 사용해 응답속도를 높인다.
			
			-> 하지만, 게시판처럼 내용이 수시로 자주 바뀌는 경우 사용자는 변경된 내용을 확인할 수 없게 된다.
				-> 따라서, 캐시를 사용하지 않도록 설정해야할 필요가 있을 때가 있다.
				
			캐시 해제 방법)
				response.setHeader("Cache-Control", "no-cache");
				// 최근에는 이것만 하면 되지만, 구버전을 위해 아래 코드도 같이 추가하는 것이 좋다.
				response.addHeader("Cache-Control", "no-store");
				response.setHeader("Pragma", "No-cache");
				
 -->
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	response.setHeader("Cache-Control","no-cache");
	response.addHeader("Cache-Control","no-store");
	response.setHeader("Pragma","No-cache");
%>

<%
	String id = request.getParameter("memberId");
	if ( id != null && id.equals("madvirus") ){
		response.sendRedirect("/JSP/_7_indexjsp.jsp");
		// 웹브라우저에 http://localhost:80/JSP/_7_response_InnerObjectjsp.jsp?memberId=madv 입력해보자.
	}else {
		out.println("잘못된 아이디입니다.");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-14" data-genuitec-path="/JSP/WebContent/_7_response_InnerObjectjsp.jsp">

</body>
</html>