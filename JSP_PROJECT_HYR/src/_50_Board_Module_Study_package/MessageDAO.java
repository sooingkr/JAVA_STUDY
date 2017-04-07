// DB에 접근하는 DAO(Data Access Object)
package _50_Board_Module_Study_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import _50_Board_Module_Study_package.*;
// DAO 는 DB에 접속하는 객체로 전체에 하나 존재하는게 바람직함...
// 따라서, "싱글톤 패턴"으로 작성하자.
public class MessageDAO {

	private static MessageDAO mDAO;

	private MessageDAO() {
	};// 싱글톤위해 생성자 막음

	public static MessageDAO getInstance() { // 싱글톤 객체 얻기...
		if (mDAO == null) {
			mDAO = new MessageDAO();
		}
		return mDAO;
	}

	public Connection getConnectionDB() {

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

		return conn;
	}
	
	// 메시지를 DB에 저장하는 메소드
	public int insert( MessageDTO message ) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			conn = getConnectionDB();

			/** 트랜잭션 처리 시작 */
			conn.setAutoCommit(false);

			String me = message.getMessage();
			String sql = "insert into guestbook_table(quest_name,password,message) values(?, ?, ?)";
			// message_id 는 auto_increment 니까 입력 안해도 됨...
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			int updateNum = pstmt.executeUpdate();
			
			conn.commit(); /** 트랜잭션 종료 */
			
			return updateNum;
		} catch (SQLException e) {
			conn.rollback();
			return -1;}
		finally {
			try {
				if ( pstmt != null ) pstmt.close();
			} catch (Exception e) {}
			
		}
		
	} // end of insert
	
	// message id로 message를 리턴해주는 메서드
	public MessageDTO selectMessage(int messageId) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MessageDTO messageDTO = new MessageDTO();
		String sql = "select * from guestbook_table where message_id = ?";
		
		try {
			conn = getConnectionDB();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			
			// DTO에 세팅해 반환
			messageDTO.setId(rs.getInt("message_id"));
			messageDTO.setGuestName(rs.getString("guest_name"));
			messageDTO.setPassword(rs.getString("password"));
			messageDTO.setMessage(rs.getString("message"));
			conn.commit();
			return messageDTO;
			
		} catch (SQLException e) {
			conn.rollback();
			return null;}
		finally { // 자원 정리...
			try {
				if ( rs != null) rs.close();
				if ( pstmt != null ) pstmt.close();
			} catch (SQLException e) {}
		}
		
	} // end of getMessage
	
	
	// 메세지의 전체 개수를 반환한다.
	public int selectCount() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from guestbook_table";
		
		try {
			conn = getConnectionDB();
			conn.setAutoCommit(false); // 트랜잭션
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int count = 0;
			if(rs.next()){
				count = rs.getInt(1);
				
			}
				
			//return rs.getInt(1);
			
			conn.commit();
			return count;
		} catch (SQLException e) {
			conn.rollback(); // 트랜잭션 롤백
			return -1;
		}
		finally{
			try {
				if ( rs != null ) rs.close();
				if ( pstmt != null ) pstmt.close();
			} catch (SQLException e) {}
			
		}
		
	} // end of count
	
	
	// messageId에 해당하는 메시지를 DB에서 삭제하는 delete 메서드
	public void delete(int messageId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from guestbook_table where message_id = ?";
		try {
			conn = getConnectionDB();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
		}finally {
			try {
				if ( pstmt != null) pstmt.close();
			} catch (SQLException e1) {}
		}
	} // end of delete
	
	// 메시지 목록 출력(x번쨰 열부터 x번째 열까지)
	public ArrayList<MessageDTO> selectList(int firstRow, int endRow) { // firstRow ~ endRow 까지 메시지 목록을 반환
		ArrayList<MessageDTO> al = new ArrayList<MessageDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from guestbook_table order by message_id desc limit ?, ?";
		// limit 시작행번호, 읽어올 개수 
		// 인덱스는 0부터 시작 따라서 5번째 행부터 3개 행 읽어오고 싶으면 limit 4,3
		
		// 한 페이지당 10개씩 읽어오고 싶다면
		// select * from guestbook_table order by message_id desc limit 0,10;
		// select * from guestbook_table order by message_id desc limit 10,10;
		// select * from guestbook_table order by message_id desc limit 20,10; 21번째 행부터 10개
		try {
			conn = getConnectionDB();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow - 1); // 1번행이 0이니까 -1해줘야함.
			pstmt.setInt(2, endRow - firstRow + 1); // 개수 : endRow - firstRow + 1
			rs = pstmt.executeQuery();
			while(rs.next()){
				MessageDTO messagedto = new MessageDTO();
				messagedto.setId(rs.getInt("message_id"));
				messagedto.setGuestName(rs.getString("guest_name"));
				messagedto.setPassword(rs.getString("password"));
				messagedto.setMessage("message");
				al.add(messagedto);
			}
			return al;
		} catch (SQLException e) {
			return null;
		}finally {
			try {
				if ( rs != null ) rs.close();
				if ( pstmt != null ) pstmt.close();
			} catch (SQLException e) {}		
		}
	}
}
