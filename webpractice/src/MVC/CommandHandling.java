package MVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandling {
	
	public String process(HttpServletRequest request, HttpServletResponse response);

}
