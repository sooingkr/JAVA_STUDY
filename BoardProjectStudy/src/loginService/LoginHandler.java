/**
 * 		로그인 처리를 담당하는 핸들러이다. 
 * 	
 * 		/login.do=패키지.클래스 로 등록해 매핑한다.
 */
package loginService;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.CommandHandler;

public class LoginHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		if ( request.getMethod().equalsIgnoreCase("GET") ){
			return "/view/loginForm.jsp"; // GET 방식으로 요청이 오면 로그인 폼을 띄워준다.
		}else if ( request.getMethod().equalsIgnoreCase("POST") ){
			return processLogin(request, response);
		} else {
			return null;			
		}
	}

	private String processLogin(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 폼에서 전송버튼을 눌렀을 때
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		
		HashMap<String, Boolean> errors = new HashMap<String, Boolean>();
		
		request.setAttribute("errors", errors); // 다른 화면에서도 사용하기 위해 저장해 놈.
		
		if ( id == null || id.isEmpty() ){
			errors.put("id", true);
		}
		if ( pwd == null || pwd.isEmpty() ){
			errors.put("pwd", true);
		} // 빈 문자열이 입력되었는지 확인한다.
		
		if ( !errors.isEmpty() ){ // 여기 먼가 있다는건 에러가 발생했다는 것!
			return "/view/loginForm.jsp";
		}
		
		
		LoginService ls = new LoginService();
		// 빈게 아니면 db에 저장되어있는지 확인하는 로그인 메서드를 호출한다.
		try {
			LoginUser u = ls.login(id, pwd);
			
			HttpSession session = request.getSession();
			session.setAttribute("authUser", u);
			System.out.println("여기지나나?");
			try {
				response.sendRedirect(request.getContextPath() + "/view/index.jsp");
				// 로그인 성공시 보여줄 게시판 첫 화면으로 이동
			} catch (IOException e) {
			}
			return null;
		} catch (LoginFailException e) {
			errors.put("noMatch",true);
			return "/view/loginForm.jsp";
		}
		
		
		
		
	}

}
