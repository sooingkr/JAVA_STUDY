<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 등록</title>
</head>
<body>
	게시글 추가 성공 페이지
	게시글을 등록했습니다.<br/>
	
	 <a href="<%= request.getContextPath() %>/list.do" >[ 게시글 목록 보기 ]</a>
	 <a href="<%= request.getContextPath() %>/read.do?no=${requestScope.newInsertedArticleNo}" >[ 게시글 내용 보기 ]</a>
</body>
</html>