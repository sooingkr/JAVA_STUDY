<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>제품번호</td> <td>XXXX</td>
		</tr>
		<tr>
			<td>가격</td> <td>10,000원</td>
		</tr>
	</table>
	
	
	<%
		String typeScore = "B";
	%>
	<!-- 
		이런식으로 value값을 입력할 때 변수명을 넣어 값을 전달하도록 하기 위해
		표현식을 쓸 수도 있다.
	 -->
	<jsp:include page="./module/infoSub.jsp" flush="false">
		<jsp:param name="type" value="<%=typeScore%>"/>
	</jsp:include>
</body>
</html>