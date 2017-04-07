/**
 * 		[	Article 테이블을 위한 DTO	]
 * 
 * 		: 글을 조회할 때는 게시글의 내용은 필요하지 않고 그 외에는 필요한 경우도 있다. 따라서 테이블을 내용이 있는 것과 없는 것으로 두개를 만들고
 * 		   게시글 번호를 기준으로 서로 관계를 맺어준다.
 * 
 * 	create table article(
	article_no int not null auto_increment primary key,         // auto_increment : 추가하지 않으면 자동으로 1씩 증가하면서 추가됨.
    writer_id varchar(50) not null,
    writer_name varchar(50) not null,
    title varchar(255) not null,
    regdate datetime not null,
    moddate datetime not null,
    read_cnt int
);

create table article_content (
	article_no int not null primary key,
	content text																	// 긴 문자열을 넣을 때는 text를 사용.
);


 * 
 */
package Article;

import java.util.Date;

public class ArticleDTO {
	private int article_no; // 개시글 번호
	private String title; // 제목
	private Date regDate; // 게시글 등록 시간
	private Date modDate; // 게시글 수정일
	private int readCnt; // 조회수
	private Writer writer; // 게시글 작성자 객체를 저장하는 용도
	
	
	public ArticleDTO(int article_no, String title, Date regDate, Date modDate, int readCnt, Writer writer) {
		super();
		this.article_no = article_no;
		this.title = title;
		this.regDate = regDate;
		this.modDate = modDate;
		this.readCnt = readCnt;
		this.writer = writer;
	}
	
	public int getArticle_no() {
		return article_no;
	}
	public String getTitle() {
		return title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public Writer getWriter() {
		return writer;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	
}
