<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 쓰기</title>
</head>
<body>
	게시글을 작성하는 페이지입니다.
	<form action="<%=request.getContextPath() %>/write.do" method="POST">
		<p>
			제목 : <br/> <input type="text" name="title" value="${param.title}" />
			<c:if test="${errors.title }">
				제목을 입력해 주세요.
			</c:if>
		</p>
		<p>
			내용 : <br/> 
			<textarea name = "content" rows="5" cols="30" > ${param.content }</textarea>
		</p>
		<input type="submit" value="새 글 등록" />
	</form>
</body>
</html>