<%--
		[	JDBC	  ]
		:JSP의 데이터베이스 구동 원리)
		JSP페이지 -> (JDBC API) -> (MySQL용 JDBC드라이버) -> MYSQL DB
											-> (Oracle용 JDBC 드라이버) -> Oracle DB
											
		이처럼 특정 DB에 맞는 jdbc 드라이버(클래스파일)를 통해 각 DB에 접근할 수 있도록 jdbc API가 제어해준다.
		
		활용순서)
		1. jdbc 드라이버 로딩하기
			Class.forName("com.mysql.jdbc.Driver");
			// 각 DB마다 다른 드라이버 클래스가 들어간다. MySQL 은 "com.mysql.jdbc.Driver"
		
		2. DB연결을 위한 URL 설정하기
			String jdbcDriverURL = "jdbc:mysql://localhost:3306/DB이름?useUnicode=true&characterEncoding=utf8";
			String UserId = "root"; // 연결할 때 로그인할 아이디
			String UserPassword = "dudfhd13" // 패스워드
		
		3. DB 연결 객체 구하기
			Connection conn = null;
			
			conn = DriverManager.getConnection(jdbcDriverURL, UserId, UserPassword);
			// DriverManager 객체의 getConnection() 메서드를 통해 DB에 연결된 Connection 객체를 가져옴.	
					
		4. 작업할 Query문을 위한 Statement 작성
			String query = "insert into MEMBER values("sooingkr","황영롱","sooingkr@naver.com");
			String selQuery = "select * from MEMBER";
			
		5. Query문 수행하기 위한 Statement 객체 얻어오기
			Statement stmt = conn.createStatement();
		=> Statement 객체의 경우 쿼리문에 ' ' 가 들어가야하는 문제가 있는데
			PrepareStatment를 사용하면 이 문제를 자동으로 해결해 준다. 
		
		권장)[PreparedStatement 사용법]
			String sql = "insert into MEMBER values(?, ?, ?)";
			prepareStatement pstmt = conn.preparestatement(sql);
			pstmt.executeQuery(); // select문의 경우...
			pstmt.executeUpdate(); // update, insert, delete의 경우...
			
		6. Statement 객체를 통해 Query문 수행하기
			
			- stmt.executeQuery(query) : select문을 수행함 수행결과로 ResultSet 객체를 반환
					ResultSet rs = stmt.executeQuery(query);
			- stmt.executeUpdate(query)	: update, delete, insert를 수행할 때 사용하며 결과로 업데이트한 튜플 수를 반환.
					int updateNum = stmt.executeUpdate(query);
					
					
		7. select한 ResultSet 객체를 통해 값 읽어오기
			
			ResultSet rs = stmt.executeQuery(query);
			// ResultSet은 Iterator와 유사한 성질을 가지고 있음.
			while(rs.next()){
				out.println( rs.getString("NAME") );
				out.println( rs.getString("MEMBERID") );
			}
			
		8. 모든 자원 close()
			DB연결할 때 Exception이 발생할 수 있음으로 try로 묶고 
			맨 마지막에 finally 구문에서 모든 객체가 close()될 수 있도록 해준다.
			
			
			==> [[ 커넥션 풀 ]]
				: 매 요청마다 커넥션을 생성하면 너무 많이 만들어지고 시간도 오래걸림
				따라서, 커넥션 풀이라는 곳에 미리 웹프로젝트 시작시 한번에 여러개 생성해 놓고
				생성한 것을 가져다가 쓰고 다쓰면 반납하는 식으로 하는게 효율이 좋음
				따라서 사용됨
				
				=> 사용법은 사용할때 인터넷 참고하자....못외우겠다...;;
 --%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>