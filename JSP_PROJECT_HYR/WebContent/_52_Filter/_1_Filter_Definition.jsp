<%--
		[	필터	] 
		: 특정 url 요청시 바로 해당 JSP 페이지로 진입하기 전에 그 사이에서 데이터를 가공하거나 필터링 해 주는 역할을 담당한다.
		즉) 웹 상에서 사용자 요청 페이지가 실행하기 전/후 필요에 의해 데이터를 가로채 작업을 하고자 하는 경우 사용
		
		
		활용 대표 예)
			: 1) 페이지 진입시 로그인된 사용자인지 판별하는 용도
					(한번의 작업으로 모든 페이지에 적용할 수 있기 때문, 만약 사용자 인증을 필터를 사용하지 않으면
			 		모든 페이지에서 로그인된 상태인지를 확인하는 코드를 작성해 주어야 함)
			   2) 전달받은 데이터를 인코딩하는 경우
			      : 모든 페이지에서 setCharacterEncoding하는 코드를 넣기보다 한번에 미리 해서 보낼 수 있도록
			   3) 세션 데이터를 인증하는 경우
		 
		구현 방법)
			: 1) Filter 인터페이스를 구현하는 클래스로 작성 후 web.xml에 등록
			class 클래스명 implements Filter {
				public void init(FilterConfig fc){
				
				}
				public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				{
					// 필터 작업
					chain.doFilter(request, response);
				}
			}
			
		 	 2) 작성 후, 서블릿 필터를 web.xml에 등록(반드시 서블릿 보다 위에 선언되어야 함)
			<filter>
				<filter-name>필터명</filter-name>
				<filter-class>필터클래스(full path)</filter-class>
				<init-param>
					<param-name>매개변수명</param-name>
					<param-value>값</param-value>
				</init-param>
			</filter>
			<filter-mapping>
				<filter-name>필터명</filter-name>
				// 이런 url로 요청시 이 필터를 실행해 주세요! 라는 의미로 등록
				<url-pattern>필터 패턴</url-pattern>
			</filter-mapping>
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