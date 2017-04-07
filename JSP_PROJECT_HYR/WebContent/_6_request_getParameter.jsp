<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%
	request.setCharacterEncoding("EUC-KR");
	// POST방식으로 요청 파라미터에 대한 디코딩 방식을 지정한다.
	// 웹브라우저에서 요청시 파라미터를 인코딩한 방식과 동일한 방식으로 JSP파일에서 디코딩을 해야 올바른 값을 읽어올 수 있을 것이다.
	// 이에 따라, post 방식은 setCharacterEncoding으로 지정을하고 Get방식은 conf/server.xml의 Connector태그에 URIEncoding="utf-8"등을 추가한다.
	
	
	// ***인코딩 방식 정리)
	// 1. page directive의 contentType charset은 JSP처리 후 반환할 html문서의 인코딩 타입을 지정한다.
	// 2. page directive의 pageEncoding은 JSP파일 자체에서 사용할 인코딩 방식을 지정한다.
	// 3. request객체의 setCharacterEncoding은 Client가 요청한 파라미터를 브라우저상에서 인코딩해 서버로 요청할 때
	//		이 인코딩된 파라미터를 디코딩할 방식을 지정한다.
	//		웹 브라우저에서 인코딩방식과 디코딩 방식이 맞아야 오류가 뜨지 않겠지??
	// 이때 : Post 방식은 setCharacter의 영향을 받지만, Get방식은 여기에 영향을 받지 않음으로 
	// URL에 붙여 보내는 Get방식인 경우 다른 방법으로 요청 파라미터에 대한 디코딩 방식을 지정해 주어야 함.
	// 따라서, conf 폴더의 server.xml파일에 들어가 Connector 태그에 URIEncoding="utf-8" 과 같은 코드를 추가해 주어야 함.
	
			
			
			
	// [	Get방식 vs Post 방식	]
	// 1. Get방식 
	//			: URL에 쿼리문자열을 통해 값을 전달하는 방법(form method="get")
	// 	http://localhost:80/JSP/_6_request_getParameter.jsp?name=황영롱&address=ad&pet=cat
	//		=> 따라서, 전송 데이터 길이가 제한적이며, 보안에 취약함.
	
	// 2. Post방식(form method="post")
	//			: 데이터 영역에 포함시켜 보내기 때문에 보안성이 더 우수하고 길이에 제한이 없음.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>요청 파라미터 출력</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-12" data-genuitec-path="/JSP/WebContent/_6_request_getParameter.jsp">
	<b data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-12" data-genuitec-path="/JSP/WebContent/_6_request_getParameter.jsp">
		request.getParameter() 메서드 사용<br/>
	</b>
	
	name 파라미터 : <%= request.getParameter("name") %><br/>
	address 파라미터 : <%= request.getParameter("address") %><br/>
	<hr>
	
	<b> request.getParameterValues() 메서드 사용 </b>
	
	checkbox에서 선택한 값들 : 
	
	<%
		String[] values = request.getParameterValues("pet"); 
		// checkbox의 경우 여러개의 값이 하나의 파라미터 명으로 넘어올 수 있기 때문에 getParameterValues를 통해 받음
		// 리턴 타입이 String[]임을 주의.
		
		if ( values != null ){
			for(int i=0; i<values.length; i++){
				out.print( values[i] + "<br/>");
			}
		}
		
		%>
		
		<hr>
		<b>request.getParameterNames() 메서드 사용</b><br/>
		==> 구체적인 name값들을 모르고 사용된 모든 name값들을 가져와 처리할 때 유용함.<br/>
		<%
			Enumeration<String> names = request.getParameterNames();
			// 반환형이 Enumeration<String> 임을 주의!
			out.println("사용된 모든 name 값들(파라미터명들)");
			while( names.hasMoreElements() ){
				out.println( (String)names.nextElement() + " ");
			}
			out.println("<br/>");
			
			out.println("파라미터에 해당하는 value값들을 출력 : <br/>");
			
			
			// name 파라미터들을 가져와 해당 파라미터에 해당하는 value값들을 가지고 옴.
			
			out.println("<br/>");
		%>
		
		<b> request.getParameterMap() 메서드 사용 : (name, value) 쌍으로 넘어옴.</b>
		<%
			Map map = request.getParameterMap();
			String[] nameVal = (String[])map.get("name");
			out.println("name의 값 : " + nameVal[0]);
		%>
</body>
</html>