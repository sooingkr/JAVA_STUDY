package logoutService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.CommandHandler;

public class LogoutHandler implements CommandHandler {
	// /logout.do 로 호출될 수 있도록 매핑을 등록한다.
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리를 담당한다.
		HttpSession session = (HttpSession) request.getSession(false);
		System.out.println("이전 : " + session);
		if (session != null) {
			session.invalidate();
		} // 세션에 로그인을 위한 auth 명으로 UserDTO로 저장하고 있음으로
			// 세션을 통으로 날려주던지 removeAttribute를 해준다.
		System.out.println("이후 : " + session);
		// 로그아웃 후 다시 게시판 시작 페이지로 돌아가도록 해준다.

		try {
			response.sendRedirect(request.getContextPath() + "/view/index.jsp");
		} catch (IOException e) {
		}

		// System.out.println("여기까지 수행되나요??? 로그아웃22");

		return null;

	}

}
