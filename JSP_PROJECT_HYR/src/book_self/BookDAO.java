// DAO(Data Access Object) : 데이터 접근(처리)를 위한 객체 : DB 접근...
package book_self;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BookDAO {

//	// 1. 단순히 DB 연결 메서드
//	public Connection dbConnect() {
//		Connection conn = null;
//		// 1) jdbc 드라이버 로딩하기
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			// 2) db 연결 객체 얻기
//
//			// DB URL : jdbc:db종류://호스트:포트/db명
//			String jdbcURL = "jdbc:mysql://localhost:3306/jsptest";
//			String userId = "root";
//			String passWd = "dudfhd13";
//			// 이런 중요한 정보는 코드상에 하지 않도록해야하지만 일단은 이렇게... 나중에 처리하자.
//			// 클래스파일 역컴파일하면 그냥 보임.... 보안상 너무 안좋음...
//			
//			conn = null;
//			conn = DriverManager.getConnection(jdbcURL, userId, passWd);
//			System.out.println("DB 접속 성공...");
//
//		} catch (Exception e) {
//			System.out.println("DB 접속 실패...");
//		}
//		return conn; // DB연결 객체 반환
//
//	}

//	// 2. 프로퍼티 파일 활용해 연결하는 법
//	public Connection dbConnect(){
//		Connection conn = null; // db 접속 객체
//		try{
//			
//			// 프로퍼티 파일 로딩(보안상 목적으로... 소스코드에 아이디 비번 직접 기재 방지)
//			FileInputStream fis = new FileInputStream(
//					"C:\\DEV\\Workspace_HYR\\JSP_PROJECT_HYR\\src\\book_self\\db.properties"
//					);
//			
//			Properties prop = new Properties();
//			// key=value 구조(map)
//			prop.load(fis);
//			// 프로퍼티 파일에 저장된 값들을 불러옴.
//			String driver = prop.getProperty("driver");
//			String url = prop.getProperty("url");
//			String id = prop.getProperty("id");
//			String pwd = prop.getProperty("pwd");
//			
//			// mysql jdbc driver 로딩
//			Class.forName(driver);
//			conn = null;
//			conn = DriverManager.getConnection(url, id, pwd);
//			System.out.println("DB 접속 성공...");
//		}catch(Exception e){
//			System.out.println("DB 접속 실패...");
//		}
//		return conn;
//	}
//	
	// 3. 커넥션 풀 이용한 DB연결
	public Connection dbConnect() {
		/*DataSource ds = null; // context.xml에 작성했던 type에 해당하는 클래스
		Connection conn = null;
		// 웹프로젝트 처음 로딩시 server.xml이나 context.xml 에 기재된 대로
		// 커넥션 객체를 해당 개수만큼 생성해 놓고, 이 아래 문장을 수행하면서
		// server.xml에 작성한 것과 같은 것이면 가져오도록 함
		try {
			// context.xml을 분석하는 객체
			Context ctx = new InitialContext(); // javax.naming
			// context.xml의 Resource 태그 검색
			// 끝에 myDB부분은 context.xml의 name 부분과 일치해야함.
			ds = (DataSource)ctx.lookup("java:com/env/myDB");
			conn = ds.getConnection(); // 커넥션을 할당받음
		} catch (Exception e) {
		}
		
		return conn; // 커넥션 리턴
*/		
		 Connection conn = null;

	        try {
	                Context initContext = new InitialContext();
	                Context envContext  = (Context) initContext.lookup("java:/comp/env");
	                DataSource datasource = (DataSource) envContext.lookup("jdbc/onlinesrv");
	                conn = datasource.getConnection();
	        } catch (Exception e){
	                e.printStackTrace(System.out);
	        }
	        
	        return conn;
		}
	
	// 2. DB에 저장된 데이터 불러오는 메서드
	public ArrayList<BookDTO> bookList() {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from book_table";
		try {
			conn = dbConnect(); // DB연결 객체 얻어오기.
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(?에 대입할 문자);
			rs = pstmt.executeQuery(); // 수행
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPrice(rs.getInt("price"));
				dto.setQty(rs.getInt("qty"));
				list.add(dto); // DB에서 가져온 데이터 list에 계속 저장
			}

		} catch (Exception e) {
		} finally { // 자원 정리 : 역순으로 정리...
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

		return list; // 저장된 list를 반환.
	}

	// 3. DB에 데이터 삽입하기...
	public void insertBook(BookDTO dto) {
		// 아래는 하나의 테이블에만 작업하니까 상관없지만... 예를들어 n개의 테이블에 종속적인 작업을 한다고 가정할 때
		// 하나의 테이블에 대한 작업을 처리한 뒤 Exception이 발생하면 아래 데이터는 종속관계에 의해 엉뚱한 결과가 저장될 수 있다.
		// 따라서, 이렇게 종속적인 관계일 때는 해당 처리를 "트랜잭션" 처리를 해 주어야 한다.
		
		/*
		 * 	[	트랜잭션이란??	] : 하나의 작업 단위로 전부 수행되던지 전부 수행되지 않던지 하게 한다.
		 * 		: 수행이 완전하게 완료되면 commit을 하고, 실패하면 rollback을 한다.
		 * 
		 */
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into book_table (id, title, author, price, qty)" + " values(?,?,?,?,?)";
		try {
			
			conn = dbConnect();
			conn.setAutoCommit(false);
			// 트랜잭션 처리를 위해 자동커밋 값을 false로 해준다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId() );
			pstmt.setString(2, dto.getTitle() );
			pstmt.setString(3, dto.getAuthor() );
			pstmt.setInt(4, dto.getPrice() );
			pstmt.setInt(5,  dto.getQty() );
			pstmt.executeUpdate();

			// 여기까지가 흐름이 꺠지면 안되는 작업단위일 때
			conn.commit(); // 작업완료시 커밋
		} catch (SQLException e) {
			// 수행 도중 Excpetion이 발생하면...
			try {
				conn.rollback();
			} catch (SQLException e1) {} // 롤백한다.
		} finally {
			try {
				if ( pstmt != null ) pstmt.close();
				if ( conn != null ) conn.close();
			} catch (SQLException e) {}
		}
	}
}
