<%--
		[	Servlet에 대하여...	 ]
		- servlet이란?
			: JAVA를 이용해 웹 프로그래밍을 위해 고안된 것!
		- Servlet 구현 및 처리 방법)
			1) Servlet Java 파일을 작성한다.(extends HttpServlet)
			2) 해당 Servlet Java 파일을 -> Servlet class로 컴파일한다.
			 	컴파일된 Serlet class는 WEB-INF/classess 에 위치한다.
			3) Servlet Class를 web.xml 파일에 등록한다.(2가지 방법)
				1. in web.xml)
					<Servlet>
						<Servlet-name>now</Servlet-name>
						<Servlet-class>패키지명.클래스명</Servlet-class>
					</Servlet>
					<servlet-mapping>
						<servlet-name>now</servlet-name>
						<url-pattern>/now</url-pattern> 브라우저에서 요청할 url
									-> /now이면 /까지가 웹프로젝트까지의 경로임
									즉, http://localhost:80/JSP_HYR_PROJECT/now
					</servlet-mapping>
		         2. 어노테이션으로 등록하기
		         	Servlet 파일에 보면 @WebServlet("/now") 이렇게 하면
		         	수행시 web.xml에 자동으로 등록해 줌
		  
		  - [ Servlet java 파일의 작성 ]
		  ex)
		  	public class ServletClass extends HttpServlet { 
		  		// Servlet이 되기 위해서는 HttpServlet을 상속해야함!
		  	
		  		doGet(HttpServletRequest request, HttpServletResponse response){
		  			// Get 방식 요청을 처리하는 메서드로 매개변수들은 각각 JSP의 request, response 객체에 해당함
		  			
		  			// 웹 출력 방식
		  			response.setContentType("text/html;charset=UTF-8");
		  			request.setCharacterEncoding("UTF-8");
		  			PrintWriter out = response.getWriter();
		  			out.println("<br>");
		  		}
		  		doPost( same){}
		  		
		  		init(){ // 최초 요청시 Servlet class에 대한 객체 생성 후 초기화를 위해 
		  		 			// 한번 실행되는 메서드
		  		 			// 여기에서 DBCP 같은 커넥션 풀 작업을 해줄 수 있다.
		  		 			// 하지만, 이러한 초기화 작업은 가장 시간이 오래걸리므로
		  		 			// 최초 요청시 커넥션풀 작업을 해주면 사용자는 기다리는 경우가 생길 수 있다.(비효율)
		  		 			// 따라서, 웹 컨테이너가 시작될 때 해당 init()이 수행되어 Servlet 파일이 로딩되도록 해줄 수 있는데
		  		 			
		  			// web.xml에 
		  				<Servlet>
		  					<servlet-name>now</servlet-name>
		  					<servlet-class>~~</servlet-class>
		  					<load-on-startup>1(수행순서)</load-on-startup>
		  				</servlet>
		  			을 등록해 주면 된다.
		  		}
		  	}
		  	
		  	[	Servlet 의 초기화와 로딩	]
		  	1. 사용자가 브라우저를 통해 Servlet class에 대해 최초 요청을 한다.
		  	2. 최초요청시에만 해당 Servlet class에 대한 ("객체")를 생성하며 초기에 1회만
		  		init() 메서드를 호출하여 초기화 작업을 한다.(이때, 커넥션 풀 작업등을 한다.)
		  	3. 이후 동일한 Servlet class에 대한 사용자의 요청이 있다면 이미 생성되어 있는
		  		객체를 이용해 작업을 수행한다.(객체의 메서드를 수행)
		  	이때, 시간이 오래걸리는 init()작업은 웹 컨테이너가 최초 켜질 때 수행하도록 할 수 있는데
		  	바로 위에서 말한 것이 그에 해당하는 설명이다.
		  	
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