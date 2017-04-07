package MVC;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookListProcess  implements CommandHandling {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("bookListProcess 페이지");
		String viewPage = "/webPractice/environment.jsp";
		return viewPage;
	}

	
	


}
