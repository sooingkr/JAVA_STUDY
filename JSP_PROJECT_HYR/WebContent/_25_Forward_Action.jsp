<%--
	[	jsp:forward 액션 태그	]
	
	: 하나의 JSP페이지에서 다른 JSP페이지로 요청처리를 전달할 때 사용된다.
	include 액션 태그는 실행흐름이 넘어갔다가 출력결과를 다시 버퍼에 채우고 실행흐름이 원래 페이지로 돌아온다면
	
	vs
	
	jsp:forward 액션 태그는 실행흐름이 아예 넘어간다. 즉 이 태그를 만나기 전까지 출력버퍼에 쌓은 데이터가
	이 태그를 만나면 비워지고 넘어간다. 다시 원래 페이지로 돌아올려면 response.sendRedirect 등으로 호출해줘야함...
	
	사용 이유)
			: 한 페이지에서 처리를 다 담당할 수도 있지만, 보여주는(View)와 처리를 분리시켜 코드처리의 효율성을 높이기 위해서
			즉, MVC 패턴 등을 떠올려!
	
	
	[넘길 때 include 액션태그처럼 파라미터 값을 같이 넘길 수 있다.]
 	<jsp:forward page="이동할파일경로">
 		<jsp:param name="name" value="value" />
 	</jsp:forward>
 	
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

</body>
</html>