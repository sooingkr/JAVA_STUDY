package MVC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String,CommandHandling> map = new HashMap<String,CommandHandling>();
	
	@Override
	public void init() throws ServletException {
		Properties prop = new Properties();
		FileInputStream f;
		try {
			f = new FileInputStream("C:\\DEV\\Workspace_HYR\\webpractice\\src\\MVC\\information.properties");
			prop.load(f);
			Set keys = prop.keySet();
			Iterator it = keys.iterator();
			CommandHandling commandObj = null;
			while(it.hasNext()){
				String s = (String) it.next();
				String className = prop.getProperty(s);
				Class<?> c = Class.forName(className);
				try {
					commandObj = (CommandHandling) c.newInstance();
					map.put(s, commandObj);
					
				} catch (InstantiationException | IllegalAccessException e) {}
			}
		} catch (FileNotFoundException e) {} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			
		}
		
	}

    public Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 분석을 위한 메서드 호출
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	private void process(HttpServletRequest request, HttpServletResponse response) {
		// 1. 2. 사용자의 요청을 분석
		String command = request.getRequestURI(); // 요청시 사용된 uri 주소 가져옴 : 이건 요청한 URL을 명령어로 이용하는 방법
		command = command.substring(request.getContextPath().length()+1);
		command = command.replace(".do", ""); 
		System.out.println(command);
		// 2. urI로부터 command를 따와서 해당 command에 맞는 객체를 수행 : 커맨드 패턴
		CommandHandling c = map.get(command);
		
		String viewPage = c.process(request,  response);
		// 2. command 별로 처리할 클래스를 만들되 해당 클래스에서는 작업처리 후, 띄워줄 페이지의 경로를 보내준다.
		// 모든 객체를 하나로 관리하기 위해서 인터페이스를 하나 정의한다.
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		try {
			
			dispatcher.forward(request, response);
			
		} catch (ServletException e) {	} catch (IOException e) {}
	}

}
