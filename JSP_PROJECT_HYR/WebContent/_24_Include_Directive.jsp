<%--
			[	 Include directive	] && [	Include 디렉티브 vs Include 액션 	]
			
			공통점)
					: include 액션, 디렉티브 모두 다른 JSP 문서를 포함시킬 때 사용된다.
			차이점)
				    : Include 액션 : 의 경우 제어흐름이 옮겨간다는 특징이 있다.(동적)
				      Include 디렉티 : 의 경우 해당 문서의 코드를 포함시킨 뒤 자바 코드로 변환하고 그걸 컴파일해 서블릿 클래스를 만든다.
				      						(정적)
			
			include 디렉티브의 특징)
					: - 포함시키는 문서라는 의미에서 확장자를 jspf(JSP framgment) 라고 쓰는 것이 좋다.
				      - 코드를 추가한 뒤 자바코드로 변환하고 컴파일하기 때문에
				      	=> ★☆*해당 문서에서 사용중인 변수들을 원 문서에서도 사용할 수 있다.!!!☆★
				      
			용도) 
				- include 액션 : 좌측 메뉴 상단처럼 변하긴 변하되 고정적으로 들어가는 페이지를 넣을 때 주로 사용된다.
				- include 디렉티브 : - 하단 저작권처럼 정적인 페이지를 포함시키거나
											- 요청받은 파라미터 값들을 저장해 놓는 용도로 사용한다.
								=> 예를들어, 매 페이지마다 session.setAttribute("name","value")와 같은게 많이 일어난다면
									코드 중복이 많아짐. 따라서, include 디렉티브에서 파라미터 값을 가져와 변수에 저장해 놓고
								include 디렉티브를 포함시켜 해당 변수를 사용하는 방법을 사용한다.
								
								
			[	Include 디렉티브의 자동 추가	 ]
			-사용목적)
				: 예를들어 500개의 jsp 페이지에 footer를 추가한다고 했을 때 <%@include 로 한다고 하더라도
				  해당 문장만 500개를 써야할 것이다. 이 또한 코드 중복이고 이를 해결하기 위해서
				  ~~패턴을 가지는 모든 JSP 문서에 자동으로 include 디렉티브를 추가할 수 있다.
		 	- 방법)
		 		: 1. web.xml 파일에 다음을 추가하면 된다.
		 				<jsp-config>
							<jsp-property-group>
									<description>해당 경로에 있는 *모든 JSP문서에 포함시킨다.</description>
									<url-pattern>/*</url-pattern>
									<include-prelude>앞에 포함시킬 문서경로</include-prelude>
									<include-coda>맨마지막에 포함시킬 문서 경로</include-coda>
							</jsp-property-group>
						</jsp-config>
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/module/dateFooter.jspf"%>
	<!--  include 디렉티브를 추가한다. -->

	include 디렉티브를 통해 포함시킨 문서에서 선언되어 있는 변수 now를 통한 출력 :
	<%=now%>

	<!-- 
			now 변수는 이 문서에 선언되어 있지 않고, dateFooter.jspf에 선언되어 있는 변수인데 소스코드가 붙여진 뒤
			변환,컴파일 되기 때문에 사용할 수 있는 것을 알 수 있다.
		 -->
</body>
</html>