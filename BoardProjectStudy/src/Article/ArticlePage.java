package Article;

import java.util.ArrayList;

public class ArticlePage {
	private int total; // 전체 게시글 수
	private int currentPage; // 현재 페이지 번호
	private int totalPage; // 전체 페이지 수
	private int startPageIndex; // 게시판 아래에 표시할 시작 startPageIndex
	private int endPageIndex; 
	private ArrayList<ArticleDTO> content; // 표시해줄 게시글
	
	
	public ArticlePage(int total, int currentPage, int size, ArrayList<ArticleDTO> content) {
		super();
		this.total = total;
		this.content = content;
		this.currentPage = currentPage;
		
		if ( total == 0 ) {
			// 게시글 수가 하나도 없을 경우
			totalPage = 0;
			startPageIndex = 0;
			endPageIndex = 0;
		}else { // 게시글이 있을 경우
			
			this.totalPage = total / size; // 전체 게시글 수 / (한페이지에 출력할 게시글 수)
			if ( ( totalPage % size ) > 0 ) {
				totalPage += 1; // ex) 11페이지까지 있는데 5개씩 출력시 mod는 1 이 한개도 페이지수를 차지해야함. 
			}
			
			// 하단에 출력해줄 페이지 번호를 계산해야함
			startPageIndex = this.currentPage / size * size + 1;
			endPageIndex = startPageIndex + 4;
			
			if ( this.currentPage % size == 0 ) {
				startPageIndex -= 5;
			}
			
			if ( endPageIndex > totalPage ) {
				endPageIndex = totalPage;
			}
		}
		
		this.startPageIndex = startPageIndex;
		this.endPageIndex = endPageIndex;
		
	}
	
	public ArticlePage() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean hasNoArticles() {
		return total == 0;
	}
	public int getTotal() {
		return total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getStartPageIndex() {
		return startPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public ArrayList<ArticleDTO> getContent() {
		return content;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setStartPageIndex(int startPageIndex) {
		this.startPageIndex = startPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	public void setContent(ArrayList<ArticleDTO> content) {
		this.content = content;
	}
	
	
	
}
