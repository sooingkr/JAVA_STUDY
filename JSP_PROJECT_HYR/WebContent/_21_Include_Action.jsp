<%--
		[	Include 액션 태그	]
		: 사용 목적 ) 하단 푸터, 왼쪽 메뉴, 상단 등 모든 페이지에서 공통적으로 중복되는 부분들이 있다.
				이 부분들을 만약 모든 JSP 페이지마다 다 구현한다면 코드 중복이 어마어마할 것이고, 수정시에 모든 JSP 페이지를 수정해 주어야 한다.
				=> 따라서, 한 JSP페이지에서 다른 JSP페이지를 포함시킬 수 있도록 한 것이 Include 액션 태그와 Include 디렉티브이다.
				
			특징)
				1. Include 액션 태그의 경우 중요한 점은, 
						포함시킬려는 문서로 (실행흐름이 옮겨간다는 점)이다.
					ex) A문서에서 7번째 줄에서 B문서를 include 액션을 통해 포함시켰을 때
					=> A문서의 6번째 줄까지 출력 결과를 버퍼에 쌓아두고, 7번째 줄에서 실햄흐름이 B문서로 넘어간 뒤,
						B문서에서 출력 결과를 버퍼에 쌓고, 다시 A문서로 돌아와 이후 결과를 처리해 출력 버퍼에 쌓은 뒤 최종적으로 브라우저로 출력한다.
				
				형식)
					- <jsp:include page="포함시킬 jsp 파일" flush="false" >
							<jsp:param name="전달할변수명" value="값" />
							<jsp:param name="전달할변수명2" value="값2" />
					  </jsp:include>
					  
					  ==> 전달받은 문서에서는 request.getParameter()로 가져오면 됨...
					  
					  이때, 특징적인 것은 )
					  	: B문서로 넘어가기 전에 name이라는 변수에 cbk라는 값이 들어 있는 상태로
					  		제어 흐름이 B문서로 넘어갈 때, <jsp:param name="name" value="황영롱" /> 을 통해 같은 name값으로 전송한다면
					  		전달받은 B문서에서 name값에는 황영롱만 들어 있는 것이 아니라, 황영롱과 cbk 두개의 값이 들어있게 된다.
					  		=> 따라서, request.getParameterValues("name")을 하면 두개의 값을 확인할 수 있고
					  	이후, 제어흐름이 A로 돌아오면, name에는 처음의 cbk만 들어있게 된다.
					  	==> 다시말하면, <jsp:param을 통해서 전달한 값은 전달받은 곳에서만 유효하다는 것이다.!!!!
					  	-> 따라서, 다시 A로 돌아와 name값을 출력해보면 cbk값만 뜨게 된다.
					  	
			한글처리)
				: <jsp:param을 통해 전달할 때도 인코딩 방식이 중요함 
					request.setCharacterEncoding("UTF-8")로 잘 지정해 주어야 함!		  				
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
	<table width="400" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2">
				<jsp:include page="./module/top.jsp" flush="false" /> <!-- 상단 추가 -->
			</td>
		</tr>
		<tr>
			<td width="100" valign="top">
				<jsp:include page="./module/left.jsp" flush="false"/> <!--  좌측 메뉴 include -->
			</td>
			<td width="300" valign="top">
				이 부분은 매번 바끼는 부분(공통 부분이 아닙니다.)<br/><br/><br/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="./module/bottom.jsp" flush="false">
					<jsp:param name="name" value="value" />
				</jsp:include>
				 <!--  하단 푸터 include -->
			</td>
		</tr>
		
	</table>
</body>
</html>