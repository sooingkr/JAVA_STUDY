package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		HttpSession session = request.getSession();
		if ( session.getAttribute("authUser") == null || session == null ) { // session이 없거나 인증을 위한 authUser이 없으면..
			response.sendRedirect(request.getContextPath() + "/login.do"); // 로그인 화면으로 전환...
		};
		
		arg2.doFilter(request, response); // 본래 요청 페이지로 이동.
	}

}
