package _50_Board_Module_Study_package;
import java.util.ArrayList;

import _50_Board_Module_Study_package.*;
public class MessageListObject {
	// 해당 페이지의 메시지 목록과 현재페이지, 현재페이지의 메시지 수를
	// 같이 반환해주면 좋을 것 같음...
	// 현재 페이지 목록 : messageList 
	// 현재페이지 페이지 : currentPageNumber
	// 현재페이지의 메시지 수 : messageList.size()
	// 이 내용을 반환할 수 있도록 클래스를 하나 만들어 그 객체에저장해 반환해도
	// 좋을 것 같음...
	// MessageListObject 라는 클래스로 만들자...
	
	ArrayList<MessageDTO> messageList;
	int currentPageNumber;
	int pageTotalCountNum;
	
	public MessageListObject() {
		// TODO Auto-generated constructor stub
	}
	public MessageListObject(ArrayList<MessageDTO> messageList, int currentPageNumber, int currentPageMessageNum){	
		this.messageList = messageList;
		this.currentPageNumber = currentPageNumber;
		this.pageTotalCountNum = currentPageMessageNum;
	}
	public ArrayList<MessageDTO> getMessageList() {
		return messageList;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public int getPageTotalCountNum() {
		return pageTotalCountNum;
	}
	public void setMessageList(ArrayList<MessageDTO> messageList) {
		this.messageList = messageList;
	}
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	public void setPageTotalCountNum(int pageTotalCountNum) {
		this.pageTotalCountNum = pageTotalCountNum;
	}

	
	
	
}
