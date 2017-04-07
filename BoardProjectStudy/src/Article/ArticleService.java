package Article;

import java.util.Date;

public class ArticleService {
	ArticleDAO articleDAO = new ArticleDAO();
	ArticleContentDAO articleContentDAO = new ArticleContentDAO();
	
	public int writeService(Writer writer, String title, String content) {
		Date regmodDate = new Date();
		ArticleDTO articleDTO = new ArticleDTO(0, title, regmodDate, regmodDate, 0, writer);
		
		ArticleDTO savedArticle = articleDAO.insert(articleDTO); // DB에 삽입 후 삽입한 정보를 담은 ArticleDTO를 반환함
		
		if ( savedArticle == null ) {
			throw new RuntimeException("fail to insert article");
		}
		
		ArticleContent articleContent = new ArticleContent(savedArticle.getArticle_no(), content);
		// DB에 저장한 객체를 반환함으로 그 객체에서 게시글 번호를 가지고 올 수 있다.
		// why?? ArticleDAO 의 insert 메서드에서 추가 후 마지막에 추가한 id를 가지고 와서 저장 후 리턴하는 로직을 작성했으니까...
		
		ArticleContent savedArticleContent = articleContentDAO.insert(articleContent);
		
		if ( savedArticleContent == null ) {
			throw new RuntimeException("fail to insert articleContent");
		}
		
		
		return savedArticle.getArticle_no();
	}
}
