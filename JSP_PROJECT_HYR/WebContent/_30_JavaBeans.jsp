<%--
		[	자바빈즈 예제	]
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
	
		<jsp:useBean id="member" class="javaBean.MemberInfo" scope="request" />
		<!-- 
			위의 한줄은 객체를 생성하는 과정을 나타낸다고 보면 되는데 싱글톤으로 자동형성해 준다.
			즉, 기존 객체가 있으면 기존객체를 반환하고 기존객체가 없을시 생성하는 것이다.
			javaBean.MemberInfo member = javaBean.MemberInfo.getInstance() 한 것과 비슷...
			
			속성) 
				- id : 해당 객체를 지칭할 변수라고 생각하면 된다. 객체 생성 후 member에 주솔르 저장한다는 의미랑 같다.
				- class : 자바빈 클래스를 지정하는데 패키지명.클래스명 으로 풀네임을 지정해 주어야 한다.
				- scope : request/session/page/application 처럼 해당 자바빈 객체가 공유될 수 있는 범위를 지정한다.
					= 이 scope가 있기 때문에 jsp:forward 와함께 사용시 해당 공유객체에 자바빈 객체를 저장해 JSP 페이지들에서
						  공유할 수가 있다!!(장점)
					default 값은 page이다.
		 -->
		 
		 <!--  데이터 세팅 -->
		 <jsp:setProperty name="member" property="id" value="sooingkr" />
		 <jsp:setProperty name="member" property="name" value="황영롱" />
		 <!-- 
		 	위 코드는 데이터를 세팅하는 코드이다.
		 	각 속성은)
		 		- name : 아까 객체를 가리키는 변수명을 기재한다.
		 		- property : 속성값 즉, 자바빈 내부에 저장할 필드변수명
		 		- value : 저장할 값을 입력한다.
		  
		  		이 코드를 만약 자바빈즈를 이용하지 않는다면...
		  			member.setId(request.getParameter("name")); 등과 같이 해줬어야 함...(form에서 넘겨준다 가정할 때)
		  -->
		  
		  <jsp:forward page="./_31_JavaBeans.jsp"/>
		  <!-- 
				javaBeans의 scope가 request임으로 forward 액션을하면 request 객체에 자바빈즈가 같이 저장되어 넘어갈 것이다.
				
				전단원에서 request 객체의 setAttribute에 저장한 request 객체가 넘어간 것과 유사.		  
		   -->
		  
		  
</body>
</html>