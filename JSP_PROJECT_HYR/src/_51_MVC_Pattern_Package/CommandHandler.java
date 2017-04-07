package _51_MVC_Pattern_Package;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
	public String process(HttpServletRequest resquest, HttpServletResponse response); // 각 요청에 해당하는 클래스에서 구현하도록 한다.
}
