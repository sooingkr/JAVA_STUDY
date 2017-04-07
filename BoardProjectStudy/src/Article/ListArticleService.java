package Article;

import java.util.ArrayList;

public class ListArticleService {

	ArticleDAO dao = new ArticleDAO();
	final int size = 5;
	
	public ArticlePage getArticlePage( int pageNum ) {
		int total = dao.selectCount();
		ArrayList<ArticleDTO> content = dao.select((pageNum-1)*size, size); // startRow, size
		
		return new ArticlePage(total, pageNum, size, content);
	}
}
