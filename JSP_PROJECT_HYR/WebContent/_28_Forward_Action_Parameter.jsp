<%--
	jsp:param�� ����)
			: jsp:param�� ��� value ���� ���ڿ�(String)�� �� �� �ִ�. ����, ��ü�� ���ڿ� �̿��� ���� ������ ����
			  �����ϱ� ��ƴٴ� ������ �ִ�.
			  
			  �̸� �ذ��Ϸ���, �Ϲ� ���� ��ü(page, request, application, session) � ��Ƽ� �����ϴ� ����� ���ؾ� �Ѵ�.
			  
			  �������)
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		java.util.Date now = new java.util.Date();
		request.setAttribute("DateName", now);
	
	%>
	<jsp:forward page="./_29_Forward_Action_Parameter.jsp" />
	<!-- 
		request ��ü�� ��Ƽ� ������ ��û�� request ��ü�� ���� �Ѿ��!
		�Ϲ� ���� ��ü�� setAttribute, getAttribute�� value���� Object�̱� ������ ��� Ÿ���� ������ �� �ִ�.!
		setAttribute(String name, Object value);
	 -->
</body>
</html>