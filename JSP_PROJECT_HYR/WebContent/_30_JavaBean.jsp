<%--
		[	�ڹٺ���	  ]
		: JSP���� "�ڹٺ���"�� ������(�Ӽ�)�� �����ϴ� DO("Data Object") ������ �Ѵ�. == DTO(Data Transfer Object)
		
		�ڹٺ��� ������ �̿��ϸ�, ������ �����͸� �����ϰ�, �ҷ����� �� �ҽ��ڵ带 ���ٷ� ó���� �� �ִ�.
		
		�ڹ� ���� ���� ����) ~.java
		public class MemberInfo {
			private String id;
			private String password;
			
			// getter, setter�� �ݵ�� get set ���� "�빮��"�� �;���!(�ڵ��ϼ����� ������...)
			// ���� ��Ģ ����� ���߿� ȣ��� �ڵ����� �ֱⰡ �����ϴϱ�...
			public String getId(){
				return id;
			}
			public void setId(String val){
				this.id = val;
			}
		}
		// javaBean ������ MemberInfo �ڹٺ� Ŭ������ ������!
		
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

</body>
</html>