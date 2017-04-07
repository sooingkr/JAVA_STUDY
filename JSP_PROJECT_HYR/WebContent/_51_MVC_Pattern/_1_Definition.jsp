<%--
		[	모델1		vs		모델2(MVC 패턴)	 ]
		
		: 웹프로젝트를 기획할 때 모델1과 모델2방식으로 대표적으로 구현할 수 있다.
		
		차이점 :
			모델1은 JSP페이지에서 비지니스 로직과 화면 출력을 모두 처리한다는 것!
			but
			모델2는 JSP 페이지는 View(화면 출력)만을 담당한다.
			
		- [ 모델2(MVC) 패턴이란?? ]
		: - M(Module)    : 비지니스 로직을 처리한느 부분으로 
								 ex) DAO, DTO(자바빈), 서비스 클래스 등이 해당된다.
		  - V(View)        : 사용자의 화면에 보여줄 출력을 담당한다. 
		  						 ex) JSP 페이지
		  - C(Controller) : 모든 사용자의 요청을 받아들이고 분석해서 모듈을 통해 처리를 하도록하고 해당 결과를 뷰로 전달해 출력한다.
		  						 즉, 컨트롤러는 모델과 뷰 사이의 흐름제어를 담당한다.
		  						 + ( 모든 페이지에서 공통으로 사용하는 사용자 인증 등도 컨트롤러가 담당한다.) 
		  						 ex) Servlet 페이지
		  						 
		 - [ MVC 패턴의 장점? ] : View와 Module간의 종속관계를 끊어 개발의 효율을 높일 수 있다.
		 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 
		 - [ MVC 패턴의 작성법 ]
		 : 사용자의 모든 요청은 하나의 "서블릿 파일"이 받아 흐름제어를 하게 된다. 따라서, 서블릿 파일은 다음과 같은 작업을 해야 한다.
		 	- Servlet :
		 			1) 사용자의 요청을 받아 doGet() 혹은 doPost() 메서드를 호출한다.
		 			2) 어떤 요청인지 분석한다.
		 			3) 분석한 기능을 모델을 사용하여 수행한다.
		 			4) 모델을 이용해 처리한 결과물을 request.setAttribute나 session.setAttribute를 통해 저장하고
		 				결과물에 따라 이동할 페이지를 지정한다.
		 			5) 결과물을 전송할 JSP페이지로 RequestDispatcher를 이용해 포워딩한다.
 
 			ex) _51_MVC_Pattern_package의 예제를 살펴보자.
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