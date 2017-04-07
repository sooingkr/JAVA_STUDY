<%--
		[	자바빈즈	  ]
		: JSP에서 "자바빈즈"는 데이터(속성)을 저장하는 DO("Data Object") 역할을 한다. == DTO(Data Transfer Object)
		
		자바빈즈 문법을 이용하면, 일일이 데이터를 세팅하고, 불러오는 긴 소스코드를 몇줄로 처리할 수 있다.
		
		자바 빈즈 파일 형식) ~.java
		public class MemberInfo {
			private String id;
			private String password;
			
			// getter, setter는 반드시 get set 다음 "대문자"가 와야함!(자동완성으로 만들자...)
			// 문법 규칙 맞춰야 나중에 호출시 자동으로 넣기가 가능하니까...
			public String getId(){
				return id;
			}
			public void setId(String val){
				this.id = val;
			}
		}
		// javaBean 폴더에 MemberInfo 자바빈 클래스를 만들자!
		
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