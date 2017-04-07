package _51_MVC_Pattern_Package;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest resquest, HttpServletResponse response) {
		System.out.println("Write 페이지");
		return "/_1_JSP.html";
	}
}
