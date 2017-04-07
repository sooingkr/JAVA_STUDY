/*
 * web.xml 등록)
 * 
 * 	 <servlet>
    	<servlet-name>LoginServletName</servlet-name>
    	<servlet-class>_52_FilterPackage.loginServletTest</servlet-class>
  	</servlet>
  <servlet-mapping>
    <servlet-name>LoginServletName</servlet-name>
    <url-pattern>/loginServletTest.do</url-pattern>
  </servlet-mapping>
 * 
 */
package _52_FilterPackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class loginServletTest extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// ID... PW...를 DB에서 검증하는 작업........
		HttpSession session = request.getSession();
		session.setAttribute("id",request.getParameter("id"));
		
		// id가 없거나 공백이면 main으로 넘어가는게 아니라 다시 logIn으로 넘어가도록 필터를 걸 것임
		// 그럼 이 파일뿐만 아니라, ~~.do로 url이 된 모든 파일은 다 필터가 적용될 것이다.
		
		response.sendRedirect("/JSP_PROJECT_HYR/Main.do");
		
	}
}
