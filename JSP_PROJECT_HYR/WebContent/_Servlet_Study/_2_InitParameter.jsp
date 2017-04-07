<%--
		[	초기 변수	 ]
		: why 사용??
			예를들어 공통으로 사용하는 파일에 접근 경로, 공통 상수 등에 이용될 수 있고
			또,
			********
			DB연결시 사용되는 id, pwd, url 등의 정보를 소스코드에 그냥 기재시 역컴파일의 대상이 되어
			보안상 위험할 수 있다. 따라서 이러한 파일은 
				- 초기 변수에 설정해 놓고 가지고와 사용하거나
				- Properties 파일에 설정해 놓고 가져올 수 있다.
				
		[ 초기화 변수 사용법 ]
		1. 해당 서블릿 내에서만 사용가능한 초기 변수 설정하기
			web.xml에서
				<servlet>
					<servlet-name>now</servlet-name>
					<servlet-class>~~</servlet-class>
					<init-param>
						<param-name>jdbcDriver</param-name>
						<param-value>com.mysql.jdbc.Driver</param-value>
					</init-param>
				</servlet>
			처럼 등록한 뒤
				서블릿 클래스 파일에서
					getInitParameter("jdbcDriver") 를 통해 가져오는 방법
		
		2. 웹프로젝트 전체에서 사용되는 초기 변수로 설정한 뒤 사용하기
 			web.xml 파일에서
 				<Context-param>
					 	<param-name>jdbcDriver</param-name>
						<param-value>com.mysql.jdbc.Driver</param-value>		
 				</Context-param>
 			처럼 등록하고
 				Servlet class에서 getInitParameter("jdbcDriver"); 처럼 가지고 오거나
 				JSP 파일에서 작업시 application.getInitParameter("jdbcDriver"); 로 가지고 오기
 
 		[	Properties 파일에 값 저장해 놓고 가지고 오는 방법	]
 		information.properties 처럼 properties 파일을 생성하고
 		여기에 Key=Value 형태로 값을 저장한다.
 		ex)
 			jdbcDriver=com.mysql.jdbc.Driver
 			jdbcURL=jdbc:mysql://localhost:3306/jsptest
 			처럼 key=value 형태로 저장한다.
 			
 			그리고, 클래스 파일에서 
 			Properties properties = new Properties();
 			FileInputStream f = new FileInputStream("properties 파일의 경로");
 			properties.load(f);
 			String jdbcDriver = properties.getProperty("jdbcDriver");
 			String jdbcURL = properties.getProperty("jdbcURL"); 
 			처럼 해서 가지고와 사용한다.
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