<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 목록</title>
</head>
<body>


	<!-- private int article_no; // 개시글 번호
	private String title; // 제목
	private Date regDate; // 게시글 등록 시간
	private Date modDate; // 게시글 수정일
	private int readCnt; // 조회수
	private Writer writer; // 게시글 작성자 객체를 저장하는 용도
	 -->

	<table border="1">
		<tr>
			<td colspan="4"><a href="<%= request.getContextPath() %>/write.do">[게시글 쓰기]</a></td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:if test="${articlePage.hasNoArticles() }">
			<tr>
				<td colspan="4">게시글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="article" items="${articlePage.content}">
			<tr>
				<td>${article.article_no}</td>
				<td>
					<a href="<%= request.getContextPath() %>/read.do?no=${article.article_no}&pageNo=${articlePage.currentPage}">
						${article.title}
					</a>
				</td>
				<td>${article.writer.name }</td>
				<td>${article.readCnt }</td>
			</tr>
		</c:forEach>
		<c:if test="${articlePage.hasArticles() }">
			<tr>
				<td colspan="4">
					<c:if test="${articlePage.startPage > 5 }">
						<a href="<%= request.getContextPath() %>/list.do?pageNo=${articlePage.startPage - 5 }">[이전]</a>
					</c:if>
					<c:forEach var="pNo" begin="${articlePage.startPage }" end="${articlePage.endPage }">
						<a href="<%= request.getContextPath() %>/list.do?pageNo=${pNo }">[${pNo }]</a>
					</c:forEach>
					<c:if test="${articlePage.endPage < articlePage.totalPage }">
						<a href="<%= request.getContextPath() %>/list.do?pageNo=${articlePage.startPage + 5 }">[다음]</a>
					</c:if>
				</td>
			</tr>
		</c:if>
	</table>
</body>
</html>