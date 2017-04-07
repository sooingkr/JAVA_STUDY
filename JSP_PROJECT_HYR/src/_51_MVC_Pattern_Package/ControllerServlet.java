/**
 * 		- [ MVC 패턴의 작성법 ]
		 : 사용자의 모든 요청은 하나의 "서블릿 파일"이 받아 흐름제어를 하게 된다. 따라서, 서블릿 파일은 다음과 같은 작업을 해야 한다.
		 	- Servlet :
		 			1) 사용자의 요청을 받아 doGet() 혹은 doPost() 메서드를 호출한다.
		 			2) 어떤 요청인지 분석한다.
		 			3) 분석한 기능을 모델을 사용하여 수행한다.
		 			4) 모델을 이용해 처리한 결과물을 request.setAttribute나 session.setAttribute를 통해 저장하고
		 				결과물에 따라 이동할 페이지를 지정한다.
		 			5) 결과물을 전송할 JSP페이지로 RequestDispatcher를 이용해 포워딩한다.
 */
package _51_MVC_Pattern_Package;

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
import javax.servlet.http.HttpSession;



public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String,CommandHandler> map = new HashMap<String,CommandHandler>(); // 생성한 객체들을 미리 저장하고 있을 맵 객체
       
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException { // 초기화 메서드 수행할 때 파일에서 정보 읽어와 명령어에 해당하는 객체를 미리 생성해 둠.
    	
    	
  //  	String configFile = getInitParameter("configFile"); // properties 파일이 위치한 경로를 가지고 온다.
    	
    	String configFile = "C:\\DEV\\Workspace_HYR\\JSP_PROJECT_HYR\\src\\_51_MVC_Pattern_Package\\config.properties";
    	
    	//configFile = getServletContext().getRealPath(configFile);
    	Properties prop = new Properties();
    	FileInputStream f;
		try {
			f = new FileInputStream(configFile);
			try {
				prop.load(f);
				System.out.println(prop.get("BoardList"));
			} catch (IOException e) {}
		} catch (FileNotFoundException e) {}
    	
		Set keys = prop.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String command = (String)it.next(); // 명령어 가지고 옴
			String handlerClassName = prop.getProperty(command); // 명령어에 해당하는 패키지.클래스 명을 가지고 옴
			try {
				Class<?> c = Class.forName(handlerClassName); // 객체 생성
				try {
					CommandHandler handlerInstance = (CommandHandler)c.newInstance();
					map.put(command, handlerInstance); // 미리 생성한 객체를 맵에 저장해 놈
					// 아래에서 요청받은 명령어를 이 맵에서 검색해서 객체를 가지고 올 것임
				} catch (InstantiationException e) {} catch (IllegalAccessException e) {	} // 해당 객체 얻어오는 방법
			} catch (ClassNotFoundException e) {}
		}
    }
    
	// 1) 사용자읭 요청에 따라 doGet 혹은 doPost 메서드가 호출된다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2) 어떤 메서드를 통해 요청을 받던지 해당 요청을 분석하기 위한 processRequest 메서드를 수행토록 한다.
		processRequest(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2) 어떤 메서드를 통해 요청을 받던지 해당 요청을 분석하기 위한 processRequest 메서드를 수행토록 한다.
		processRequest(request, response);
	}

	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		// 3) 요청을 분석한다.
		/*
		 String command = request.getParameter("cmd");
		String viewPage = "";
		// 3) 요청을 처리한다.(여기선 로직이 단순 but 복잡시 DAO, DTO, 서비스 클래스 등 이용해서...)
		if ( command == null ){
			// 명령어 오류 처리
			viewPage = "/_51_MVC_Pattern/invalidCommand.jsp";
		}else if ( command.equals("BoardList") ){
			// 글목록 읽기 요청 처리
			viewPage = "/_51_MVC_Pattern/list.jsp";
		}else if ( command.equals("BoardWriteForm")){
			// 글쓰기 입력 폼 요청 처리
			viewPage = "/_51_MVC_Pattern/writeForm.jsp";
		}
		*/
		/*
		 * 		허나, 3번에서 이런식으로 if else 를 이용해 처리한다면 복잡한 로직일 경우 가독성이 매우 어려워질 것이다.
		 * 		따라서, 이런 경우에 [ "커맨드 패턴" ] 을 이용한다.
		 * 		
		 * 		[ 커맨드 패턴 ] 
		 * 		: 요청에 해당하는 "명령어"별로 별도의 서비스 클래스로 만들고 각 서블릿 클래스에서 해당 비지니스 로직을 처리한 뒤
		 * 		  결과물을 request.setAttribute 등으로 저장해주고 클래스 내부 메서드로 포워딩할 페이지의 경로를 리턴할 수 있도록 한다.
		 * 		이때,
		 * 		
		 */
		/*
		String command = request.getParameter("cmd");
		CommandHandler handler = null; // 모든 명령어를 아우를 수 있는(관리할 수 있는) 인터페이스를 정의한다.
		// 모든 서비스 클래스는 내부에서 처리한 뒤, 이동할 페이지 주소를 반환하는 메서드가 필요함으로 인터페이스에서 해당 메서드를 구현하도록 지정해 놓는다.
		
		if ( command == null ){
			handler = new NullHandler();
		}else if ( command.equals("BoardList") ){
			handler = new BoardListHandler();
		}else if ( command.equals("BoardWriteForm") ){
			handler = new BoardWriteFormHandler();
		}
		String viewPage = handler.process(request, response); // 각 객체의 process 메서드에서 요청에 대한 처리를 하고 결과를 저장하고 포워딩시킬 페이지의 경로를 리턴한다.
		// 여전히... 중첩된 if else 문을 사용해야함...
		// 이를 좀 더 좋은 코드로 바까보자.
		// 명령어에 해당하는 만들 객체를 properties 파일에 저장해서 이용할 수 있다.
		// properties에 저장된 정보를 기반으로 init() 메서드를 통해서 필요한 객체를 미리 생성해 놓고, HashMap 등에 저장해 놓은 다음에
		// 명령어로 해당 HashMap을 검색해 해당 요청에 대한 객체를 가지고 오는 방식으로 처리한다.
		*/
		
		String command = request.getParameter("cmd"); // 이건 ?cmd=BoardList 등으로 요청해서 수행할 때 처리하는 방법
		command = request.getRequestURI(); // 요청시 사용된 uri 주소 가져옴 : 이건 요청한 URL을 명령어로 이용하는 방법
		command = command.substring(request.getContextPath().length()+1);
		command = command.replace(".do", "");
		
		System.out.println("비었니?" + map.isEmpty());
		
		CommandHandler handler = null;
		
		if ( command == null ){
			handler = new NullHandler();
		}
		
		handler = map.get(command); // init시에 생성해 map에 저장해 둔 객체를 가지고 옴
		String viewPage = handler.process(request, response);
		
		
		// 4) 처리한 결과를 request.setAttribute에 저장...(여기선 결과물이 없음으로 생략)
		HttpSession session = request.getSession();
		session.setAttribute("name", "result");
		request.setAttribute("name2", "result2");
		
		
		// 5) 해당 페이지로 포워딩한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		try {
			
			dispatcher.forward(request, response);
			
		} catch (ServletException e) {} catch (IOException e) {}
		
		
	}

}
