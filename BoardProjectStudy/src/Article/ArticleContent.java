package Article;

public class ArticleContent {
	private int article_no; // 게시글 번호
	private String content; // 게시글 내용
	
	public ArticleContent(int article_no, String content) {
		super();
		this.article_no = article_no;
		this.content = content;
	}
	
	public int getArticle_no() {
		return article_no;
	}
	public String getContent() {
		return content;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
}
