// 메시지 삭제 service 클래스
package _50_Board_Module_Study_package;
import _50_Board_Module_Study_package.*;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteMessageService {
	private static DeleteMessageService ds;
	
	private DeleteMessageService() {}
	
	public static DeleteMessageService getInstance() {
		if ( ds == null ){
			ds = new DeleteMessageService();
		}
		return ds;
	}
	///////////////////////////////////////////////////////
	
	public void deleteMessage(int messageId, String password) throws Exception {
		Connection conn = null;
		MessageDAO dao = MessageDAO.getInstance();
		
		try {
			
			conn = dao.getConnectionDB();
			conn.setAutoCommit(false);
			
			MessageDTO message = dao.selectMessage(messageId); // 메시지번호에 해당하는 메시지를 가져옴
			if ( message == null ){
				throw new Exception("메시지 없음");
			}
			if ( !message.matchPassword(password)){ // 메시지에 설정된 비밀번호와 일치해야만 삭제할 수 있도록...
				throw new Exception("bad password");
			}
			dao.delete(messageId); // 위에서 exception이 발생되지 않았으면
			// 이걸 실행할 수 있음... 삭제...
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
		}finally {
			try {
				if ( conn != null ) conn.close();
			} catch (Exception e) {}
		}
	}
}
