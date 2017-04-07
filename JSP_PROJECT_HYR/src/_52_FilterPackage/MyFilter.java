package _52_FilterPackage;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		request.setCharacterEncoding("UTF-8"); // 인코딩 타입 지정하기
		
		HttpServletRequest h_request = (HttpServletRequest)request;
		HttpSession h_session = h_request.getSession();
		// 우리가 쓰는 request와 response는 HttpServletRequest/Response 것이기 때문에
		// 원하는 기능을 사용하고자하면 해당 메서드에 있는 request, response 인자들을 HttpServlet 형태로 형변환이 필요하다.
		
		
		String uri = h_request.getRequestURI();
		// 요청한 uri에 loginServletTest.do 로 요청된 경우에는
		// 로그인이 된건지 안된건지 작업을 처리해줘야 하는데 필터가 적용되어
		// 세션 id가 없어 바로 logIn.jsp로 이동할 수 있다. 따라서 수행이 가능토록
		// 필터가 적용되지 않도록 예외처리가 필요하다.
		if ( uri.indexOf("loginServletTest.do") < 0 ){ // loginServlet.do로 요청하지 않은 경우는
			// 로그인 상태인지 확인하고
			
			String id = (String)h_session.getAttribute("id");
			if ( id == null || id.trim().length() == 0 ){ // id 가 세션에 없다면
				HttpServletResponse h_response = (HttpServletResponse)response;
				
				// sendRedirect 방법
				//h_response.sendRedirect("/JSP_PROJECT_HYR/_52_Filter/logIn.jsp");
				// 포워딩으로 하는 방법
				RequestDispatcher dispatcher = request.getRequestDispatcher("/JAVA_PROJECT_HYR/_52_Filter/logIn.jsp");
				dispatcher.forward(request, response);
				
				return; // 세션에 id가 없는경우(즉, 로그인이 안되어 있는 경우) 해당 페이지로 이동 후
				// 아래 코드 더이상 실행 안하고 return하도록 함
			}
			
		}
		
		
		
		
		// 원래 실행하던 곳으로 가세요!
		chain.doFilter(request, response);
		
		// servlet보다 위쪽에다 web.xml에 등록한다.
		/*
		 <filter> 
	  		<filter-name>MyFilter</filter-name>
	  		<filter-class>_52_FilterPackage.MyFilter</filter-class>
	  	</filter>
	  	<filter-mapping>
	  		<filter-name>MyFilter</filter-name>
	  		<url-pattern>*.do</url-pattern> *.do 임으로 모든 ~~.do로된 url 요청시 다 이필터를 실행하게 된다.
	  	</filter-mapping>
	  */
	} // Filter를 구현!
	
	

}
