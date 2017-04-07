package ControllerFolderPractice;

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

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	HashMap<String, ControllHandler> map = new HashMap();
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		Properties prop = new Properties();
		String path = "C:\\DEV\\Workspace_HYR\\JSP_PROJECT_HYR\\src\\ControllerFolderPractice\\information.properties";
		try {
			FileInputStream f = new FileInputStream(path);
			try {
				prop.load(f);
			} catch (IOException e) {}
			Set keys = prop.keySet();
			Iterator it = keys.iterator();
			while(it.hasNext()){
				String command = (String)it.next();
				String commandClassStr = prop.getProperty(command);
				try {
					Class<?> c = Class.forName(commandClassStr);
					try {
						ControllHandler con = (ControllHandler)c.newInstance();
						map.put(commandClassStr, con);
					} catch (InstantiationException e) {} catch (IllegalAccessException e) {}
					
				} catch (ClassNotFoundException e) {}
			}
		} catch (FileNotFoundException e) {}
	}

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 1. 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response); // 2. 요청에 대한 분석, 처리를 위한 메서드 실행
	}

	// 1. 요청
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response); // 2. 요청에 대한 분석, 처리를 위한 메서드 실행
	}

	private void process(HttpServletRequest request, HttpServletResponse response) {
		// 2. 요청에 대한 분석
		String command = request.getParameter("cmd");
		// URI에 처리할 요청명을 넣어서 호출하도록...
		//String uri = request.getRequestURI();
		// 3. 요청에 대한 처리
		// [ 커맨드 패턴 이용 ] : 명령에 따른 처리를 if else 안에서 다하면 가독성이 안좋아짐
		// 따라서, 명령어에 따라 처리할 것을 별도의 클래스로 정의해서 사용
		ControllHandler controller = null;
		if ( command == null ){
			controller = new NullPointHandler();
		}
		controller = map.get(command);
		
		
		// 각 처리 객체의 메서드에서 비지니스 로직을 수행하고 보여줄 페이지의 경로를 리턴해주도록 한다.
		String viewPage = controller.process(request, response);

		// 4. 각 클래스 내부 process 메서드 안에서 request.setAttribute 등으로 결과값 저장
		// 5. 출력 페이지로 포워딩 해주기
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
		} catch (IOException e) {
		}

	}

}
