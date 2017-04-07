package Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Board.MemberDAO;

public class ArticleContentDAO {
	MemberDAO dao = MemberDAO.getInstance();

	
	// ArticleContent 테이블에 추가가 성공하면 ArticleContent DTO 객체를 반환( 이후 핸들러에서 제대로 추가가 됐는지 안됐는지 확인하는 용도로 사용됨)
	public ArticleContent insert ( ArticleContent article ) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		String sql = "insert into article_content(article_no, content) values(?, ?)";
		
		conn = dao.dbConnect();
		int insertedCount = 0;
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article.getArticle_no());
			pstmt.setString(2, article.getContent());
			insertedCount = pstmt.executeUpdate();
			
			conn.commit();
		
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		} finally {
			if ( pstmt != null )
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}
		
		if ( insertedCount > 0 ) { // 추가가 성공한 경우
			return article; // 추가한 ArticleContent 객체를 리턴
		}else {
			return null;
		}
		
	}
}
