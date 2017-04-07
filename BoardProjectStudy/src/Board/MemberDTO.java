// Member 정보를 저장하는 DTO
package Board;

import java.util.Date;

public class MemberDTO {
	private String id;
	private String name;
	private String password;
	private Date regDate;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String id, String name, String password, Date regDate) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
	}

	// 암호 변경기능 구현시 필요한 패스워드 일치여부 판단 메서드 정의
	public boolean matchPassword(String password){
		return (this.password.equals(password));
	}
	
	public void changePassword(String newPwd){
		this.password = newPwd;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
