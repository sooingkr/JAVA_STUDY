package _51_MVC_Pattern_Package;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListHandler implements CommandHandler{ // 관리를 위한 CommandHandler 구현
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. 요청에 관한 작업 처리...
		
		// 2. 결과값 저장
		request.setAttribute("hello", "결과값 저장");
		System.out.println("BoardList핸들러페이지");
		return "/_1_JSP.html"; // 3. 포워딩할 페이지 경로 리턴
	}

}
