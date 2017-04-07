package Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 전체 서비스 객체들을 관리할 핸들러
public interface CommandHandler {
	public String process(HttpServletRequest request, HttpServletResponse response);
	// 모든 서비스 클래스들은 해당 메서드를 구현해 수행하고, 띄워줄 뷰페이지 경로를 리턴한다.
}
