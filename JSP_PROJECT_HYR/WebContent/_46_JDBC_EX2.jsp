<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String memberId = request.getParameter("memberId");
		
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcDriver = "jdbc:mysql://localhost:3306/jsptest?useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPass = "dudfhd13";
		String query = "select * from MEMBER where MEMBERID= '" + memberId + "'";
		// 홑따옴표(') 표시하려면 이것도 문자열로 생각해서 " " 안에 넣어야함
		// PrepareStatement 를 사용하면 자동으로 홑따옴표문제 해결해줌으로 신경쓸 필요 없어짐.
		out.println(query);
		
		Connection conn = null;
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

		PreparedStatement stmt = null;
		
		//stmt = conn.createStatement();
		String s = "Select * from MEMBER where MEMBERID= ?";
		stmt=(PreparedStatement)conn.prepareStatement(s);
		stmt.setString(1, memberId);
		
		ResultSet rs = null;
		//rs = stmt.executeQuery(query);
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			out.println(rs.getString("NAME") + "<br/>");
			out.println(rs.getString("MEMBERID") + "<br/>");
			out.println(rs.getString("EMAIL"));
		}
		rs.close();
		stmt.close();
		conn.close();
	%>
</body>
</html>