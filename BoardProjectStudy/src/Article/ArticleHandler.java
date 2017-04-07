package Article;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.CommandHandler;
import loginService.LoginUser;

public class ArticleHandler implements CommandHandler{

	// 로그인 되어 있을 때만 해당 게시글 작성 기능을 수행할 수 있어야 함으로 기존에 만들어 논 LogInCheck Filter를 적용하자.
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("테스트");
		if ( request.getMethod().equalsIgnoreCase("GET")) {
			return "/boardView/newArticleForm.jsp"; // 게시글 작성폼으로 이동.
		} else if ( request.getMethod().equalsIgnoreCase("POST")) {
			return processWriteArticle(request, response); // 글쓰기 작업을 수행할 메서드를 호출
		} else {
			return null;
		}
		
	}

	private String processWriteArticle(HttpServletRequest request, HttpServletResponse response) {
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		// 폼에서 입력된 제목과 게시글 내용을 가지고 옴
		
		// 현재 로그인된 사용자의 정보를 가지고 옴
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("authUser"); // 로그인된 상태에만 이 곳에서 작업할 수 있음으로 로그인시 생성한 세션 객체를 가지고와
		// 게시글을 작성하는 사람의 정보를 가져올 것이다.
		String writer_id = user.getId();
		String writer_name = user.getName();
		Writer writer = new Writer(writer_id, writer_name);
		
		// validation Check
		HashMap<String,Boolean> errors = new HashMap<String,Boolean>();
		request.setAttribute("errors", errors);
		
		if ( title == null || title.isEmpty() ) {
			errors.put("title", true);
		}
		if ( content == null || content.isEmpty() ) {
			errors.put("content", true);
		}
		// 빈 문자열인지 validation Check
		// 로그인되어 있지않으면 여기 들어올 일이 없음으로... id와 name에 대해선 처치가 불필요
		if ( !errors.isEmpty() ) {
			System.out.println("여기지남?");
			return "/boardView/newArticleForm.jsp";
		}
		
		ArticleService articleService = new ArticleService();
		int newInsertedArticleNo = articleService.writeService(writer, title, content);
		
		request.setAttribute("newInsertedArticleNo", newInsertedArticleNo); // 게시글 추가 페이지에서 추가된 게시글 번호를 사용하기 위해서...
		
		return "/boardView/newArticleSuccess.jsp"; // 게시글 추가 성공 페이지로 이동...
	}

}
