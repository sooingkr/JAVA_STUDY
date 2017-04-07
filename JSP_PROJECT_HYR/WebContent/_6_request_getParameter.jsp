<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%
	request.setCharacterEncoding("EUC-KR");
	// POST������� ��û �Ķ���Ϳ� ���� ���ڵ� ����� �����Ѵ�.
	// ������������ ��û�� �Ķ���͸� ���ڵ��� ��İ� ������ ������� JSP���Ͽ��� ���ڵ��� �ؾ� �ùٸ� ���� �о�� �� ���� ���̴�.
	// �̿� ����, post ����� setCharacterEncoding���� �������ϰ� Get����� conf/server.xml�� Connector�±׿� URIEncoding="utf-8"���� �߰��Ѵ�.
	
	
	// ***���ڵ� ��� ����)
	// 1. page directive�� contentType charset�� JSPó�� �� ��ȯ�� html������ ���ڵ� Ÿ���� �����Ѵ�.
	// 2. page directive�� pageEncoding�� JSP���� ��ü���� ����� ���ڵ� ����� �����Ѵ�.
	// 3. request��ü�� setCharacterEncoding�� Client�� ��û�� �Ķ���͸� �������󿡼� ���ڵ��� ������ ��û�� ��
	//		�� ���ڵ��� �Ķ���͸� ���ڵ��� ����� �����Ѵ�.
	//		�� ���������� ���ڵ���İ� ���ڵ� ����� �¾ƾ� ������ ���� �ʰ���??
	// �̶� : Post ����� setCharacter�� ������ ������, Get����� ���⿡ ������ ���� �������� 
	// URL�� �ٿ� ������ Get����� ��� �ٸ� ������� ��û �Ķ���Ϳ� ���� ���ڵ� ����� ������ �־�� ��.
	// ����, conf ������ server.xml���Ͽ� �� Connector �±׿� URIEncoding="utf-8" �� ���� �ڵ带 �߰��� �־�� ��.
	
			
			
			
	// [	Get��� vs Post ���	]
	// 1. Get��� 
	//			: URL�� �������ڿ��� ���� ���� �����ϴ� ���(form method="get")
	// 	http://localhost:80/JSP/_6_request_getParameter.jsp?name=Ȳ����&address=ad&pet=cat
	//		=> ����, ���� ������ ���̰� �������̸�, ���ȿ� �����.
	
	// 2. Post���(form method="post")
	//			: ������ ������ ���Խ��� ������ ������ ���ȼ��� �� ����ϰ� ���̿� ������ ����.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>��û �Ķ���� ���</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-12" data-genuitec-path="/JSP/WebContent/_6_request_getParameter.jsp">
	<b data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-12" data-genuitec-path="/JSP/WebContent/_6_request_getParameter.jsp">
		request.getParameter() �޼��� ���<br/>
	</b>
	
	name �Ķ���� : <%= request.getParameter("name") %><br/>
	address �Ķ���� : <%= request.getParameter("address") %><br/>
	<hr>
	
	<b> request.getParameterValues() �޼��� ��� </b>
	
	checkbox���� ������ ���� : 
	
	<%
		String[] values = request.getParameterValues("pet"); 
		// checkbox�� ��� �������� ���� �ϳ��� �Ķ���� ������ �Ѿ�� �� �ֱ� ������ getParameterValues�� ���� ����
		// ���� Ÿ���� String[]���� ����.
		
		if ( values != null ){
			for(int i=0; i<values.length; i++){
				out.print( values[i] + "<br/>");
			}
		}
		
		%>
		
		<hr>
		<b>request.getParameterNames() �޼��� ���</b><br/>
		==> ��ü���� name������ �𸣰� ���� ��� name������ ������ ó���� �� ������.<br/>
		<%
			Enumeration<String> names = request.getParameterNames();
			// ��ȯ���� Enumeration<String> ���� ����!
			out.println("���� ��� name ����(�Ķ���͸��)");
			while( names.hasMoreElements() ){
				out.println( (String)names.nextElement() + " ");
			}
			out.println("<br/>");
			
			out.println("�Ķ���Ϳ� �ش��ϴ� value������ ��� : <br/>");
			
			
			// name �Ķ���͵��� ������ �ش� �Ķ���Ϳ� �ش��ϴ� value������ ������ ��.
			
			out.println("<br/>");
		%>
		
		<b> request.getParameterMap() �޼��� ��� : (name, value) ������ �Ѿ��.</b>
		<%
			Map map = request.getParameterMap();
			String[] nameVal = (String[])map.get("name");
			out.println("name�� �� : " + nameVal[0]);
		%>
</body>
</html>