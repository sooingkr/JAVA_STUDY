/**
 * 		[	 커넥션 풀	]
 * 		: DB와 연결된 Connection을 미리 만들어서 풀(pool) 속에
 * 		  저장해 두고 있다가 필요할 때에 커넥션 풀에서 가져다 쓰고 다시 풀에 반환하는 기법
 * 
 * 		장점)
 * 			- 페이지 요청시마다 매번 Connection 객체를 생성하는 비효율성을 없애고
 * 			   미리 생성해 놓은 Connection 객체를 풀에서 꺼내와서 사용함으로써 효율을 높인다.
 * 			- 미리 만들어 놓은 객체를 재사용하기 때문에 무제한적으로 커넥션 객체가 생성되는 것을 방지할 수 있다.
 * 		방법)
 * 			servers폴더에 보면 context.xml이 있다.

 * 				=> server.xml or context.xml 둘 중 한군대다 DBCP 설정을 작성해 주면 된다.								
 *
 *			서버에 생성해 놓고 생성한 Connection 객레를 얻어오는 것으로
 *			서버(톰캣)에서 작업해야 함.
 */
package bookPrac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import bookPrac.*;

public class BookDAO {

	ArrayList<BookDO> al = new ArrayList<BookDO>();
	
	/** Connection 객체 얻어오기... 
	 * @throws IOException */
	public Connection dbConnection() throws IOException {
	/*	String jdbcURL = "jdbc:mysql://localhost:3306/jsptest";
		String id = "root";
		String pwd = "dudfhd13";*/
		Connection conn = null;
		
		try {

			FileInputStream fis = new FileInputStream("C:\\DEV\\Workspace_HYR\\JSP_PROJECT_HYR\\src\\bookPrac\\information.properties");
			InputStreamReader ir = new InputStreamReader(fis, "UTF-8");
			Properties properties = new Properties();
			
			properties.load(ir);
			String jdbcURL = properties.getProperty("jdbcURL");
			String id = properties.getProperty("id");
			String pwd = properties.getProperty("pwd");
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(jdbcURL, id, pwd);
			} catch (SQLException e) {}
		} catch (ClassNotFoundException e) {}

		return conn;
	}
	
	/** 기존 데이터베이스에 저장되어 있는 책 목록 가지고 오기 
	 * @throws IOException */
	public ArrayList<BookDO> getBookList() throws IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from book_table";
		ResultSet rs = null;
		try {
			conn = dbConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BookDO tempBook = new BookDO();
				tempBook.setId(rs.getInt("id"));
				tempBook.setTitle(rs.getString("title"));
				tempBook.setAuthor(rs.getString("author"));
				tempBook.setPrice(rs.getInt("price"));
				tempBook.setQty(rs.getInt("qty"));
				al.add(tempBook);
			}
		} catch (SQLException e) {
			
		}finally { // 자원 정리
			try {
				if ( rs != null )rs.close();
				if ( pstmt != null) pstmt.close();
				if ( conn != null ) conn.close();
			} catch (SQLException e) {}
		}
		
		return al;
		
	} // end of getBookList()
	
	/** 책 저장 메서드 */
	public void insertBook(BookDO bookDO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into book_table (id, title, author, price, qty) values(?, ?, ?, ?, ?)";
		try {
			conn = dbConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookDO.getId());
			pstmt.setString(2, bookDO.getTitle());
			pstmt.setString(3, bookDO.getAuthor());
			pstmt.setInt(4, bookDO.getPrice());
			pstmt.setInt(5, bookDO.getQty());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
		
		}finally {
			try {
				if ( pstmt != null ) pstmt.close();
				if ( conn != null ) conn.close();
			} catch (SQLException e) {}
		}
	}
	
}
