<%--
		javaBeans를 사용하는 최대 장점은
		
		form태그에서 보낸 모든 name값들을 한꺼번에 저장할 수 있다는 점이다.
		
		방법은)
			jsp:setProperty name="member" property="*" 
 		    처럼 property 값으로 *를 주면 모든 form 태그의 값들을 한번에 자바빈즈에 저장할 수 있는데
 		    단) 조건은...
 		    	★☆★☆name 값이 자바빈즈의 필드변수명과 동일해야만 한다!!!!!!!!!!!!
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
	<form action="./_33_JavaBeans_Ex.jsp" method="post">
		<tr>
			<td>아이디</td>
			<td colspan="3">
				<input type="text" name="id" size="10"/>
				<!-- 
						위에서 말한것처럼 name값이 자바빈즈의 필드변수명과 일치해야함을 잊지말자.			
				 -->
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" size="10"/></td>
			<td>이메일</td>
			<td><input type="text" name="email" size="10"/></td>
			<!-- 
						위에서 말한것처럼 name값이 자바빈즈의 필드변수명과 일치해야함을 잊지말자.			
				 -->
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="회원가입" />
			</td>
		</tr>
	</form>
</body>
</html>