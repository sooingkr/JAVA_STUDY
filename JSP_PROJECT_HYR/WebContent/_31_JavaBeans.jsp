<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="member" class="javaBean.MemberInfo" scope="request" />
	<!-- 
		�Ʊ� ����� ��ó��, �̱����̱� ������ ������������ ����� �� member ��ü�� request�� ���޴�� ��������
		���� ��ü�� ���´�.
	 -->
	
	 <jsp:getProperty property="name" name="member"/> <jsp:getProperty property="id" name="member"/> ȸ���� �ݰ�����.
	 <!-- 
	 	member.getName() member.getId() �� ���� ����...
	  --> 
</body>
</html>