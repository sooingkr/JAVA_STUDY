<%--
		[	�ڹٺ��� ����	]
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
	
		<jsp:useBean id="member" class="javaBean.MemberInfo" scope="request" />
		<!-- 
			���� ������ ��ü�� �����ϴ� ������ ��Ÿ���ٰ� ���� �Ǵµ� �̱������� �ڵ������� �ش�.
			��, ���� ��ü�� ������ ������ü�� ��ȯ�ϰ� ������ü�� ������ �����ϴ� ���̴�.
			javaBean.MemberInfo member = javaBean.MemberInfo.getInstance() �� �Ͱ� ���...
			
			�Ӽ�) 
				- id : �ش� ��ü�� ��Ī�� ������� �����ϸ� �ȴ�. ��ü ���� �� member�� �ָּ� �����Ѵٴ� �ǹ̶� ����.
				- class : �ڹٺ� Ŭ������ �����ϴµ� ��Ű����.Ŭ������ ���� Ǯ������ ������ �־�� �Ѵ�.
				- scope : request/session/page/application ó�� �ش� �ڹٺ� ��ü�� ������ �� �ִ� ������ �����Ѵ�.
					= �� scope�� �ֱ� ������ jsp:forward ���Բ� ���� �ش� ������ü�� �ڹٺ� ��ü�� ������ JSP �������鿡��
						  ������ ���� �ִ�!!(����)
					default ���� page�̴�.
		 -->
		 
		 <!--  ������ ���� -->
		 <jsp:setProperty name="member" property="id" value="sooingkr" />
		 <jsp:setProperty name="member" property="name" value="Ȳ����" />
		 <!-- 
		 	�� �ڵ�� �����͸� �����ϴ� �ڵ��̴�.
		 	�� �Ӽ���)
		 		- name : �Ʊ� ��ü�� ����Ű�� �������� �����Ѵ�.
		 		- property : �Ӽ��� ��, �ڹٺ� ���ο� ������ �ʵ庯����
		 		- value : ������ ���� �Է��Ѵ�.
		  
		  		�� �ڵ带 ���� �ڹٺ�� �̿����� �ʴ´ٸ�...
		  			member.setId(request.getParameter("name")); ��� ���� ������ ��...(form���� �Ѱ��ش� ������ ��)
		  -->
		  
		  <jsp:forward page="./_31_JavaBeans.jsp"/>
		  <!-- 
				javaBeans�� scope�� request������ forward �׼����ϸ� request ��ü�� �ڹٺ�� ���� ����Ǿ� �Ѿ ���̴�.
				
				���ܿ����� request ��ü�� setAttribute�� ������ request ��ü�� �Ѿ �Ͱ� ����.		  
		   -->
		  
		  
</body>
</html>