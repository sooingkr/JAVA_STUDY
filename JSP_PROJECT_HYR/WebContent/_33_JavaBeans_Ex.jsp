<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="memberBeans" class="javaBean.MemberInfo" scope="request"/>
	<jsp:setProperty property="*" name="memberBeans"/>
	<!-- 
		위 문장에서 property가 *임으로 form에서 전송한 모든 데이터가 name값이 필드변수명과 일치하는 것들을 다 자동 세팅된다.
		단, password는 form에서 입력하는게 없었음으로 우리가 별개로 세팅해 주도록하자.
	 -->
	 <%
	 	memberBeans.setPassword(memberBeans.getId());
	 	// password는 id랑 같도록 설정하였다.
		// getProperty로해서 value에 표현식을 써서 저장할 수도 있다.
	 %>
	 <br/>
	 <hr/>
	 
	아이디 : <jsp:getProperty property="id" name="memberBeans"/><br/>
	암호 : <jsp:getProperty property="password" name="memberBeans"/><br/>
	이름 : <%= memberBeans.getName() %><br/>
	이메일 : <jsp:getProperty property="email" name="memberBeans"/></br>
	
</body>
</html>