<%--
	name값에 이미 들어가 있는 상태로 include 액션 param으로 name을 또 보내면
	새로운 값으로 보내지는 것이 아니라, 기존 값에 추가되어 두개가 전송된다!! 
	
	하지만, param을 통해 전송된 값은 해당 include 페이지에서만 이용이 가능하다!
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	request.setCharacterEncoding("UTF-8");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	include 전 name 파라미터 값 : <%= request.getParameter("name") %>
	<!-- 
		http를 통해 name값에 cbk 넣어 전송할 것임 => name = cbk
	 -->
	 
	 <hr/>
	 
	 <jsp:include page="./module/body_sub.jsp" flush="false">
	 	<jsp:param name="name" value="황영롱" />
	 </jsp:include>
	 <!-- 
	 	name에 cbk가 들어있는 상태로 전송시 name= cbk, 황영롱 2개의 값이 들어가 전송되는 것임!
	  	단, 액션 태그 param을 통해 전달되는 내용이 기존 내용보다 우선순위가 높게 전달 됨으로
	  	황영롱 cbk 순으로 전달되는 것! 따라서 받는 쪽에서 String str[0] 번째 값은 황영롱임!
	  -->
	  
	  <hr/>
	  
	  include 후 name 파라미터 값 : <%= request.getParameter("name") %>
	  <!-- 
	  	include param을 통해 전송된 값은 include 파일 내에서만 사용이 가능함으로 cbk만 출력됨
	   -->
</body>
</html>