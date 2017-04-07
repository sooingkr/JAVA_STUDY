package Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.CommandHandler;

public class ListArticleHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNoVal = request.getParameter("pageNo");
		// 현재 페이지 번호를 가지고 옴
		
		int pageNo  = 1;
		if ( pageNoVal != null ) {
			pageNo = Integer.parseInt(pageNoVal);
			System.out.println("실행됨?" + pageNo);
		}
		
		
		ListArticleService listService = new ListArticleService();
		ArticlePage articlePage = listService.getArticlePage(pageNo);
		
		request.setAttribute("articlePage", articlePage);
		
		return "/view/listArticle.jsp";
	}

}
