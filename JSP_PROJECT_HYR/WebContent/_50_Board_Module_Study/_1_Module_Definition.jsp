<%--
			[	웹프로젝트 개발 패턴 	]
			
		- 구성요소) MVC
			1. "M"odule : DAO(=Data Access Object)
				: DB에 접근하는 객체
				=> 이렇게 DB 등에 접근하는 클래스는 ("싱글톤")으로 구현이 권장 됨.
			2. DTO(=Data Transfer Object)
				: 자바빈즈처럼 하나의 데이터 집합 ex) 회원정보를 저장하고 있는 객체
			3. "C"ontroller : Service JSP Page
				: 사용자의 요청을 처리하는 페이지
			4. "V"iew : View Jsp Page
			
			이 폴더에서는 "블로그"를 만들어 볼 것
			
			[ DB 세팅 ]
			create table guestbook_table (
				message_id int not null primary key auto_increment, // auto_increment : 삽입시 지정안하면 자동으로1씩 증가한 값을 넣음 
				guest_name varchar(50) not null,
				password varchar(10) not null,
				
				message text not null // 많은 문자열을 저장하기 위해 text 타입으로 선언
			)
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>