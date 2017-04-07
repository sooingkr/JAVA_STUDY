<!-- 
	[	��Ƽ��(directive)	]
		: JSP �������� ���� ���� ������ ������ �� ���ȴ�.
		���� )
			%@��Ƽ�� �Ӽ�1="��1" �Ӽ�2="��2" ... %
		����)
		1. page ��Ƽ�� : JSP �������� ���� ������ �����Ѵ�. JSP�� �����ϴ� ������ Ÿ��, ��¹���ũ��, ���������� ��
								(JSP ���������� �ʿ�� �ϴ� ������ ����)�Ѵ�.
					�ֿ�Ӽ�)
						1. contentType : JSP�������� ������ ������ Ÿ�԰� ������ ���� char encoding�� �����Ѵ�.
						=>���⼭�� charset�� html���� ���� ������ �� ǥ���� ���ڵ� ����̴�.
							contentType="text/html;charset=UTF-8" or "text/xml" or "application/json" ...
						2. import : class import 
							%page import="java.util.Calendar, java.util.Date" %
						3. pageEncoding �Ӽ� : 
								contentType���� ��ȯ�� �������� ���ڵ��� �����Ѵٸ�,
								���⼭��, JSP������ ��ü���� ����� ���ڵ� ����� �����Ѵ�.
							=> JSP�� ���������� pageEncoding�� ���� ��ȸ�ϰ� ���ٸ� contentType�� ��ȸ�ϰ� �ȴ�.
							=> �� �� ���� ��� ISO~~�� �����Ѵ�.
						4. buffer = "4kb" (������ default ũ�� : 4kb)
								: ����� ������ ũ�⸦ �����Ѵ�.
								[ ���� ����� ����?	] : JSP�������� ���� ������ ���� �����ʹ� ���ۿ� �׾Ҵٰ� ���������� �����ϴµ� �̿��� ������ �ִ�.
										: - ��Ʈ��ũ Ư���� �Ź� ������ ������ �ѹ��� ��� ���۽� ȿ���� ����.
										  - JSP ���൵�� ������ �߻��� �ش� ���� �߻� ������ �����Ǿ� ���ۿ� �����͸� �׾Ƴ��� ������
										  	���� �߻� ������ ������ �����͸� ������� �ʰ� �ٷ� ���� �������� ��½�ų �� �ִ�.
						5. autoFlush = true or false 
								: Buffer�� ����á�� ��, ���������ϰ� ��� ��������(true) / �ͼ����� �߻���ų��(false)�� �����Ѵ�.
								
		2. include ��Ƽ�� : JSP �������� Ư�� ������ �ٸ� ������ ���Խ�Ų��.
		
		3. taglib ��Ƽ�� : JSP ���������� ����� �±� ���̺귯���� �����Ѵ�.
 
 		[	��ũ��Ʈ ���		] : JSP���� ������ ������ �������� �����ϱ� ���� ���Ǵ� ��
 		
 		����)
 			1. ǥ���� : <%=%> : ���� ����Ѵ�.
 			2. ��ũ��Ʈ�� : <%%> : �ڹ� �ڵ带 �����Ѵ�.
 			3. ����� : �ڹ� �޼���, ���� ���� �����Ѵ�.
 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.Calendar" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52568",secure:"52573"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

	<%
		Calendar cal = Calendar.getInstance();
		
	%>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/JSP/WebContent/_2_directive.jsp">
	������ ::
		<%= cal.get(Calendar.YEAR) %>��<br data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/JSP/WebContent/_2_directive.jsp"/>
		<%= cal.get(Calendar.MONTH) + 1 %>��<br/>
		<%= cal.get(Calendar.DATE) %>�� 
		�Դϴ�.
</body>
</html>