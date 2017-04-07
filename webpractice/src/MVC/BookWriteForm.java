package MVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookWriteForm implements CommandHandling{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookWriteForm 페이지");
		String viewPage = "/environment.jsp";
		return viewPage;
	}

	

}
