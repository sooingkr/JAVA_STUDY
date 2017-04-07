package _Servlet_Study_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class _1_Servlet_Study_Ex
 */
 // 어노테이션을 통해 url 지정 및 서블릿 파일 등록 방법 @WebServlet("/HYRServlet")
public class _1_Servlet_Study_Ex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public _1_Servlet_Study_Ex() {
        super();
        // TODO Auto-generated constructor stub
    }

    // GET요청시 수행할 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 매개변수는 JSP의 request, response 객체에 해당함
		response.setContentType("text/html;charset=UTF-8");
		// page 디렉티브의 contentType 속성에 해당함
		PrintWriter out = response.getWriter(); // out 객체 얻어오는 방법
		out.println("안녕하세요 서블릿 연습중입니다.<br/>");

		String initName = getInitParameter("testName");
		out.println("초기값은 : " + initName + "<br/>");
		// JSP에선 application.getInitParameter("InitName");
		
		// properties 파일로부터 가지고 와보기
		Properties properties = new Properties();
		//String filePath = request.getRealPath("./initFile.properties");
		String filePath = "C:\\DEV\\JAVAworkspace\\JSP_HYR_PROJECT\\src\\_Servlet_Study_package\\initFile.properties";
		FileInputStream f = new FileInputStream(filePath);
		properties.load(f);
		String id = properties.getProperty("ID");
		String pwd = properties.getProperty("PWD");
		out.println("properties 파일을 통해 가지고 온 <br/>");
		out.println("Id : " + id + " pwd : " + pwd);
	}

	// POST 요청시 수행할 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// 이 구문을 실행하기 때문에 모든 요청에 대해서 다 GET 메서드를 수행하게 됨 지금은..
	}
	
	@Override
	public void init() throws ServletException { // 최초 서블릿 요청시 초기화 작업 메서드
		// 여기서 커넥션 풀 작업등이 이루어짐
		// web.xml의 servlet 태그 안에 load-on-startup 태그를 써서 웹컨테이너 시작시
		// 수행될 수 있도록 할 수 있다.
		super.init();
	}

}
