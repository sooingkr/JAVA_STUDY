<%--
			[	 Include directive	] && [	Include ��Ƽ�� vs Include �׼� 	]
			
			������)
					: include �׼�, ��Ƽ�� ��� �ٸ� JSP ������ ���Խ�ų �� ���ȴ�.
			������)
				    : Include �׼� : �� ��� �����帧�� �Űܰ��ٴ� Ư¡�� �ִ�.(����)
				      Include ��Ƽ : �� ��� �ش� ������ �ڵ带 ���Խ�Ų �� �ڹ� �ڵ�� ��ȯ�ϰ� �װ� �������� ���� Ŭ������ �����.
				      						(����)
			
			include ��Ƽ���� Ư¡)
					: - ���Խ�Ű�� ������� �ǹ̿��� Ȯ���ڸ� jspf(JSP framgment) ��� ���� ���� ����.
				      - �ڵ带 �߰��� �� �ڹ��ڵ�� ��ȯ�ϰ� �������ϱ� ������
				      	=> �ڡ�*�ش� �������� ������� �������� �� ���������� ����� �� �ִ�.!!!�١�
				      
			�뵵) 
				- include �׼� : ���� �޴� ���ó�� ���ϱ� ���ϵ� ���������� ���� �������� ���� �� �ַ� ���ȴ�.
				- include ��Ƽ�� : - �ϴ� ���۱�ó�� ������ �������� ���Խ�Ű�ų�
											- ��û���� �Ķ���� ������ ������ ���� �뵵�� ����Ѵ�.
								=> �������, �� ���������� session.setAttribute("name","value")�� ������ ���� �Ͼ�ٸ�
									�ڵ� �ߺ��� ������. ����, include ��Ƽ�꿡�� �Ķ���� ���� ������ ������ ������ ����
								include ��Ƽ�긦 ���Խ��� �ش� ������ ����ϴ� ����� ����Ѵ�.
								
								
			[	Include ��Ƽ���� �ڵ� �߰�	 ]
			-������)
				: ������� 500���� jsp �������� footer�� �߰��Ѵٰ� ���� �� <%@include �� �Ѵٰ� �ϴ���
				  �ش� ���常 500���� ����� ���̴�. �� ���� �ڵ� �ߺ��̰� �̸� �ذ��ϱ� ���ؼ�
				  ~~������ ������ ��� JSP ������ �ڵ����� include ��Ƽ�긦 �߰��� �� �ִ�.
		 	- ���)
		 		: 1. web.xml ���Ͽ� ������ �߰��ϸ� �ȴ�.
		 				<jsp-config>
							<jsp-property-group>
									<description>�ش� ��ο� �ִ� *��� JSP������ ���Խ�Ų��.</description>
									<url-pattern>/*</url-pattern>
									<include-prelude>�տ� ���Խ�ų �������</include-prelude>
									<include-coda>�Ǹ������� ���Խ�ų ���� ���</include-coda>
							</jsp-property-group>
						</jsp-config>
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
	<%@include file="/module/dateFooter.jspf"%>
	<!--  include ��Ƽ�긦 �߰��Ѵ�. -->

	include ��Ƽ�긦 ���� ���Խ�Ų �������� ����Ǿ� �ִ� ���� now�� ���� ��� :
	<%=now%>

	<!-- 
			now ������ �� ������ ����Ǿ� ���� �ʰ�, dateFooter.jspf�� ����Ǿ� �ִ� �����ε� �ҽ��ڵ尡 �ٿ��� ��
			��ȯ,������ �Ǳ� ������ ����� �� �ִ� ���� �� �� �ִ�.
		 -->
</body>
</html>