package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class enCodingFilter implements Filter{
	
	String encodingType = "";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// web.xml의 필터에 지정해 놓은 초기변수 값을 가지고 온다.
		encodingType = filterConfig.getInitParameter("encodingType");
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		// 필터 초기화 변수에 저장한 UTF-8 값을 init 최초요청시 호출되는 메서드를 이용해 가지고 오고 필터에서 setCh~ 를 지정해준다.
		// 모든 페이지가 이 필터를 지나가도록 /* 로 설정했음으로 모든 페이지에 인코딩 타입이 지정됨으로 매 페이지마다 설정해줄 필요가 없어진다.
		request.setCharacterEncoding(encodingType);
		
		// 요청 페이지 실행
		arg2.doFilter(request, response);
	}


}
