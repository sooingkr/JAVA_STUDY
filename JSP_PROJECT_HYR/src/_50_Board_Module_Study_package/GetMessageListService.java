package _50_Board_Module_Study_package;
import _50_Board_Module_Study_package.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class GetMessageListService {
	final static int MESSAGE_COUNT_PER_PAGE = 3; // 페이지당 메시지3개
	private static GetMessageListService gls;
	
	private GetMessageListService(){};
	
	public static GetMessageListService getInstance(){
		if ( gls == null ){
			gls = new GetMessageListService();
		}
		return gls;
	}
	///////////////////////////////////////////
	
	// 페이지 번호에 따른 해당 페이지 메시지 목록, 현재페이지, 현재페이지수를 담은 객체를 리턴
	public MessageListObject getMessageList(int pageNumber) throws Exception {
		
		
		Connection conn = null;
		ArrayList<MessageDTO> messageList = null;
		int messageTotalCount  = 0;
		MessageListObject obj  = null;
		try {
			int currentPageNumber = pageNumber; // 현재페이지
			MessageDAO dao = MessageDAO.getInstance();
			conn = dao.getConnectionDB();
			
			messageTotalCount = dao.selectCount(); // 전체 메시지 수
			
			int firstRow = 0;
			int endRow = 0;
			
			if ( messageTotalCount > 0 ){ // 메시지수가 0이 아니면
				firstRow = (pageNumber-1)*(MESSAGE_COUNT_PER_PAGE) + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE -1;
				messageList = dao.selectList(firstRow, endRow);
				int n = (messageTotalCount/MESSAGE_COUNT_PER_PAGE);
				obj = new MessageListObject(messageList, currentPageNumber, n);
			}else { // 메시지가 하나도 없으면
				currentPageNumber = 0;
				//messageList = (ArrayList)Collections.emptyList();
				obj = new MessageListObject(null, currentPageNumber, 0);
			}
			
			return obj;
		} catch (SQLException e) {
			throw new Exception("목록 구하기 실패");
		} finally {
			try {
				if ( conn != null ) conn.close();
			} catch (Exception e) {}
		}
		
		
		
		// 해당 페이지의 메시지 목록과 현재페이지, 현재페이지의 메시지 수를
		// 같이 반환해주면 좋을 것 같음...
		// 현재 페이지 목록 : messageList 
		// 현재페이지 페이지 : currentPageNumber
		// 현재페이지의 메시지 수 : messageList.size()
		// 이 내용을 반환할 수 있도록 클래스를 하나 만들어 그 객체에저장해 반환해도
		// 좋을 것 같음...
		// MessageListObject 라는 클래스로 만들자...
	}
}
