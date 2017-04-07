package Board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * [ Controller ] : 모든 요청이 오도록 web.xml에 등록시 *.do 로 등록한다.
 *
 */
public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String objString = null;
	HashMap<String, CommandHandler> map = new HashMap<String, CommandHandler>();

	public ControllerUsingURI() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 톰캣 구동시 init을 바로 호출해서 서비스할 객체들을 초기에 미리 생성해 놓기 위해서
		// web.xml에 이 Controller를 등록시 태그 속성으로 load-on-startup 을 줄 것이다.

		String configFile = "C:\\DEV\\Workspace_HYR\\BoardProjectStudy\\src\\Board\\controllerFile.properties";

		// configFile = getServletContext().getRealPath(configFile);
		Properties prop = new Properties();
		FileInputStream f;
		try {
			f = new FileInputStream(configFile);
			try {
				prop.load(f);
			} catch (IOException e) {
			}
		} catch (FileNotFoundException e) {
		}

		Set keys = prop.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String command = (String) it.next(); // 명령어 가지고 옴
			String handlerClassName = prop.getProperty(command); // 명령어에 해당하는
																	// 패키지.클래스
																	// 명을 가지고 옴
			try {
				Class<?> c = Class.forName(handlerClassName); // 객체 생성
				try {
					CommandHandler handlerInstance = (CommandHandler) c.newInstance();
					map.put(command, handlerInstance); // 미리 생성한 객체를 맵에 저장해 놈
					// 아래에서 요청받은 명령어를 이 맵에서 검색해서 객체를 가지고 올 것임
				} catch (InstantiationException e) {
				} catch (IllegalAccessException e) {
				} // 해당 객체 얻어오는 방법
			} catch (ClassNotFoundException e) {
			}
		}

	}

	// 1. 요청 분석
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response); // 요청 종류에 상관없이 요청을 분석하는 process 메서드 실행
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) {

		String command = request.getRequestURI(); // URI의 뒷부분 ~~/booklist.do 에서
													// .do 앞부분을 처리해야할 대상으로 판단할
													// 것임

		command = command.substring(request.getContextPath().length());
		System.out.println("command : " + command);
		// 커맨드 패턴
		CommandHandler ch = (CommandHandler) map.get(command); // 요청한 uri 를 통해
																// 실행할 것을 판별한 뒤
																// 해당 객체를 가지고 옴

		////////////////////

		if (ch == null) {
			ch = (CommandHandler) new NullPointHandler();
		}

		String viewPage = null;
		viewPage = ch.process(request, response); //
		// 해당 객체의 서비스를 수행하는 process // 메서드를 수행하고 수행 후 보여줄 페이지를 // 반환해줌.

		// 위에서 서비스 객체가 처리하고 보여줄 결과값들을 저장함
		//HttpSession session = request.getSession();
		//session.setAttribute("result", "value");
		// 나중에필요시 이 부분 수정

		// 보여줄 뷰 페이지로 포워딩
		if (viewPage != null) {
			System.out.println("테스트 : " + viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
			} catch (IOException e) {
			}
		}

	} // end of process
}
