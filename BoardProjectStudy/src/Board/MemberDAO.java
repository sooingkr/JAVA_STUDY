package Board;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	// 싱글톤 패턴 적용
	private static MemberDAO m = null;
	
	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if ( m == null ){
			m = new MemberDAO();
		}
		return m;
	}
	
	// 1. DB Connection 객체 얻기(연결하기)
	public Connection dbConnect() {
		// 커넥션 풀을 이용한 Connection 객체 얻어오기...
		Connection conn = null;

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource) envContext.lookup("jdbc/onlinesrv");
			conn = datasource.getConnection();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return conn; // Connection 객체 반환
	} // end of dbConnect()
	
	
	// 2. 검색한 id에 해당하는 맴버 객체 반환하기
	public MemberDTO findById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where memberid = ?";
		MemberDTO m = null;
		try {
			conn = dbConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			m = new MemberDTO();
			
			while( rs.next() ){
				m.setId(rs.getString("memberid"));
				m.setName(rs.getString("name"));
				m.setPassword(rs.getString("password"));
				
				// DB의 datetime의 Type은 TimeStamp 이고, 자바는 Date이기 때문에
				// DB로부터 가지고온 TImeStamp 타입으로부터 Date로 형변환이 필요하다.
				Date now = new Date( rs.getTime("regdate").getTime() );
				m.setRegDate( now );
			} // end of while
			
		} catch (SQLException e) {
		} finally {
			try {
				if ( rs != null ) rs.close();
				if ( pstmt != null ) rs.close();
				if ( conn != null ) conn.close();
			} catch (SQLException e) {
				System.out.println("자원 해제 오류");
			}
		}
		
		return m;
	} // end of findById
	

	// 3. 회원 추가 메서드
	public void insert( MemberDTO m ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member(memberid, name, password, regdate) values(?,?,?,?)";
		
		
		try {
			conn = dbConnect();
			// DB에 저장하는 작업은 중간에 저장되다 오류뜨면 안되니까 트랜잭션 처리가 필요.
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getPassword());
			// Java는 Date 이고 DB는 TimeStamp 타입이니까 DB에 저장할 떄에는 Date-> TimeStamp 로 변경이 필요.
			Timestamp now = new Timestamp( m.getRegDate().getTime() );
			pstmt.setTimestamp(4, now);
			pstmt.executeUpdate(); // db에 반영.
			
			conn.commit(); // commit
		} catch (SQLException e) {
			try {
				conn.rollback(); // Exception 발생시 롤백!
			} catch (SQLException e1) {
			} 
		} finally { // 자원 정리...
			if ( pstmt != null )
				try {
					pstmt.close();
				} catch (SQLException e) {}
		}
	} // end of insert
	
	public void update(MemberDTO m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set name = ?, password=? where memberid = ?";
		conn = dbConnect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			if ( pstmt != null )
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}
		
	}
}
