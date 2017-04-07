<%--
		[	쿠키(Cookie)란?	 ]
		: 사용자의 정보 등을 저장하기 위한 수단 중 하나.
		
		- 쿠키의 동작 방식)
			1) 웹서버(JSP 페이지 상)에서 쿠키를 생성하고 쿠키에 데이터 저장,변경,삭제 등을 한다.
			2) 이렇게 생성된 쿠키를 응답 데이터의 헤더에 저장해서 웹브라우저(Client)에 전송한다.
			3) 웹브라우저(Client)는 받은 쿠키를 Client 쪽에 저장해 놓는다.
				(이 쿠키는 설정된 유효시간 동안 지속되며, 유효시간을 설정하지 않으면 웹브라우저 종료시까지 지속된다.)
			3) 웹브라우저는 서버의 쿠키 사용 요청이 있을 때마다 쿠키를 웹서버(JSP 페이지)로 전송한다.
			
		- 쿠키의 구성)
			1) 이름 : 각각의 쿠키를 구별하는 데 사용되는 이름
			2) 값 : 쿠키의 이름에 대응되는 값
			3) 유효시간 : 쿠키의 유지 시간
			4) 도메인 : 쿠키를 전송할 도메인
							(웹브라우저에서 어느 서버측으로 전송할지를 지정하는 요소)
						* 기본적으로 "쿠키"는 쿠키를 생성한 서버로만 전송하게 되어 있다.
						따라서, naver.com , mail.naver.com , javacan.naver.com 등 여러 서버로 쿠키를 동시에 보내야 할 필요가
						있는 경우, 쿠키를 전송할 도메인을 지정해 주어야 한다.
			5) 경로 : 쿠키를 전송할 요청 경로
							(웹브라우저에서 어느 위치에 있는 JSP 페이지로 쿠키를 전송할지 결정하는 요소)
 						* 4번의 도메인에서 쿠키가 해당 쿠키를 생성한 서버로만 전송한다는 것처럼
 						   경로도 경로를 지정하지 않으면, 해당 쿠키를 생성한 JSP페이지가 위치한 폴더로만 쿠키가 전송된다.
 						   따라서, 
 						   => 쿠키처럼 여러곳에서 다 고루 사용될 필요가 있는 요소의 경우
 						   		☆★☆★☆★ setPath("/") 처럼 webapps/ROOT 위치로 지정하는 경우가 많다!☆★☆★
 						   		
 		- detail)
 			1) 쿠키 생성하기
 				a) Cookie cookie = new Cookie("cookieName", "cookieValue");
 				// 쿠키 값을 저장할 쿠키 객체를 생성한다.
 			    b) response.addCookie(cookie); 
 			    // response 객체의 addCookie메서드를 이용해 쿠키를 생성, 등록한다.
 			    
 			    ex) Cookie cookie = new Cookie("name", URLEncoder.encode("황영롱","UTF-8"));
 			    	  response.addCookie(cookie);
 			
 			2) 쿠키 값 읽어오기
 
 				a) Cookie[] cookies = request.getCookie();
 				    // 웹브라우저에 저장되어 있는 쿠키를 읽어 온다.
 				b) if ( cookies != null && cookies.length > 0 ) {
 						for (int i=0; i<cookies.length; i++) {
 							out.println( cookies[i].getName() + " = " + URLDecoder.decode( cookies[i].getValue(), "UTF-8" );
 							// 쿠키에 저장된 변수명과 값을 읽어온다.
 							// 하나의 쿠키에는 하나의 변수명과 값이 들어 있다.
 						}
 					}else {
 						out.println("쿠키가 존재하지 않습니다.");
 					}
 					
 			3) 쿠키 값 변경 및 쿠키 삭제하기
 				: a) 쿠키 값 변경하기 :
 					: 기존에 쿠키값이 존재한다면 조건을 주어 쿠키가 존재하는지 확인하고 쿠키가 존재하는 경우 
 				  		=> 기존의 쿠키 등록하는 방식을 그대로하면, 기존 쿠키값은 사라지고 새로운 값이 등록된다.
 				  ex) Cookie[] cookies = request.getCookie();
 				  		if ( cookies != null && cookies.length > 0 ){
 				  			Cookie cookie = new Cookie("name", URLEncoder.encode("변경할 값"));
 				  			response.addCookie(cookie);
 				  		}
 				  b) 쿠키 삭제하기
 				    : 기존 쿠키가 존재하는지 확인하고 존재한다면 유효시간을 설정하는 setMaxAge(시간(초))를 호출해 시간을 0으로 세팅하면 된다.
 				    ex) 
 				    	Cookie[] cookies = request.getCookie(); // 쿠키목록을 가져오고
 				    	if ( cookies != null && cookies.length > 0 ){ // 기존에 쿠키가 존재한다면
 				    		for(int i=0; i<cookies.length; i++){ // 존재하는 쿠키 수만큼 돌면서
 				    			if ( cookies[i].getName().equals("name") ) { // for문을 돌며 각 쿠키에 name이라는 변수가 들었는지 확인하고
 				    				Cookie cookie = new Cookie("name",""); // 쿠키 객체를 생성하고 name값을 빈 문자열로 초기화한 뒤(기존 name값이 빈문자열로 바낌)
 				    				cookie.setMaxAge(0); // 유효시간을 0으로 세팅해버린다.
 				    				response.addCookie(cookie); // 해당사항을 적용한다.
 				    			}
 				    		}
 				    	}	
 				    	
 			4) 쿠키의 도메인
 				: 쿠키의 도메인을 설정하지 않으면, 웹 브라우저는 웹브라우저가 저장하고 있는 쿠키를 생성한 서버한테만
 				  전송하게 된다.
 				  하지만, 이따금씩 여러 서버로 쿠키를 전송해야하는 경우가 있다.
 				  naver.com, mail.naver.com 등등.. 여러 서버로말이다.
 				  
 				  방법)
 				  	쿠키 객체를 생성해서, setDomain("도메인 지정") 을 사용한다.
 				  	도메인 표기법)
 				  		- .somehost.com : .을 사용할 경우 somehost.com이 포함된 모든 도메인에게 전송한다.
 				  			ex) mail.somehost.com , www.somehost.com 둘 다 전송이 되는 것
 				  		- www.somehost.com : 특정 도메인에 대해서만 쿠키를 전송한다.
 				  	
 				  	ex)
 				  		Cookie cookie = new Cookie("id", "madvirus");
 				  		// 쿠키를 생성
 				  		cookie.setDomain(".somehost.com"); // 전송할 도메인을 지정한다.
 				  		response.addCookie(cookie); // 변경사항을 반영한다.
 			5) 쿠키의 경로
 			    : 쿠키를 전송할 서버를 도메인에서 지정한 것 처럼 쿠키를 공유할 기준 경로를 지정한다.
 			    만약, 경로를 설정하지 않으면 해당 JSP 페이지가 위치한 폴더에 있는 것들에서만 공유할 수 있게 된다.
 			    
 			    방법)
 			    	cookie.setPath("/"); // 주로 / 경로를 많이 쓴다(여러군대에서 공유되기 때문에)
 			    	
 			    ex) 
 			    	Cookie cookie = new Cookie("path1", URLEncoder.encode("경로:/chap09/path1", "UTF-8");
 			    	cookie.setPath("/chap09/path1"); // 공유할 경로를 지정한다.
 			    	// 생략시 해당 쿠키를 생성하는 JSP가 위치한 폴더를 기준으로 된다.
 			    	// 여기서는 path1 폴더 하위에 있는 모든 파일을 대상으로 한다.
 			    	response.addCookie(cookie); // 설정사항을 반영한다.
 			    	
 			 6) 쿠키의 유효시간 설정
 			 	: 쿠키가 유지되는 시간을 설정하는 것으로, 해당시간 동안은 웹브라우저를 종료해도 쿠키는 유지된다.
 			 	if) 쿠키의 유효시간을 설정하지 않으면
 			 		=> 웹브라우저를 종료하면 쿠키가 소멸되게 된다.(defualt)
 			 	지정 방법)
 			 		cookie.setMaxAge(시간(초));
 			 		
 			 		ex)
 			 			Cookie cookie = new Cookie("onehour", "1time");
 			 			cookie.setMaxAge(60*60); // 60(초) * 60(1분0 = 1시간
 			 			response.addCookie(cookie)
 			 			// 한시간동안 유지되는 쿠키가 생성된다.
 --%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- 
			[	쿠키 생성하기 예제	]
	 -->
	<%
		Cookie cookie = new Cookie("name", URLEncoder.encode("황영롱","UTF-8"));
		response.addCookie(cookie);
	%>
	
	쿠키값 :
	<%
		out.println( "변수 : " + cookie.getName() + "값 : " + URLDecoder.decode(cookie.getValue(),"UTF-8"));
	%>
</body>
</html>