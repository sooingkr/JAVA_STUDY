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
		아까 얘기한 것처럼, 싱글톤이기 때문에 전페이지에서 만들어 논 member 객체가 request에 전달대어 왔음으로
		기존 객체를 얻어온다.
	 -->
	
	 <jsp:getProperty property="name" name="member"/> <jsp:getProperty property="id" name="member"/> 회원님 반가워요.
	 <!-- 
	 	member.getName() member.getId() 와 같은 뜻임...
	  --> 
</body>
</html>