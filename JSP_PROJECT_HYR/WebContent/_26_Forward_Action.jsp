<%--
	form 태그에서 여러 종류의 url 중에 이동하고 싶은 사이트를 선택해서 누르면
	해당하는 곳으로 이동하도록 하자. (jsp 액션 태그 활용)
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="./_27_Forward_Action.jsp">
		보고 싶은 페이지 선택:   <select name = "code">
												<option value="A">A페이지</option>
												<option value="B">B페이지</option>
												<option value="google">구글</option>
										</select>
										<input type="submit" value="이동" />
	</form>
</body>
</html>