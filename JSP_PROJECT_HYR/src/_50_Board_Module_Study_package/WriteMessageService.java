// 글작성 관련 서비스를 처리하는 service 클래스 페이지.
package _50_Board_Module_Study_package;

import java.sql.Connection;
import java.sql.SQLException;

import _50_Board_Module_Study_package.*;

public class WriteMessageService {
	private static WriteMessageService ws;

	private WriteMessageService() {
	}

	public static WriteMessageService getInstance() {
		if (ws == null) {
			ws = new WriteMessageService();
		}
		return ws;
	}

	public void write(MessageDTO message) throws Exception {
		Connection conn = null;
		try {
			MessageDAO dao = MessageDAO.getInstance();
			conn = dao.getConnectionDB();
			
			dao.insert(message); // DB에 삽입...
			
		} catch (SQLException e) {
			throw new Exception("메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			if ( conn != null ) conn.close();
		}

	}
}
