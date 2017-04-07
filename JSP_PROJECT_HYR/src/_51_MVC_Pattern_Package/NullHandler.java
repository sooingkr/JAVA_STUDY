package _51_MVC_Pattern_Package;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler{ // 관리를 위한 CommandHandler 구현

	@Override
	public String process(HttpServletRequest resquest, HttpServletResponse response) {

		/*try {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} catch (IOException e) {}
		*/
		System.out.println("null페이지");
		return "/_1_JSP.html";
	}
}
