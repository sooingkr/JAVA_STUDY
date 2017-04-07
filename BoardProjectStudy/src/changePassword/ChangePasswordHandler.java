package changePassword;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.CommandHandler;
import loginService.LoginUser;

public class ChangePasswordHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		if ( request.getMethod().equalsIgnoreCase("GET") ){
			return "/view/changePwdForm.jsp";
		}else if (request.getMethod().equalsIgnoreCase("POST")){
			return processChangePwd(request,response);
		}else {
			return null;			
		}
	}

	private String processChangePwd(HttpServletRequest request, HttpServletResponse response) {

		// 로그인이 되어있는지는 필터를 통해서 이미 제어가 되어 있는 상태
		// 빈문자열이 입력되어 전송되었는지 확인해야함
		String curPwd = request.getParameter("curPwd");
		String newPwd = request.getParameter("newPwd");
		
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("authUser"); // 인증되어 있는 세션으로부터 현재 로그인되어 있는 아이디를 가지고 온다.
		
		HashMap<String, Boolean> errors = new HashMap<String,Boolean>();
		if ( curPwd == null || curPwd.isEmpty() ){
			errors.put("curPwd", true);
		}
		if ( newPwd == null || newPwd.isEmpty() ){
			errors.put("newPwd", true);
		}
		
		if ( !errors.isEmpty() ){
			return "/view/changePwdForm.jsp";
		}
		
		request.setAttribute("errors", errors);
		
		ChangePasswordService changePwdSvc = new ChangePasswordService(); // DAO로 비번 변경작업 수행할 객체
		
		try {
			changePwdSvc.changePassword(user, curPwd, newPwd);
			return "/view/changePwdSuccess.jsp";
		} catch (InvalidPasswordException e) {
			errors.put("badCurPwd", true);
			return "/view/changePwdForm.jsp";
		}
		
	}

}
