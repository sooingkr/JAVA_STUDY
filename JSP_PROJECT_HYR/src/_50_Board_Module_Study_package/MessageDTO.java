// 블로그에 올라오는 메시지 정보를 저장할 DTO(Data Transfer Object)

package _50_Board_Module_Study_package;

public class MessageDTO {
	private int id; // 순번, 지정안하면 DB저장시 1씩 증가되도록 auto_increment 속성되어 있음.
	private String guestName; 
	private String password;
	private String message;
	
	// 방명록 메시지에 암호가 지정되어 있는지 확인한다.
	// 패스워드가 있는지 확인하는 메서드
	public boolean hasPassword() {
		return password != null && (password.length() > 0);
	}
	
	// 패스워드가 일치하는지 확인하는 메서드
	public boolean matchPassword(String pwd) {
		return password != null && password.equals(pwd);
	} // 이 두 메서드는 메시지를 삭제할 때 확인작업을 위해 사용된다.
	
	public int getId() {
		return id;
	}
	public String getGuestName() {
		return guestName;
	}
	public String getPassword() {
		return password;
	}
	public String getMessage() {
		return message;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
