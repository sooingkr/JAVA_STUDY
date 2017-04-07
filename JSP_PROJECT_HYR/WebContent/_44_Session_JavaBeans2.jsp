<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="javaBean.memberEx" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="member"/>
	<!-- 
		폼과 이름이 같게되어 있는 항목은 한번에 저장되도록 설정.
		그리고 이 회원정보를 저장한 객체를 세션에 저장할 것임.
	 -->
	 <%
	 	session.setAttribute("MEMBERSESSION", member);
	 // 세션에 회원정보 담고 있는 자바빈즈 객체를 저장했음!
	 %>
</body>
</html>