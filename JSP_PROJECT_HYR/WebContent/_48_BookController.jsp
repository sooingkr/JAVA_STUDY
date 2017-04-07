<%--
	입력한 책을 등록하는 페이지
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="book_self.*"%>
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
	<jsp:useBean id="bookdto" class="book_self.BookDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="bookdto" />
	<!-- 
		넘겨온 정보 통째로 빈즈 객체에 저장
	 -->
	<%
		BookDAO dao = new BookDAO();
		dao.insertBook(bookdto); // 넘어온 값 담고있는 빈즈 객체를 insert 메서드 통해 전달
		// insert 메서드는 내부적으로 디비에 저장하도록 되어 있음...
		System.out.println(bookdto.getTitle() + " 저장 성공!");
		// 처리하고는 원래 목록 페이지로 돌아가야함...
		response.sendRedirect("./_48_book_list.jsp");
		// jsp에서 이동할 수 있는 forward 액션 태그와 sendRedirect의 차이점!!
		// sendRedirect는 아예 주소가 바껴서 이동하는 것이고
		// forward 액션태그는 주소는 그대로인 상태에서 보이는 화면만 이동하지만
		// 데이터를 싣어서 보낼 수 있음...
	%>


</body>
</html>